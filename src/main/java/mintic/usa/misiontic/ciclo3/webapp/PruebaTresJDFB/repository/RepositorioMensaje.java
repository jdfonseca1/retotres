/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.repository;

import java.util.List;
import java.util.Optional;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.interfaz.InterfaceMensaje;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.modelo.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public class RepositorioMensaje {
    
       @Autowired
       
       public InterfaceMensaje crud4;
       
       public List<Mensaje> getAll(){
           return(List<Mensaje>) crud4.findAll();
       }
       
       public Optional<Mensaje> getMensaje(int id){
           return crud4.findById(id);
       }
       
       
       public Mensaje save(Mensaje mensaje){
           return crud4.save(mensaje);
       }
       
       public void delete(Mensaje mensaje){
           crud4.delete(mensaje);
       }
    
}
