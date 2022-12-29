package ar.com.fernandoalvarez.api.controllerimpl;

import ar.com.fernandoalvarez.api.controller.UserEntityController;
import ar.com.fernandoalvarez.api.dto.request.UserEntityRequestDto;
import ar.com.fernandoalvarez.api.dto.response.UserEntityResponseDto;
import ar.com.fernandoalvarez.api.model.UserEntity;
import ar.com.fernandoalvarez.api.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userEntity")
@RequiredArgsConstructor
public class UserEntityControllerImpl implements UserEntityController {

    @Autowired
    UserEntityService userEntityService;

    @PostMapping
    public ResponseEntity<UserEntityResponseDto> nuevoUsuarioSecurity(@RequestBody UserEntityRequestDto newUser) {
        return new ResponseEntity<UserEntityResponseDto>(this.userEntityService.nuevoUsuario(newUser), HttpStatus.CREATED);
    }

}
