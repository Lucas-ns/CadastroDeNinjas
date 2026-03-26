package dev.java10x.CadastroDeNinjas.Ninjas;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    final private NinjaRepository ninjaRepository;
    final private NinjaMapper mapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper mapper) {
        this.ninjaRepository = ninjaRepository;
        this.mapper = mapper;
    }

    public List<NinjaDTO> listarNinjas() {
        return ninjaRepository.findAll().stream().map(mapper::toDto).toList();
    }

    public NinjaDTO listarNinjaPorId(Long id) {
        NinjaDTO ninjaPorId = mapper.toDto(ninjaRepository.findById(id).orElse(null));
        return ninjaPorId;
    }

    public NinjaDTO criarNinja(NinjaDTO ninja) {
        NinjaModel ninjaModel = mapper.toEntity(ninja);
        return mapper.toDto(ninjaRepository.save(ninjaModel));
    }

    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninja) {
        if (!ninjaRepository.existsById(id)) {
            return null;
        }
        NinjaModel ninjaModel = mapper.toEntity(ninja);
        ninjaModel.setId(id);
        return mapper.toDto(ninjaRepository.save(ninjaModel));
    }

}
