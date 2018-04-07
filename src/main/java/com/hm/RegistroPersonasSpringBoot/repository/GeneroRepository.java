/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.RegistroPersonasSpringBoot.repository;

import com.hm.RegistroPersonasSpringBoot.model.Genero;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author HugoM
 */
public interface GeneroRepository extends JpaRepository<Genero, String>{
    
    //public List<Genero> getAllGeners();
    
    @Query("SELECT g FROM Genero g WHERE g.idGenero = ?1")
    public Genero getByIdGener(String idGenero);
    
}
