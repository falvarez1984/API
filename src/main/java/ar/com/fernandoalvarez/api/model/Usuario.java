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

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "DNI")
    private Integer dni;

    @Column(name = "EDAD")
    private Integer edad;

    @Column(name = "TELEFONO")
    private Integer telefono;

    @Column(name = "MAIL")
    private String mail;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "PAIS")
    private String pais;

    @Column(name = "PROVINCIA")
    private String provincia;

    @Column(name = "LOCALIDAD")
    private String localidad;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_INSCRIPCION")
    private Date fechaInscripcion;

}
