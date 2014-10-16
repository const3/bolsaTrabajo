package mx.edu.um.service;

import mx.edu.um.service.GenericManager;
import mx.edu.um.model.Pais;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface PaisManager extends GenericManager<Pais, Long> {
    
}