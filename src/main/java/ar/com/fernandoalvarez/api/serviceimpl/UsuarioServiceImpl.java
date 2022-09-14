package ar.com.fernandoalvarez.api.serviceimpl;

import ar.com.fernandoalvarez.api.dto.response.UsuarioResponseDto;
import ar.com.fernandoalvarez.api.helpers.Mapper;
import ar.com.fernandoalvarez.api.model.Usuario;
import ar.com.fernandoalvarez.api.repository.UsuarioRepository;
import ar.com.fernandoalvarez.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioResponseDto> obtenerTodosDto() {
        List<Usuario> usuarios = this.usuarioRepository.findAll();
        return Mapper.mapAll(usuarios, UsuarioResponseDto.class);
    }

    @Override
    public List<Usuario> obtenerTodos() {
        List<Usuario> usuarios = this.usuarioRepository.findAll();
        return usuarios;
    }

    @Override
    public Page<UsuarioResponseDto> obtenerTodos(Specification<Usuario> spec, Pageable pag) {
        return this.usuarioRepository.findAll(spec, pag).map(usuario -> Mapper.map(usuario, UsuarioResponseDto.class));
    }

}
