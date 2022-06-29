package com.examenWeb.controller;

import com.examenWeb.entity.Cantante;
import com.examenWeb.entity.Lugar;
import com.examenWeb.service.ICantanteService;
import com.examenWeb.service.ILugarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Ariana
 */
@Controller
public class CantanteController {

    @Autowired
    private ICantanteService personaService;

    @Autowired
    private ILugarService paisService;

    @GetMapping("/concierto")
    public String index(Model model) {
        List<Cantante> listaCantante = personaService.getAllConcert();
        model.addAttribute("titulo", "Tabla Conciertos");
        model.addAttribute("cantantes", listaCantante);
        return "cantante";
    }

    @GetMapping("/conciertoN")
    public String craerConcierto(Model model) {
        List<Lugar> listaLugares = paisService.LugarProvince();
        model.addAttribute("Concierto", new Cantante());
        model.addAttribute("Lugar", listaLugares);
        return "agregar";
    }

    @PostMapping("/save")
    public String guardarConcierto(@ModelAttribute Cantante cantante) {
        personaService.saveCantante(cantante);
        return "redirect:/cantante";
    }

    @GetMapping("/editCantante/{id}")
    public String editarPersona(@PathVariable("id") Long idPersona, Model model) {
        Cantante cantante = personaService.getConcertById(idPersona);
        List<Lugar> listaLugares = paisService.LugarProvince();
        model.addAttribute("cantate", cantante);
        model.addAttribute("lugar", listaLugares);
        return "agregar";
    }

    @GetMapping("/delete/{id}")
    public String eliminarCantante(@PathVariable("id") Long idCantante, Model model) {
        personaService.delete(idCantante);
        return "redirect:/cantante";
    }
}
