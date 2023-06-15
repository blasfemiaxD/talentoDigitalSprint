package cl.talentodigital.sprint_JSP.services;

import cl.talentodigital.sprint_JSP.models.NumberOfUserbyRol;
import cl.talentodigital.sprint_JSP.models.UserModel;
import cl.talentodigital.sprint_JSP.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> allUser (){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public ArrayList<UserModel> allUserDesc (){
        return (ArrayList<UserModel>) userRepository.allUserDesc();
    }

    public ArrayList<UserModel> allUserByRol (Long rol){
        return (ArrayList<UserModel>) userRepository.allUserByRol(rol);
    }

    public Optional<UserModel> findUserById(Long id){
        return userRepository.findById(id);
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public boolean deleteUserById(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public UserModel findUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    public ArrayList<NumberOfUserbyRol> numberOfUsersByRole (){
        return (ArrayList<NumberOfUserbyRol>) userRepository.numberOfUsersByRole();
    }

}
