package nebrija.crudrelacional.controller;

import nebrija.crudrelacional.model.Proyecto;
import nebrija.crudrelacional.service.ProyectoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/proyectos")
public class ProyectoAdminController {
    private final ProyectoService proyectoService;

    public ProyectoAdminController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @GetMapping("/crear")
    public String crearFormProyecto(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        return "proyecto/crear";
    }

    @PostMapping
    public String guardarProyecto(@ModelAttribute Proyecto proyecto) {
        proyectoService.agregarProyecto(proyecto);
        return "redirect:/user/proyectos";
    }

    @GetMapping("/editar/{id}")
    public String editarFormProyecto(@PathVariable Long id, Model model) {
        Proyecto proyecto = proyectoService.obtenerProyectoPorId(id);
        model.addAttribute("proyecto", proyecto);
        return "proyecto/editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarProyecto(@PathVariable Long id, @ModelAttribute Proyecto proyecto) {
        proyectoService.modificarProyecto(id, proyecto);
        return "redirect:/user/proyectos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProyecto(@PathVariable Long id) {
        proyectoService.eliminarProyecto(id);
        return "redirect:/user/proyectos";
    }
}