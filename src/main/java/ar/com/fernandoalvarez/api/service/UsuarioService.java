package ar.com.fernandoalvarez.api.service;

import ar.com.fernandoalvarez.api.dto.request.UsuarioModificarRequestDto;
import ar.com.fernandoalvarez.api.dto.request.UsuarioRequestDto;
import ar.com.fernandoalvarez.api.dto.response.UsuarioResponseDto;
import ar.com.fernandoalvarez.api.helpers.Message;
import ar.com.fernandoalvarez.api.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface UsuarioService {

    public List<UsuarioResponseDto> obtenerTodosDto();

    public List<Usuario> obtenerTodos();

    public Page<UsuarioResponseDto> obtenerTodos(Specification<Usuario> spec, Pageable pag);

    public UsuarioResponseDto obtenerPorId(Long id);

    public Message nuevo(UsuarioRequestDto usuarioRequestDto);

    public Usuario modificarUsuario(Long id, UsuarioModificarRequestDto usuarioModificarRequestDto);

    public Message eliminarUsuario(Long id);

}
