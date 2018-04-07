/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.RegistroPersonasSpringBoot.repository.impl;

import com.hm.RegistroPersonasSpringBoot.model.Genero;
import com.hm.RegistroPersonasSpringBoot.model.Pais;
import com.hm.RegistroPersonasSpringBoot.model.Persona;
import com.hm.RegistroPersonasSpringBoot.model.TipoIdentificacion;
import com.hm.RegistroPersonasSpringBoot.repository.GeneroRepository;
import com.hm.RegistroPersonasSpringBoot.repository.PaisRepository;
import com.hm.RegistroPersonasSpringBoot.repository.PersonaRepository;
import com.hm.RegistroPersonasSpringBoot.repository.TipoIdentificacionRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author HugoM
 */
public class PersonaRepositoryImpl {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private TipoIdentificacionRepository tipoIdentificacionRepository;

    public List<Persona> getAllPersons() {
        System.out.println("Inicio metodo getAllPersons de PersonaRepositoryImpl");
        List<Persona> lPersona = new ArrayList<>();

        try {
            lPersona = personaRepository.findAll();
            System.out.println("Fin metodo getAllPersons de PersonaRepositoryImpl");
            return lPersona;
        } catch (Exception ex) {
            System.out.println("Error metodo getAllPersons de PersonaRepositoryImpl: " + ex);
            return lPersona;
        }
    }

    public Persona getByPersonId(long idPersona) {
        System.out.println("Inicio metodo getByPersonId de PersonaRepositoryImpl");
        Persona persona = new Persona();
        try {
            persona = personaRepository.getByPersonId(idPersona);
            System.out.println("Fin metodo getByPersonId de PersonaRepositoryImpl");
            return persona;
        } catch (Exception ex) {
            System.out.println("Error metodo getByPersonId de PersonaRepositoryImpl: " + ex);
            return persona;
        }
    }

    public boolean insertPerson(Persona persona) {
        System.out.println("Inicio metodo insertPerson de PersonaRepositoryImpl");
        boolean respuesta;
        Genero genero = generoRepository.getByIdGener(persona.getIdGenero());
        if (genero.getIdGenero().isEmpty()) {
            respuesta = false;
            System.out.println("Fin del metodo insertPerson de PersonaRepositoryImpl, por genero");
            return respuesta;
        }

        TipoIdentificacion tipoIdentificacion
                = tipoIdentificacionRepository.getByIdIdentificationType(persona.getIdTipoIdentificacion());
        if (tipoIdentificacion.getIdTipoIdentificacion().isEmpty()) {
            respuesta = false;
            System.out.println("Fin del metodo insertPerson de PersonaRepositoryImpl, por tipoIdentificacion");
            return respuesta;
        }

        Pais pais = paisRepository.getCountry(persona.getIdPais());
        if (pais.getNomenclaturaPais().isEmpty()) {
            respuesta = false;
            System.out.println("Fin del metodo insertPerson de PersonaRepositoryImpl, por pais");
            return respuesta;
        }
        try {
            personaRepository.save(persona);
        } catch (Exception ex) {
            System.out.println("Error del metodo insertPerson de PersonaRepositoryImpl: " + ex);
            respuesta = false;
            return respuesta;
        }
        respuesta = true;
        return respuesta;

    }

    public boolean updatePerson(Persona persona) {
        System.out.println("Inicio metodo updatePerson de PersonaRepositoryImpl");
        boolean respuesta;

        Persona personaValidate = personaRepository.getByPersonId(persona.getIdPersona());

        if (personaValidate.getPrimerApellido().isEmpty()) {
            System.out.println("Fin del metodo updatePerson de PersonaRepositoryImpl sin cambios");
            respuesta = false;
            return respuesta;
        } else {
            persona.setIdPersona(personaValidate.getIdPersona());
            personaRepository.save(persona);
            System.out.println("Fin del metodo updatePerson de PersonaRepositoryImpl");
            respuesta = true;
            return respuesta;
        }
    }
    
    public boolean deletePerson(long idPersona) {
        System.out.println("Inicio del metodo DeletePerson de PersonaRepositoryImpl");
        boolean respuesta;
        try {
            personaRepository.deleteById(idPersona);
            respuesta = true;
            return respuesta;
        } catch (Exception ex) {
            System.out.println("Error del metodo updatePerson de PersonaRepositoryImpl: " + ex);
            respuesta = false;
            return respuesta;
        }
    }

}
