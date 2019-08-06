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
        Persona persona = personaDtoToEntity(null, personaDto);
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

    public Response update(PersonaDto personaDto) throws Exception {
        Response response = new Response();
        Persona persona = personaDao.get(personaDto.getPerId());
        personaDao.update(personaDtoToEntity(persona, personaDto));
        response.setMessage("Registro actualizado");
        return response;
    }

    public Response delete(int id) throws Exception {
        Response response = new Response();
        personaDao.delete(id);
        response.setMessage("Registro eliminado");
        return response;
    }

    private Persona personaDtoToEntity(Persona persona, PersonaDto personaDto) throws Exception {
        if (persona == null) {
            persona = new Persona();
        }
        persona.setPerNombre(personaDto.getPerNombre());
        persona.setPerApellido(personaDto.getPerApellido());
        persona.setPerTipoDocumento(tipoDocumentoDao.get(personaDto.getPerTpoId()));
        persona.setPerNumeroDocumento(personaDto.getPerNumeroDocumento());
        persona.setPerFechaNacimiento(personaDto.getPerFechaNacimiento());
        return persona;
    }
}














