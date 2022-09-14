package ar.com.fernandoalvarez.api.controller;

import ar.com.fernandoalvarez.api.dto.response.UsuarioResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioController {

    public ResponseEntity<List<UsuarioResponseDto>> obtenerTodos();

}
