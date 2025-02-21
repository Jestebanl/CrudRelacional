package nebrija.crudrelacional.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nebrija.crudrelacional.model.Proyecto;
import nebrija.crudrelacional.model.Tarea;
import nebrija.crudrelacional.service.ProyectoService;
import nebrija.crudrelacional.service.TareaService;


@Controller
@RequestMapping("/admin/tareas")
public class TareaAdminController {
    private final TareaService tareaService;
    private final ProyectoService proyectoService;

    public TareaAdminController(TareaService tareaService, ProyectoService proyectoService) {
        this.tareaService = tareaService;
        this.proyectoService = proyectoService;
    }

    @GetMapping("/crear")
    public String crearFormTarea(Model model) {
        model.addAttribute("tarea", new Tarea());
        List<Proyecto> proyectos = proyectoService.listarProyectos();
        model.addAttribute("proyectos", proyectos);
        return "tarea/crear";
    }

    @PostMapping
    public String guardarTarea(@ModelAttribute Tarea tarea, Long idProyecto) {
        Proyecto proyecto = proyectoService.obtenerProyectoPorId(tarea.getProyecto().getId());
        tarea.setProyecto(proyecto);
        tareaService.agregarTarea(tarea);
        return "redirect:/user/tareas";
    }

    @GetMapping("/editar/{id}")
    public String editarFormTarea(@PathVariable Long id, Model model) {
        Tarea tarea = tareaService.obtenerTareaPorId(id);
        model.addAttribute("tarea", tarea);
        List<Proyecto> proyectos = proyectoService.listarProyectos();
        model.addAttribute("proyectos", proyectos);
        return "tarea/editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarTarea(@PathVariable Long id, @ModelAttribute Tarea tarea, Long idProyecto) {
        Proyecto proyecto = proyectoService.obtenerProyectoPorId(tarea.getProyecto().getId());
        tarea.setProyecto(proyecto);
        tareaService.modificarTarea(id, tarea);
        return "redirect:/user/tareas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTarea(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
        return "redirect:/user/tareas";
    }
}