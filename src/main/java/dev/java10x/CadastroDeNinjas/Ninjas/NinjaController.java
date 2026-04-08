package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController implements NinjaDocs {

    final private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: " + novoNinja.nome() + " (ID) " + novoNinja.id());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        return ResponseEntity.ok(ninjaService.listarNinjas());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<NinjaDTO> listarNinjaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ninjaService.listarNinjaPorId(id));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<NinjaDTO> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        return ResponseEntity.ok(ninjaService.atualizarNinja(id, ninja));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<HashMap<String, Object>> deletarNinja(@PathVariable Long id) {
        HashMap<String, Object> response = new HashMap<>();
        NinjaDTO ninjaParaDeletar = ninjaService.listarNinjaPorId(id);
        if (ninjaParaDeletar == null) {
            response.put("message", "Ninja de ID " + id + " não foi encontrado");
            response.put("status", HttpStatus.NOT_FOUND.value());
            response.put("error", "NOT_FOUND");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        response.put("message", "Ninja de ID " + ninjaParaDeletar.id() + " deletado com sucesso");
        response.put("status", HttpStatus.NO_CONTENT);
        ninjaService.deletarNinja(id);
        return ResponseEntity.ok(response);
    }


}
