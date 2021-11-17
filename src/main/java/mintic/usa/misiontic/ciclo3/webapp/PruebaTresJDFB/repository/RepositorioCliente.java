/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.repository;

import java.util.List;
import java.util.Optional;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.interfaz.InterfaceCliente;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public class RepositorioCliente {
    
    @Autowired
    
    public InterfaceCliente crud2;
    
    public List<Cliente> getAll(){
        return(List<Cliente>) crud2.findAll();
    }
    
    public Optional<Cliente> getCliente(int id){
        return crud2.findById(id);
    }
    
    public Cliente save(Cliente cliente){
        return crud2.save(cliente);
    }
    
    public void delete(Cliente cliente){
        crud2.delete(cliente);
    }
    
    
    
    
    
    
}
