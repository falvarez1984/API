package ar.com.fernandoalvarez.api.controller;

import ar.com.fernandoalvarez.api.dto.request.UserEntityRequestDto;
import ar.com.fernandoalvarez.api.dto.response.UserEntityResponseDto;
import ar.com.fernandoalvarez.api.exception.ErrorDetails;
import ar.com.fernandoalvarez.api.model.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "UsuariosSeguridad", description = "Gestión de usuarios de seguridad")
public interface UserEntityController {

    @Operation(summary = "Generar nuevo usuario.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "El nuevo usuario de acceso fue creado correctamente", content = @Content(schema = @Schema(implementation = UserEntityResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "La petición es inválida", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta", content = @Content(schema = @Schema(implementation = ErrorDetails.class)))})
    public ResponseEntity<UserEntityResponseDto> nuevoUsuarioSecurity(@RequestBody UserEntityRequestDto newUser);

}
