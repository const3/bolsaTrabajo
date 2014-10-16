package mx.edu.um.dao;

import mx.edu.um.dao.BaseDaoTestCase;
import mx.edu.um.model.Pais;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PaisDaoTest extends BaseDaoTestCase {
    @Autowired
    private PaisDao paisDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemovePais() {
        Pais pais = new Pais();

        // enter all required fields
        pais.setNombre("RuYaKzYtDiLxHsWtUrUlMzZzSdCaZdRtGgAfXkQzHmVhRtBzMg");

        log.debug("adding pais...");
        pais = paisDao.save(pais);

        pais = paisDao.get(pais.getId());

        assertNotNull(pais.getId());

        log.debug("removing pais...");

        paisDao.remove(pais.getId());

        // should throw DataAccessException 
        paisDao.get(pais.getId());
    }
}