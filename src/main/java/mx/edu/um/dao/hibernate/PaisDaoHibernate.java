package mx.edu.um.dao.hibernate;

import mx.edu.um.model.Pais;
import mx.edu.um.dao.PaisDao;
import mx.edu.um.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("paisDao")
public class PaisDaoHibernate extends GenericDaoHibernate<Pais, Long> implements PaisDao {

    public PaisDaoHibernate() {
        super(Pais.class);
    }
}
