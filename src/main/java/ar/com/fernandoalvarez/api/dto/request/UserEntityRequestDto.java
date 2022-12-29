package ar.com.fernandoalvarez.api.dto.request;

import lombok.Data;

@Data
public class UserEntityRequestDto {

    private String username;
    private String avatar;
    private String password;
    private String password2;

}
