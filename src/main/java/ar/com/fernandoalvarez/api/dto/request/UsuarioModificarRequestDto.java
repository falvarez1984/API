package ar.com.fernandoalvarez.api.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModificarRequestDto {

    private Integer telefono;

    private String mail;

    private String direccion;

    private String pais;

    private String provincia;

    private String localidad;

}
