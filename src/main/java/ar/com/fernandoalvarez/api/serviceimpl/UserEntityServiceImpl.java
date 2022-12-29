package ar.com.fernandoalvarez.api.serviceimpl;

import ar.com.fernandoalvarez.api.dto.request.UserEntityRequestDto;
import ar.com.fernandoalvarez.api.dto.response.UserEntityResponseDto;
import ar.com.fernandoalvarez.api.exception.ResourceBadRequestException;
import ar.com.fernandoalvarez.api.helpers.Mapper;
import ar.com.fernandoalvarez.api.model.UserEntity;
import ar.com.fernandoalvarez.api.model.UserRole;
import ar.com.fernandoalvarez.api.repository.UserEntityRepository;
import ar.com.fernandoalvarez.api.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserEntityServiceImpl implements UserEntityService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    UserEntityRepository userEntityRepository;

    @Override
    public Optional<UserEntity> findByUserName(String username) {
        return this.userEntityRepository.findByUsername(username);
    }

    @Override
    public UserEntityResponseDto nuevoUsuario(UserEntityRequestDto userEntity) {
        Optional<UserEntity> userEncontrado = this.userEntityRepository.findByUsername(userEntity.getUsername());
        if(userEncontrado.isPresent())
            throw new ResourceBadRequestException("El usaurio que intenta ingresar ya existe");
        if(!(userEntity.getPassword().contentEquals(userEntity.getPassword2())))
            throw new ResourceBadRequestException("Las contraseñas ingresadas no son iguales");
        UserEntity userEntityNuevo = new UserEntity();
        userEntityNuevo.setUsername(userEntity.getUsername());
        userEntityNuevo.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntityNuevo.setAvatar(userEntity.getAvatar());
        userEntityNuevo.setRoles(Stream.of(UserRole.USER).collect(Collectors.toSet()));
        this.userEntityRepository.save(userEntityNuevo);
        return Mapper.map(userEntityNuevo, UserEntityResponseDto.class);
    }

}
