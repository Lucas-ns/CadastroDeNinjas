package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    @GetMapping("/listar")
    public String listarMissoes() {
        return "Lista de missões";
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
