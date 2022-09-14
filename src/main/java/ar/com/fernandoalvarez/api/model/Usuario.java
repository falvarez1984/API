package ar.com.fernandoalvarez.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "NOMBRE")
    private String nombre;

    @NotNull
    @Column(name = "APELLIDO")
    private String apellido;

    @NotNull
    @Column(name = "DNI")
    private Integer dni;

    @NotNull
    @Column(name = "EDAD")
    private Integer edad;

    @NotNull
    @Column(name = "TELEFONO")
    private Integer telefono;

    @NotNull
    @Column(name = "MAIL")
    private String mail;

    @NotNull
    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "PAIS")
    private String pais;

    @Column(name = "PROVINCIA")
    private String provincia;

    @NotNull
    @Column(name = "LOCALIDAD")
    private String localidad;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_INSCRIPCION")
    private Date fechaInscripcion;

}
