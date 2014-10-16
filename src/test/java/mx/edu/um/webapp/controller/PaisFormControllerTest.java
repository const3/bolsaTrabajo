package mx.edu.um.webapp.controller;

import mx.edu.um.webapp.controller.BaseControllerTestCase;
import mx.edu.um.model.Pais;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaisFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private PaisFormController form;
    private Pais pais;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/paisform");
        request.addParameter("id", "-1");

        pais = form.showForm(request);
        assertNotNull(pais);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/paisform");
        request.addParameter("id", "-1");

        pais = form.showForm(request);
        assertNotNull(pais);

        request = newPost("/paisform");

        pais = form.showForm(request);
        // update required fields
        pais.setNombre("PvCzTjDsPtNuFtWdWuDcTeGlEpAlIzImJlSjAwHoXjZdZhSmDy");

        BindingResult errors = new DataBinder(pais).getBindingResult();
        form.onSubmit(pais, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/paisform");
        request.addParameter("delete", "");
        pais = new Pais();
        pais.setId(-2L);

        BindingResult errors = new DataBinder(pais).getBindingResult();
        form.onSubmit(pais, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
