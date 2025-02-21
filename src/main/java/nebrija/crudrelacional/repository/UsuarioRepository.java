package nebrija.crudrelacional.repository;

import nebrija.crudrelacional.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import nebrija.crudrelacional.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombre(String nombre);
}
