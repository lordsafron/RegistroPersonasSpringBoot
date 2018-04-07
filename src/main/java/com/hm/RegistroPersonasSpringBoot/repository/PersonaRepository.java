/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.RegistroPersonasSpringBoot.repository;

import com.hm.RegistroPersonasSpringBoot.model.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author HugoM
 */
public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
    public List<Persona> getAllPersons();
    
    @Query("SELECT p FROM Persona p WHERE p.idPersona = ?1")
    public Persona getByPersonId(long idPersona);
    
    public boolean insertPerson(Persona persona);
    
    public boolean updatePerson(Persona persona);
    
    public boolean deletePerson(long idPersona);   
    
}
