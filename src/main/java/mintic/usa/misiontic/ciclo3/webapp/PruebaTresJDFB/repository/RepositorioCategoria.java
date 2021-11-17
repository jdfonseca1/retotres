/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.repository;

import java.util.List;
import java.util.Optional;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.interfaz.InterfaceCategoria;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.modelo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public class RepositorioCategoria {
    
    
    @Autowired
    
    private InterfaceCategoria crud1;
    
    public List<Category> getAll(){
        return(List<Category>) crud1.findAll();
        
    }
    
    
    public Optional<Category> getCategory(int id){
        return crud1.findById(id);
    }
    
    
    public Category save(Category category){
        return crud1.save(category);
    }
    
    public void delete(Category category){
        crud1.delete(category);
    }
    
    
    
    
}
