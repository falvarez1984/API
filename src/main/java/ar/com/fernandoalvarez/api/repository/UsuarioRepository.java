package ar.com.fernandoalvarez.api.repository;

import ar.com.fernandoalvarez.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {



}
