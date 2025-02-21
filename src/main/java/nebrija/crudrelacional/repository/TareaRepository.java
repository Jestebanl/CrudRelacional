package nebrija.crudrelacional.repository;

import nebrija.crudrelacional.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import nebrija.crudrelacional.model.Tarea;

import java.util.Optional;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
    Optional<Tarea> findByNombre(String nombre);
}
