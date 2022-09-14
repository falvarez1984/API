package ar.com.fernandoalvarez.api.service;

import ar.com.fernandoalvarez.api.dto.response.UsuarioResponseDto;
import ar.com.fernandoalvarez.api.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface UsuarioService {

    public List<UsuarioResponseDto> obtenerTodos();

    Page<UsuarioResponseDto> obtenerTodos(Specification<Usuario> spec, Pageable pag);

}
