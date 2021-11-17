/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.services;

import java.util.List;
import java.util.Optional;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.modelo.Cliente;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.repository.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class ServicioCliente {
    
    
     @Autowired
      
      private RepositorioCliente metodosCrud;
      
      
      public List<Cliente> getAll(){
        return (List<Cliente>) metodosCrud.getAll();
    }
    
    public Optional<Cliente> getCliente( int clienteId){
        return metodosCrud.getCliente(clienteId);
    }
    
    
    public Cliente save(Cliente cliente){
        if(cliente.getIdClient()== null){
            return metodosCrud.save(cliente);
        } else {
            Optional<Cliente> e= metodosCrud.getCliente(cliente.getIdClient());
            if(e.isPresent()){
                return metodosCrud.save(cliente);
                
            } else {
                return cliente;
            }
        }
    }
    
    
    public Cliente update (Cliente cliente){
        if(cliente.getIdClient()!=null){
            Optional<Cliente> h=metodosCrud.getCliente(cliente.getIdClient());
            if(!h.isPresent()){
                
                if(cliente.getName()!=null){
                    h.get().setName(cliente.getName());
                }
                
                if(cliente.getAge()!=null){
                    h.get().setAge(cliente.getAge());
                }
                
                
                if(cliente.getPassword()!=null){
                    h.get().setPassword(cliente.getPassword());
                }
                
                
                metodosCrud.save(h.get());
                return h.get();
                
            } else {
                return cliente;
            } 
        }else {
                return cliente;
            }
         
    }
        
    
    
    public boolean deleteCliente(int clienteId){
        Boolean aBoolean = getCliente(clienteId).map(cliente -> {
            metodosCrud.delete(cliente);
            return true;
        }).orElse(false);
        return aBoolean;
        
  
       }
    
}
