package ar.com.fernandoalvarez.api.service;

import ar.com.fernandoalvarez.api.dto.request.UserEntityRequestDto;
import ar.com.fernandoalvarez.api.dto.response.UserEntityResponseDto;
import ar.com.fernandoalvarez.api.model.UserEntity;

import java.util.Optional;

public interface UserEntityService {

    Optional<UserEntity> findByUserName(String username);

    UserEntityResponseDto nuevoUsuario(UserEntityRequestDto userEntity);

}
