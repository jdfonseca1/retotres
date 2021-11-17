/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.services;

import java.util.List;
import java.util.Optional;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.modelo.Category;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.repository.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class ServicioCategoria {
    
      @Autowired
      
      private RepositorioCategoria metodosCrud;
      
      
      public List<Category> getAll(){
        return (List<Category>) metodosCrud.getAll();
    }
    
    public Optional<Category> getCategory( int CategoriaId){
        return metodosCrud.getCategory(CategoriaId);
    }
    
    
    public Category save(Category category){
        if(category.getId()== null){
            return metodosCrud.save(category);
        } else {
            Optional<Category> g= metodosCrud.getCategory(category.getId());
            if(g.isPresent()){
                return metodosCrud.save(category);
                
            } else {
                return category;
            }
        }
    }
    
    
    public Category update (Category category){
        if(category.getId()!=null){
            Optional<Category> g=metodosCrud.getCategory(category.getId());
            if(!g.isPresent()){
                
                
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                
                return metodosCrud.save(g.get());
                
            } 
         
    }
        return category;
    }
    
    public boolean deleteCategory(int CategoriaId){
        Boolean aBoolean = getCategory(CategoriaId).map(category -> {
            metodosCrud.delete(category);
            return true;
        }).orElse(false);
        return aBoolean;
        
  
       }
    
      
      
      
    
}
