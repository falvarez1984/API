package ar.com.fernandoalvarez.api.specification;

import ar.com.fernandoalvarez.api.model.Usuario;
import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({@Spec(path = "nombre", params = "nombre", spec = LikeIgnoreCase.class),
        @Spec(path = "apellido", params = "apellido", spec = LikeIgnoreCase.class),
        @Spec(path = "fechaNacimiento", params = {"fechaNacimientoDesde",
                "fechaNacimientoHasta"}, spec = Between.class, config = "yyyy-MM-dd"),
        @Spec(path = "dni", params = "dni", spec = Equal.class)})
public interface UsuarioSpecification extends Specification<Usuario> {
}
