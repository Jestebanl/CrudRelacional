package nebrija.crudrelacional.controller;

import nebrija.crudrelacional.service.TareaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/tareas")
public class TareaController {
    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("tareas", tareaService.listarTareas());
        return "tarea/index";
    }
}
