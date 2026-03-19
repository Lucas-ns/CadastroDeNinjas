package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    final private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @GetMapping("/listar")
    public List<MissaoModel> listarMissoes() {
        return missaoService.listarMissoes();
    }
    @GetMapping("/listar/{id}")
    public MissaoModel listarMissaoPorId(@PathVariable Long id) {
        return missaoService.listarMissaoPorId(id);
    }

    @PostMapping("/criar")
    public String criarMissao() {
        return "Missão criada";
    }

    @PutMapping("/atualizar")
    public String atualizarMissao() {
        return "Atualizar missao";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Deletar missão";
    }
}
