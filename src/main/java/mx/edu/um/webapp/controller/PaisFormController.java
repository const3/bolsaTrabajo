package mx.edu.um.webapp.controller;

import org.apache.commons.lang.StringUtils;
import mx.edu.um.service.PaisManager;
import mx.edu.um.model.Pais;
import mx.edu.um.webapp.controller.BaseFormController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
@RequestMapping("/paisform*")
public class PaisFormController extends BaseFormController {
    private PaisManager paisManager = null;

    @Autowired
    public void setPaisManager(PaisManager paisManager) {
        this.paisManager = paisManager;
    }

    public PaisFormController() {
        setCancelView("redirect:paiss");
        setSuccessView("redirect:paiss");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Pais showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return paisManager.get(new Long(id));
        }

        return new Pais();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Pais pais, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(pais, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "paisform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (pais.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            paisManager.remove(pais.getId());
            saveMessage(request, getText("pais.deleted", locale));
        } else {
            paisManager.save(pais);
            String key = (isNew) ? "pais.added" : "pais.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:paisform?id=" + pais.getId();
            }
        }

        return success;
    }
}
