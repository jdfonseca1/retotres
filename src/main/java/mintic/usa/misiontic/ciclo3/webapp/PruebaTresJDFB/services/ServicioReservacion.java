/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.services;

import java.util.List;
import java.util.Optional;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.modelo.Reservacion;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.repository.RepositorioReservacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class ServicioReservacion {
    
    
    
      @Autowired
      
      private RepositorioReservacion metodosCrud;
      
      
      public List<Reservacion> getAll(){
        return (List<Reservacion>) metodosCrud.getAll();
    }
    
    public Optional<Reservacion> getReservacion( int reservacionId){
        return metodosCrud.getReservacion(reservacionId);
    }
    
    
    public Reservacion save(Reservacion reservacion){
        if(reservacion.getIdReservation()== null){
            return metodosCrud.save(reservacion);
        } else {
            Optional<Reservacion> m= metodosCrud.getReservacion(reservacion.getIdReservation());
            if(m.isPresent()){
                return metodosCrud.save(reservacion);
                
            } else {
                return reservacion;
            }
        }
    }
    
    
    public Reservacion update (Reservacion reservacion){
        if(reservacion.getIdReservation()!=null){
            Optional<Reservacion> m=metodosCrud.getReservacion(reservacion.getIdReservation());
            if(!m.isPresent()){
                
                
                if(reservacion.getStarDate()!=null){
                    m.get().setStarDate(reservacion.getStarDate());
                }
                
                if(reservacion.getDevolutionDate()!=null){
                    m.get().setDevolutionDate(reservacion.getDevolutionDate());
                }
                
                if(reservacion.getStatus()!=null){
                    m.get().setStatus(reservacion.getStatus());
                }
                
                metodosCrud.save(m.get());
                return m.get();
                
            } else {
                return reservacion;
            }
        } else {
            return reservacion;
        }
         
    }
        
    
    
    public boolean deleteReservacion(int reservacionId){
        Boolean aBoolean = getReservacion(reservacionId).map(reservacion -> {
            metodosCrud.delete(reservacion);
            return true;
        }).orElse(false);
        return aBoolean;
        
  
       }    
    
}
