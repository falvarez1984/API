package ar.com.fernandoalvarez.api.controllerimpl;

import ar.com.fernandoalvarez.api.controller.UsuarioController;
import ar.com.fernandoalvarez.api.dto.response.UsuarioResponseDto;
import ar.com.fernandoalvarez.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioControllerImpl implements UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/obtenerTodos")
    public ResponseEntity<List<UsuarioResponseDto>> obtenerTodos() {
        return new ResponseEntity<List<UsuarioResponseDto>>(this.usuarioService.obtenerTodos(), HttpStatus.OK);
    }

}
