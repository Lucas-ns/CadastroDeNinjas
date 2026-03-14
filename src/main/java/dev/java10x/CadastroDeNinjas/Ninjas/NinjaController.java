package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @PostMapping("/criar")
    public String criarNinja() {
        return "Criando ninjas";
    }

    @GetMapping("/listar")
    public String listarNinjas() {
        return "Lista com todos os ninjas";
    }

    @GetMapping("/listarID")
    public String ninjaPorId() {
        return "Ninja por ID";
    }

    @PutMapping("/atualizar")
    public String atualizarNinja() {
        return "Atualizar Ninja por ID";
    }

    @DeleteMapping("/deletar")
    public String deletarNinja() {
        return "Deletar Ninja por ID";
    }


}
