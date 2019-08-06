package com.trimix.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trimix.manager.dto.PersonaDto;
import com.trimix.manager.dto.Response;
import com.trimix.manager.exception.EntityNotFoundException;
import com.trimix.manager.model.Persona;
import com.trimix.manager.service.PersonaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@PostMapping
    public ResponseEntity<?> save(@RequestBody PersonaDto personaDTO) throws Exception {
        Response response = personaService.save(personaDTO);
        return ResponseEntity.ok().body(response);
    }

	@GetMapping("/{id}")
	public ResponseEntity<Persona> get(@PathVariable("id") int id) throws EntityNotFoundException, Exception {
		Persona persona = personaService.get(id);
		return ResponseEntity.ok().body(persona);
	}

	@GetMapping()
	public ResponseEntity<?> list() throws Exception {
		Response response = personaService.list();
		return ResponseEntity.ok().body(response);
	}

}
