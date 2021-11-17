/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.repository;

import java.util.List;
import java.util.Optional;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.interfaz.InterfaceReservacion;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.modelo.Reservacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public class RepositorioReservacion {
    
     @Autowired
     
     public InterfaceReservacion crud5;
     
     public List<Reservacion> getAll(){
         return (List<Reservacion>) crud5.findAll();
     }
     
     
     public Optional<Reservacion> getReservacion(int id){
         return crud5.findById(id);
     }
     
     public Reservacion save(Reservacion reservacion){
         return crud5.save(reservacion);
     }
     
     public void delete(Reservacion reservacion){
         crud5.delete(reservacion);
     }
     
    
}
