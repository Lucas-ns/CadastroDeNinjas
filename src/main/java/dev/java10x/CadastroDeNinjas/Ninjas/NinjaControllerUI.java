package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissaoModel;
import dev.java10x.CadastroDeNinjas.Missoes.MissaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUI {
    private final NinjaService ninjaService;
    private final MissaoService missaoService;
    private final NinjaMapper mapper;

    public NinjaControllerUI(NinjaService ninjaService, MissaoService missaoService, NinjaMapper mapper) {
        this.ninjaService = ninjaService;
        this.missaoService = missaoService;
        this.mapper = mapper;
    }

    @GetMapping("/listar")
    public String listarNinjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas";
    }

    @GetMapping("/detalhes/{id}")
    public String detalharNinja(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        model.addAttribute("ninja", ninja);
        return "detalharNinja";
    }

    @GetMapping("/criar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("ninja", new NinjaModel());
        model.addAttribute("missoes", missaoService.listarMissoes());
        return "registrarNinja";
    }

    @PostMapping("/criar")
    public String enviarFormulario(@ModelAttribute("ninja") NinjaModel ninja, @ModelAttribute("missao") MissaoModel missao) {
        MissaoModel missaoModel = missaoService.listarMissaoPorId(missao.getId());
        ninja.setMissao(missaoModel);
        NinjaDTO ninjaDto = ninjaService.criarNinja(mapper.toDto(ninja));
        System.out.println("Ninja cadastrado com sucesso " + ninjaDto.nome());
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarNinja(@PathVariable Long id) {
        ninjaService.deletarNinja(id);
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        model.addAttribute("ninja", mapper.toEntity(ninja));
        model.addAttribute("missoes", missaoService.listarMissoes());
        return "registrarNinja";
    }

    @PutMapping("/alterar/{id}")
    public String alterarNinja(@PathVariable Long id, @ModelAttribute("ninja") NinjaModel ninjaEditado) {
        if (ninjaEditado.getMissao() != null && ninjaEditado.getMissao().getId() != null) {
            MissaoModel missao = missaoService.listarMissaoPorId(ninjaEditado.getMissao().getId());
            ninjaEditado.setMissao(missao);
        }

        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        NinjaModel ninjaModel = mapper.toEntity(ninja);
        ninjaModel.setId(ninja.id());

        if (ninjaEditado.getNome() != null) {
            ninjaModel.setNome(ninjaEditado.getNome());
        }
        if (ninjaEditado.getEmail() != null) {
            ninjaModel.setEmail(ninjaEditado.getEmail());
        }
        if (ninjaEditado.getIdade() != null) {
            ninjaModel.setIdade(ninjaEditado.getIdade());
        }
        if (ninjaEditado.getImageUrl() != null) {
            ninjaModel.setImageUrl(ninjaEditado.getImageUrl());
        }
        if (ninjaEditado.getRank() != null) {
            ninjaModel.setRank(ninjaEditado.getRank());
        }
        if (ninjaEditado.getMissao() != null) {
            ninjaModel.setMissao(ninjaEditado.getMissao());
        } else {
            ninjaModel.setMissao(null);
        }

        ninjaService.atualizarNinja(id, mapper.toDto(ninjaModel));
        return "redirect:/ninjas/ui/listar";
    }
}
