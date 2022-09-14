package ar.com.fernandoalvarez.api.serviceimpl;

import ar.com.fernandoalvarez.api.dto.response.UsuarioResponseDto;
import ar.com.fernandoalvarez.api.helpers.Mapper;
import ar.com.fernandoalvarez.api.model.Usuario;
import ar.com.fernandoalvarez.api.repository.UsuarioRepository;
import ar.com.fernandoalvarez.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioResponseDto> obtenerTodos() {
        List<Usuario> usuarios = this.usuarioRepository.findAll();
        return Mapper.mapAll(usuarios, UsuarioResponseDto.class);
    }

}
