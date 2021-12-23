/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoUno.RetoUno.servicio;

import RetoUno.RetoUno.modelo.User;
import RetoUno.RetoUno.repositorio.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian
 */
@Service
public class UserServices {
    @Autowired
    private UserRepository repositorio;
    
    public List<User> darUsuarios(){
        return  repositorio.darUsuarios();
    }
    
    public User guardar(User obj){
            Optional<User> resp=repositorio.darUsuarioPorEmail(obj.getEmail());
            if(resp.isEmpty()){
                return repositorio.guardar(obj);
            }
            else{
                return obj;
            }
    }
    
    public User darUsuario(String email, String password){
        Optional<User> resp=repositorio.darPorEmailYPass(email, password);
        if(!resp.isEmpty()){
            return resp.get();
        }
        else{
            User respuesta=new User();
            respuesta.setEmail(email);
            respuesta.setPassword(password);
            respuesta.setName("NO DEFINIDO");
            return respuesta;
        }
    }
    
    public boolean validarEmail(String email){
        Optional<User> resp=repositorio.darUsuarioPorEmail(email);
        if(resp.isEmpty()){
            return false;
        }
        return true;
    }
    
}

