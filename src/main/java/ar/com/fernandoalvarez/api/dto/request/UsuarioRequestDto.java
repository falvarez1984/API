package ar.com.fernandoalvarez.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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

    private LocalDate fechaNacimiento;

    @NotNull(message = "Fecha de inscripción no puede estar vacío")
    private LocalDate fechaInscripcion;

}
