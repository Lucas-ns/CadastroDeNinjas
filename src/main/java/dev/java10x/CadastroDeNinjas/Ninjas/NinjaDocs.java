package dev.java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

public interface NinjaDocs {

    @Operation(summary = "Criar novo ninja", description = "Rota para criar um novo ninja no banco de dados")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Ninja criado com sucesso.",
                    content = {
                            @Content(mediaType = "application/json",
                            schema = @Schema(implementation = NinjaDTO.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Falha ao criar um ninja")
    })
    public ResponseEntity<String> criarNinja(
            @Parameter(description = "Dados para registrar um novo ninja", required = true)
            @RequestBody NinjaDTO ninja
    );

    @Operation(summary = "Lista todos os ninjas", description = "Rota para listar todos os ninjas do banco de dados.")
    public ResponseEntity<List<NinjaDTO>> listarNinjas();

    @Operation(summary = "Lista ninja por ID", description = "Rota utilizada para listar ninja passando ID como parâmetro.")
    public ResponseEntity<NinjaDTO> listarNinjaPorId(
            @Parameter(description = "Número do ID do ninja", required = true)
            @PathVariable Long id
    );

    @Operation(summary = "Atualizar um ninja por id", description = "Rota para atualizar um novo ninja por id no banco de dados")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Ninja atualizado com sucesso.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = NinjaDTO.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Falha ao atualizar, ninja não encontrado", content = @Content)
    })
    public ResponseEntity<NinjaDTO> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja);

    @Operation(summary = "Deletar um ninja por id", description = "Rota para deletar um novo ninja por id no banco de dados")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Ninja deletado com sucesso.",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Falha ao atualizar, ninja não encontrado", content = @Content)
    })
    public ResponseEntity<HashMap<String, Object>> deletarNinja(@PathVariable Long id);
}
