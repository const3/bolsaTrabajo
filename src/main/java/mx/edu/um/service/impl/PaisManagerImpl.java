package mx.edu.um.service.impl;

import mx.edu.um.dao.PaisDao;
import mx.edu.um.model.Pais;
import mx.edu.um.service.PaisManager;
import mx.edu.um.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("paisManager")
@WebService(serviceName = "PaisService", endpointInterface = "mx.edu.um.service.PaisManager")
public class PaisManagerImpl extends GenericManagerImpl<Pais, Long> implements PaisManager {
    PaisDao paisDao;

    @Autowired
    public PaisManagerImpl(PaisDao paisDao) {
        super(paisDao);
        this.paisDao = paisDao;
    }
}