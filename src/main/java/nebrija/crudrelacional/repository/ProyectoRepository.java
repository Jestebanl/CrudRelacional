package nebrija.crudrelacional.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import nebrija.crudrelacional.model.Proyecto;
import java.util.Optional;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    Optional<Proyecto> findByNombre(String nombre);
}
