/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.interfaz;

import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.modelo.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author usuario
 */
public interface InterfaceCategoria extends CrudRepository<Category, Integer> {
    
}
