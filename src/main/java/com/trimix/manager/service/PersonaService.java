package com.trimix.manager.service;

import com.trimix.manager.dao.PersonaDao;
import com.trimix.manager.dao.TipoDocumentoDao;
import com.trimix.manager.dto.PersonaDto;
import com.trimix.manager.dto.Response;
import com.trimix.manager.exception.EntityNotFoundException;
import com.trimix.manager.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonaService {

    @Autowired
    private PersonaDao personaDao;

    @Autowired
    private TipoDocumentoDao tipoDocumentoDao;

    public Response save(PersonaDto personaDto) throws Exception {
        Response response = new Response();

        Persona persona = personaDtoToEntity(personaDto);
        int id = personaDao.save(persona);


        response.setData(id);
        return response;
    }

    public Persona get(int id) throws EntityNotFoundException, Exception {
        return personaDao.get(id);
    }

    public Response list() throws Exception {
        Response response = new Response();
        List<Persona> personas = personaDao.list();
        response.setData(personas);
        return response;
    }

    private Persona personaDtoToEntity(PersonaDto personaDto) throws Exception {
        Persona persona = new Persona();

        return persona;
    }
}














