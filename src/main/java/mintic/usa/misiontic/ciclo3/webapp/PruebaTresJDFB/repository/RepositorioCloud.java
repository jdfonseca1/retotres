/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.repository;

import java.util.List;
import java.util.Optional;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.interfaz.InterfaceCloud;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.modelo.Cloud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public class RepositorioCloud {
    
    @Autowired
    private InterfaceCloud crud3;
    
    public List<Cloud> getAll(){
        return (List<Cloud>)  crud3.findAll();
    }
    
    public Optional<Cloud> getCloud(int id) {
        return crud3.findById(id);
    }
    
    
    public Cloud save(Cloud cloud){
        return crud3.save(cloud);
    }
    
    public void delete(Cloud cloud){
        crud3.delete(cloud);
    }
    
    
}
