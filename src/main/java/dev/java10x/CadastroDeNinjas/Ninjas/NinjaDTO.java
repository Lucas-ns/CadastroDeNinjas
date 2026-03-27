package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissaoModel;

public record NinjaDTO(
        Long id,
        String nome,
        String email,
        Integer idade,
        String rank,
        String imageUrl,
        MissaoModel missao
) {}
