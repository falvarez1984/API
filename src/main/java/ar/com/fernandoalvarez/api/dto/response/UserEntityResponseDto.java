package ar.com.fernandoalvarez.api.dto.response;

import lombok.Data;

import java.util.Set;

@Data
public class UserEntityResponseDto {

    private String username;
    private String avatar;
    private Set<String> roles;

}
