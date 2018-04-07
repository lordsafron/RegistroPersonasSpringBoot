/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.RegistroPersonasSpringBoot.resource;

import com.hm.RegistroPersonasSpringBoot.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hm.RegistroPersonasSpringBoot.repository.impl.PersonaRepositoryImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author HugoM
 */
@RestController
@RequestMapping("/rest/persona")
public class PersonaResource {
    
    @Autowired
    private PersonaRepositoryImpl personaRepositoryImpl;
    
    @GetMapping("/all")
    public List<Persona> getAll(){
        return personaRepositoryImpl.getAllPersons();
    }
    
    @RequestMapping("/{id}")
    public Persona getById(@PathVariable final long id) {
        Persona persona = personaRepositoryImpl.getByPersonId(id);
        return persona;
    }
    
    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public boolean insertPerson(@RequestBody Persona persona) {
        boolean valida = personaRepositoryImpl.insertPerson(persona);
        return valida;
    }
    
    @RequestMapping(method = RequestMethod.PUT, path = "/update")
    public boolean updatePerson(@RequestBody Persona persona) {
        boolean valida = personaRepositoryImpl.updatePerson(persona);
        return valida;
    }
    
    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}")
    public boolean deletePerson(@PathVariable long id) {
        boolean valida = personaRepositoryImpl.deletePerson(id);
        return valida;
    }
    
}
