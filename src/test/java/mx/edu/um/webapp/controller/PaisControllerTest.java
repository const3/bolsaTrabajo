package mx.edu.um.webapp.controller;

import mx.edu.um.service.PaisManager;
import mx.edu.um.model.Pais;

import mx.edu.um.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class PaisControllerTest extends BaseControllerTestCase {
    @Autowired
    private PaisController controller;

    @Test
    public void testHandleRequest() throws Exception {
        Model model = controller.handleRequest(null);
        Map m = model.asMap();
        assertNotNull(m.get("paisList"));
        assertTrue(((List) m.get("paisList")).size() > 0);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        PaisManager paisManager = (PaisManager) applicationContext.getBean("paisManager");
        paisManager.reindex();

        Model model = controller.handleRequest("*");
        Map m = model.asMap();
        List results = (List) m.get("paisList");
        assertNotNull(results);
        assertEquals(3, results.size());
    }
}