package nebrija.crudrelacional.service;

import nebrija.crudrelacional.model.Tarea;
import nebrija.crudrelacional.repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) { this.tareaRepository = tareaRepository; }

    public List<Tarea> listarTareas() { return this.tareaRepository.findAll(); }

    public Tarea obtenerTareaPorId(Long id) {
        return tareaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
    }

    public Tarea obtenerTareaPorTitulo(String titulo) {
        return tareaRepository.findByTitulo(titulo).orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
    }

    public void agregarTarea(Tarea tarea) {
        if(tarea.getId() == null)
            tareaRepository.save(tarea);
    }

    public void eliminarTarea(Tarea tarea) {
        tareaRepository.delete(tarea);
    }

    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }

    public void modificarTarea(Long id, Tarea tareaActualizado) {
        Tarea tarea = obtenerTareaPorId(id);
        tarea.setTitulo(tareaActualizado.getTitulo());
        tarea.setDescripcion(tareaActualizado.getDescripcion());
        tarea.setEstado(tareaActualizado.getEstado());
        tareaRepository.save(tarea);
    }

}
