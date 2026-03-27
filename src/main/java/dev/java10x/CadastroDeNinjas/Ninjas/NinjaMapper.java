package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissaoModel;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    public NinjaDTO toDto(NinjaModel ninjaModel) {
        return new NinjaDTO(
                ninjaModel.getId(),
                ninjaModel.getNome(),
                ninjaModel.getEmail(),
                ninjaModel.getIdade(),
                ninjaModel.getRank(),
                ninjaModel.getImageUrl(),
                ninjaModel.getMissao()
        );
    }

    public NinjaModel toEntity(NinjaDTO ninjaDTO) {
        return new NinjaModel(
                ninjaDTO.id(),
                ninjaDTO.nome(),
                ninjaDTO.idade(),
                ninjaDTO.email(),
                ninjaDTO.imageUrl(),
                ninjaDTO.rank(),
                ninjaDTO.missao()
        );
    }
}
