package ar.com.fernandoalvarez.api.service.serviceimpl;

import ar.com.fernandoalvarez.api.dto.request.UsuarioModificarRequestDto;
import ar.com.fernandoalvarez.api.dto.request.UsuarioRequestDto;
import ar.com.fernandoalvarez.api.dto.response.UsuarioResponseDto;
import ar.com.fernandoalvarez.api.exception.ResourceNotFoundException;
import ar.com.fernandoalvarez.api.helpers.ExcelHelper;
import ar.com.fernandoalvarez.api.helpers.Mapper;
import ar.com.fernandoalvarez.api.helpers.Message;
import ar.com.fernandoalvarez.api.model.Usuario;
import ar.com.fernandoalvarez.api.repository.UsuarioRepository;
import ar.com.fernandoalvarez.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

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

    @Override
    public UsuarioResponseDto obtenerPorId(Long id) {
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        if (usuario.isEmpty())
            throw new ResourceNotFoundException("El plan con ID = " + id + " no existe.");
        return Mapper.map(usuario, UsuarioResponseDto.class);
    }

    @Override
    public Usuario modificarUsuario(Long id, UsuarioModificarRequestDto usuarioModificarRequestDto) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El plan con ID = " + id + " no existe."));
        if (usuarioModificarRequestDto.getTelefono() != null)
            usuario.setTelefono(usuarioModificarRequestDto.getTelefono());
        if (usuarioModificarRequestDto.getMail() != null)
            usuario.setMail(usuarioModificarRequestDto.getMail());
        if (usuarioModificarRequestDto.getDireccion() != null)
            usuario.setDireccion(usuarioModificarRequestDto.getDireccion());
        if (usuarioModificarRequestDto.getPais() != null)
            usuario.setPais(usuarioModificarRequestDto.getPais());
        if (usuarioModificarRequestDto.getProvincia() != null)
            usuario.setProvincia(usuarioModificarRequestDto.getProvincia());
        if (usuarioModificarRequestDto.getLocalidad() != null)
            usuario.setLocalidad(usuarioModificarRequestDto.getLocalidad());
        return Mapper.map(usuarioRepository.save(usuario), Usuario.class);
    }

    @Override
    public Message eliminarUsuario(Long id) {

        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        if (usuario.isEmpty())
            throw new ResourceNotFoundException("El usuario con ID = " + id + " no existe.");
        this.usuarioRepository.delete(usuario.get());
        return new Message("El usuario fue eliminado satisfactoriamente");
    }

    @Override
    public InputStream findUsuarios(Integer dni) {

        List<Usuario> usuarios = null;
        if (dni == null) {
            usuarios = this.usuarioRepository.findAll();
        } else {
            usuarios = this.usuarioRepository.findByDni(dni);
        }
        ByteArrayInputStream in = ExcelHelper.exportarUsuarios(usuarios);
        return in;

    }

    @Override
    public Message nuevo(UsuarioRequestDto usuarioRequestDto) {
        Usuario usuario = Mapper.map(usuarioRequestDto, Usuario.class);
        usuarioRepository.save(usuario);
        return new Message("El usuario se creó correctamente");
    }

}
