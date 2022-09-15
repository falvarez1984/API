package ar.com.fernandoalvarez.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDto {

    @NotBlank(message = "nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "apellido no puede estar vacío")
    private String apellido;

    @NotNull(message = "dni no puede estar vacío")
    private Integer dni;

    @NotNull(message = "edad no puede estar vacío")
    private Integer edad;

    @NotNull(message = "telefono no puede estar vacío")
    private Integer telefono;

    @NotBlank(message = "mail no puede estar vacío")
    private String mail;

    @NotBlank(message = "dirección no puede estar vacío")
    private String direccion;

    private String pais;

    private String provincia;

    @NotBlank(message = "localidad no puede estar vacío")
    private String localidad;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @NotNull(message = "Fecha de inscripción no puede estar vacío")
    @Temporal(TemporalType.DATE)
    private Date fechaInscripcion;

}
