/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package RetoUno.RetoUno.controlador;

import java.util.List;
import RetoUno.RetoUno.modelo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import RetoUno.RetoUno.servicio.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Sebastian
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    @Autowired
    private UserServices servicios;
    
    @GetMapping("/all")
    public List<User> darUsuarios(){
        return servicios.darUsuarios();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User guardar(@RequestBody User obj){
        return servicios.guardar(obj);
    }
    
   @GetMapping("/{email}/{password}")
   public User darUsuario(@PathVariable("email") String email, @PathVariable("password") String password){
       return servicios.darUsuario(email, password);
   }
   
   @GetMapping("/{email}")
   public boolean validarEmail(@PathVariable("email") String email){
       return servicios.validarEmail(email);
   }
}
