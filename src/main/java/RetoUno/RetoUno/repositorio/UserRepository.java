/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoUno.RetoUno.repositorio;

import java.util.List;
import java.util.Optional;
import RetoUno.RetoUno.modelo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import RetoUno.RetoUno.repositorioCRUD.UserInterface;

/**
 *
 * @author Sebastian
 */
@Repository
public class UserRepository {
    @Autowired
    private UserInterface crud;
    
    public List<User> darUsuarios(){
        return (List)crud.findAll();
    }
    
    public Optional<User> darUsuarioPorId(Integer id){
        return crud.findById(id);
    }
    
    public User guardar(User obj){
        return crud.save(obj);
    }
    
    public Optional<User> darUsuarioPorEmail(String email){
        return (Optional)crud.findByEmail(email);
    }
    
    public Optional<User> darPorEmailYPass(String email, String password){
        return crud.findByEmailAndPassword(email,password);
    }
    
}
