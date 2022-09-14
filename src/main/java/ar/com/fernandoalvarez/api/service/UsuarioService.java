package ar.com.fernandoalvarez.api.service;

import ar.com.fernandoalvarez.api.dto.response.UsuarioResponseDto;
import ar.com.fernandoalvarez.api.model.Usuario;

import java.util.List;

public interface UsuarioService {

    public List<UsuarioResponseDto> obtenerTodos();

}
