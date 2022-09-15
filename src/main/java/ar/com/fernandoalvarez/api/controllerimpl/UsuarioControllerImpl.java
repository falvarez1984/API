package ar.com.fernandoalvarez.api.controllerimpl;

import ar.com.fernandoalvarez.api.controller.UsuarioController;
import ar.com.fernandoalvarez.api.dto.request.UsuarioModificarRequestDto;
import ar.com.fernandoalvarez.api.dto.request.UsuarioRequestDto;
import ar.com.fernandoalvarez.api.dto.response.UsuarioResponseDto;
import ar.com.fernandoalvarez.api.helpers.Message;
import ar.com.fernandoalvarez.api.model.Usuario;
import ar.com.fernandoalvarez.api.service.UsuarioService;
import ar.com.fernandoalvarez.api.specification.UsuarioSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioControllerImpl implements UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    @GetMapping("/obtenerTodosDto")
    public ResponseEntity<List<UsuarioResponseDto>> obtenerTodosDto() {
        return new ResponseEntity<List<UsuarioResponseDto>>(this.usuarioService.obtenerTodosDto(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/obtenerTodos")
    public ResponseEntity<List<Usuario>> obtenerTodos() {
        return new ResponseEntity<List<Usuario>>(this.usuarioService.obtenerTodos(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/paginado")
    public Page<UsuarioResponseDto> obtenerTodos(UsuarioSpecification spec, Pageable pag) {
        return this.usuarioService.obtenerTodos(spec, pag);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> obtenerPorId(Long id) {
        return new ResponseEntity<UsuarioResponseDto>(this.usuarioService.obtenerPorId(id), HttpStatus.OK);
    }

    @Override
    @PostMapping("/nuevo")
    public ResponseEntity<Message> nuevoUsuario(UsuarioRequestDto usuarioRequestDto) {
        return new ResponseEntity<Message>(this.usuarioService.nuevo(usuarioRequestDto), HttpStatus.OK);
    }

    @Override
    @PutMapping("/modificar/{id}")
    public ResponseEntity<Usuario> modificarUsuario(Long id, @RequestBody UsuarioModificarRequestDto usuarioModificarRequestDto) {
        return new ResponseEntity<Usuario>(
                this.usuarioService.modificarUsuario(id, usuarioModificarRequestDto), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Message> eliminarUsuario(Long id) {
        return new ResponseEntity<Message>(this.usuarioService.eliminarUsuario(id), HttpStatus.OK);
    }

}
