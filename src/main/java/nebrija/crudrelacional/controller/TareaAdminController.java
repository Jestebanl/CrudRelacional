package nebrija.crudrelacional.controller;

import nebrija.crudrelacional.model.Tarea;
import nebrija.crudrelacional.service.TareaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/tareas")
public class TareaAdminController {
    private final TareaService tareaService;

    public TareaAdminController(TareaService tareaService) { this.tareaService = tareaService; }

    @GetMapping("/tareas/crear")
    public String crearFormTarea(Model model) {
        model.addAttribute("tarea", new Tarea());
        return "tareas/crear";
    }

    @PostMapping
    public String guardarTarea(@ModelAttribute Tarea tarea) {
        tareaService.agregarTarea(tarea);
        return "redirect:/user/tareas";
    }

    @GetMapping("/tareas/editar/{id}")
    public String editarFormTarea(@PathVariable Long id, Model model) {
        Tarea tarea = tareaService.obtenerTareaPorId(id);
        model.addAttribute("tareas", tarea);
        return "tareas/editar";
    }

    @PostMapping("/tareas/actualizar/{id}")
    public String actualizarTarea(@PathVariable Long id, @ModelAttribute Tarea tarea) {
        tareaService.modificarTarea(id, tarea);
        return "redirect:/user/tareas";
    }

    @GetMapping("/tareas/eliminar/{id}")
    public String eliminarTarea(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
        return "redirect:/user/tareas";
    }
    
}
