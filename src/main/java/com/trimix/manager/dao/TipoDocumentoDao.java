package com.trimix.manager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trimix.manager.exception.EntityNotFoundException;
import com.trimix.manager.model.TipoDocumento;

@Repository
public class TipoDocumentoDao {

    @Autowired
    private SessionFactory sessionFactory;

    public int save(TipoDocumento tipoDocumento) throws Exception {
        sessionFactory.getCurrentSession().save(tipoDocumento);
        return tipoDocumento.getTpoId();
    }

    public TipoDocumento get(int id) throws EntityNotFoundException, Exception {
        TipoDocumento p = sessionFactory.getCurrentSession().get(TipoDocumento.class, id);
        if (p == null) {
            throw new EntityNotFoundException("id: {" + String.valueOf(id) + "} no existe");
        }
        return p;
    }

    @SuppressWarnings("unchecked")
    public List<TipoDocumento> list() throws Exception {
        return sessionFactory.getCurrentSession().createQuery("from TipoDocumento").list();
    }

    public void update(TipoDocumento tipoDocumento) throws Exception {
        sessionFactory.getCurrentSession().save(tipoDocumento);
        sessionFactory.getCurrentSession().flush();
    }

    public void delete(int id) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        TipoDocumento tipoDocumento = session.byId(TipoDocumento.class).load(id);
        session.delete(tipoDocumento);
    }

}
