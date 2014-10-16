package mx.edu.um.webapp.controller;

import mx.edu.um.dao.SearchException;
import mx.edu.um.service.PaisManager;
import mx.edu.um.model.Pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/paiss*")
public class PaisController {
    private PaisManager paisManager;

    @Autowired
    public void setPaisManager(PaisManager paisManager) {
        this.paisManager = paisManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(paisManager.search(query, Pais.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(paisManager.getAll());
        }
        return model;
    }
}
