package ar.com.fernandoalvarez.api.controller;

import ar.com.fernandoalvarez.api.dto.response.UsuarioResponseDto;
import ar.com.fernandoalvarez.api.exception.ErrorDetails;
import ar.com.fernandoalvarez.api.specification.UsuarioSpecification;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Usuarios", description = "CRUD de usuarios")
public interface UsuarioController {

    @Operation(summary = "Consultar todos los usuarios.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Los usuarios se consultaron exitosamente", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "La petición es inválida", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "404", description = "Error al consultar usuarios", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta", content = @Content(schema = @Schema(implementation = ErrorDetails.class)))})
    public ResponseEntity<List<UsuarioResponseDto>> obtenerTodos();

    @Parameters({
            @Parameter(name = "page", description = "Número de página (0..N).", required = true, in = ParameterIn.QUERY, schema = @Schema(type = "integer", defaultValue = "0")),
            @Parameter(name = "size", description = "Número de registros por página.", required = true, in = ParameterIn.QUERY, schema = @Schema(type = "integer", defaultValue = "10")),
            @Parameter(name = "spec", hidden = true), @Parameter(name = "pag", hidden = true),
            @Parameter(name = "nombre", description = "Buscar por nombre de usuario.", in = ParameterIn.QUERY, schema = @Schema(type = "string")),
            @Parameter(name = "apellido", description = "Buscar por apellido de usuario.", in = ParameterIn.QUERY, schema = @Schema(type = "string")),
            @Parameter(name = "fechaNacimientoDesde", description = "Fecha de nacimiento desde. Ejemplo = 'yyyy-MM-dd'", in = ParameterIn.QUERY, schema = @Schema(type = "LocalDateTime")),
            @Parameter(name = "fechaNacimientoHasta", description = "Fecha de nacimiento hasta. Ejemplo = 'yyyy-MM-dd'", in = ParameterIn.QUERY, schema = @Schema(type = "LocalDateTime")),
            @Parameter(name = "dni", description = "Buscar por dni de usuario.", in = ParameterIn.QUERY, schema = @Schema(type = "integer"))})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Los usuarios se consultaron exitosamente", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "La petición es inválida", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "404", description = "Error al consultar usuarios", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta", content = @Content(schema = @Schema(implementation = ErrorDetails.class)))})
    @Operation(summary = "Paginado para obtener usuarios.")
    public Page<UsuarioResponseDto> obtenerTodos(UsuarioSpecification spec,
                                                 @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable);


}
