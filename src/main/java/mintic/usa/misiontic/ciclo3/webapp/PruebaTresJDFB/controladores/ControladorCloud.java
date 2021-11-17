/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.controladores;

import java.util.List;
import java.util.Optional;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.modelo.Cloud;
import mintic.usa.misiontic.ciclo3.webapp.PruebaTresJDFB.services.ServicioCloud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author usuario
 */
@RestController
@RequestMapping("/api/Cloud")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorCloud {
    
    @Autowired
    
    private ServicioCloud servicio;
    
    
    @GetMapping("/all")
    public List<Cloud> getCloud(){
        return servicio.getAll();
        
    }
    
    
     @GetMapping("/{id}")
    public Optional<Cloud> getCloud(@PathVariable("id") int cloudId) {
        return servicio.getCloud(cloudId);
    }
    
    
     @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud save(@RequestBody Cloud cloud) {
        return servicio.save(cloud);
    
    }
    
        
     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud update(@RequestBody Cloud cloud) {
        return servicio.update(cloud);
    }
    
     @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int cloudId) {
        return servicio.deleteCloud(cloudId);
    } 
    
    
    
}
