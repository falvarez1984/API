package ar.com.fernandoalvarez.api.controller;

import ar.com.fernandoalvarez.api.dto.request.UsuarioModificarRequestDto;
import ar.com.fernandoalvarez.api.dto.request.UsuarioRequestDto;
import ar.com.fernandoalvarez.api.dto.response.UsuarioResponseDto;
import ar.com.fernandoalvarez.api.exception.ErrorDetails;
import ar.com.fernandoalvarez.api.helpers.Message;
import ar.com.fernandoalvarez.api.model.Usuario;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Usuarios", description = "CRUD de usuarios")
public interface UsuarioController {

    @Operation(summary = "Consultar todos los usuarios (devuelve un Dto).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Los usuarios se consultaron exitosamente", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "La petición es inválida", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "404", description = "Error al consultar usuarios", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta", content = @Content(schema = @Schema(implementation = ErrorDetails.class)))})
    public ResponseEntity<List<UsuarioResponseDto>> obtenerTodosDto();

    @Operation(summary = "Consultar todos los usuarios (devuelve la entidad completa).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Los usuarios se consultaron exitosamente", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "La petición es inválida", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "404", description = "Error al consultar usuarios", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta", content = @Content(schema = @Schema(implementation = ErrorDetails.class)))})
    public ResponseEntity<List<Usuario>> obtenerTodos();

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

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El usuario fue consultado correctamente", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "La petición es inválida", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "404", description = "El usuario con el ID no existe", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta", content = @Content(schema = @Schema(implementation = ErrorDetails.class)))})
    @Operation(summary = "Obtener un usuario por id.")
    public ResponseEntity<UsuarioResponseDto> obtenerPorId(@PathVariable Long id);

    @Operation(summary = "Generar nuevo usuario.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El nuevo usuario fue creado correctamente", content = @Content(schema = @Schema(implementation = Message.class))),
            @ApiResponse(responseCode = "400", description = "La petición es inválida", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta", content = @Content(schema = @Schema(implementation = ErrorDetails.class)))})
    public ResponseEntity<Message> nuevoUsuario(@Valid @RequestBody UsuarioRequestDto usuarioRequestDto);

    @Operation(summary = "Modificar un usuario.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El usuario fue modificado correctamente", content = @Content(schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "La petición es inválida", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "404", description = "El usuario no existe", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta", content = @Content(schema = @Schema(implementation = ErrorDetails.class))) })
    public ResponseEntity<Usuario> modificarUsuario(@PathVariable Long id, @RequestBody UsuarioModificarRequestDto usuarioModificarRequestDto);

    @Operation(summary = "Eliminar un usuario.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El usuario fue eliminado correctamente", content = @Content(schema = @Schema(implementation = Message.class))),
            @ApiResponse(responseCode = "400", description = "La petición es inválida", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "404", description = "El usuario no existe", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta", content = @Content(schema = @Schema(implementation = ErrorDetails.class))) })
    public ResponseEntity<Message> eliminarUsuario(@PathVariable Long id);

}
