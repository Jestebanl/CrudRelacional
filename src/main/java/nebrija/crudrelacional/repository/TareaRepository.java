package nebrija.crudrelacional.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import nebrija.crudrelacional.model.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
    Optional<Tarea> findByTitulo(String nombre);
}
