/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.RegistroPersonasSpringBoot.repository;

import com.hm.RegistroPersonasSpringBoot.model.TipoIdentificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author HugoM
 */
public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion, String>{
    
    //public List<TipoIdentificacion> getAllIdentificationType();
    
    @Query("SELECT t FROM TipoIdentificacion t WHERE t.idTipoIdentificacion =?1")
    public TipoIdentificacion getByIdIdentificationType(String idTipoIdentificacion);
    
}
