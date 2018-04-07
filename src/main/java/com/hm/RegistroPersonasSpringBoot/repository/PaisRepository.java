/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.RegistroPersonasSpringBoot.repository;

import com.hm.RegistroPersonasSpringBoot.model.Pais;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author HugoM
 */
public interface PaisRepository extends JpaRepository<Pais, Integer>{
    
    //public List<Pais> getAllCountries();
    
    @Query("SELECT p FROM Pais p WHERE p.idPais = ?1")
    public Pais getCountry(int idPais);
    
}
