/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.services;

import java.util.List;
import java.util.Optional;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.modelo.Mensaje;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.repository.RepositorioMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class ServicioMensaje {
    
    
    
      @Autowired
      
      private RepositorioMensaje metodosCrud;
      
      
      public List<Mensaje> getAll(){
        return (List<Mensaje>) metodosCrud.getAll();
    }
    
    public Optional<Mensaje> getMensaje( int messageId){
        return metodosCrud.getMensaje(messageId);
    }
    
    
    public Mensaje save(Mensaje message){
        if(message.getIdMessage()== null){
            return metodosCrud.save(message);
        } else {
            Optional<Mensaje> m= metodosCrud.getMensaje(message.getIdMessage());
            if(m.isPresent()){
                return metodosCrud.save(message);
                
            } else {
                return message;
            }
        }
    }
    
    
    public Mensaje update (Mensaje message){
        if(message.getIdMessage()!=null){
            Optional<Mensaje> m=metodosCrud.getMensaje(message.getIdMessage());
            if(!m.isPresent()){
                
                
                if(message.getMessageText()!=null){
                    m.get().setMessageText(message.getMessageText());
                }
                
                metodosCrud.save(m.get());
                return m.get();
                
            } else {
                return message;
            }
        } else {
            return message;
        }
         
    }
        
    
    
    public boolean deleteMessage(int messageId){
        Boolean aBoolean = getMensaje(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
        
  
       }    
    
}
