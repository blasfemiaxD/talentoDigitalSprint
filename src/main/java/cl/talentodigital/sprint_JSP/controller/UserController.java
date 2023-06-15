package cl.talentodigital.sprint_JSP.controller;

import cl.talentodigital.sprint_JSP.models.NumberOfUserbyRol;
import cl.talentodigital.sprint_JSP.models.UserModel;
import cl.talentodigital.sprint_JSP.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/v1/user/")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("test")
    public String hello(){
        return "Service Up";
    }
    @GetMapping("")
    public ArrayList<UserModel> allUser(){
        return this.userService.allUser();
    }

    @GetMapping("/alluserdesc")
    public ArrayList<UserModel> allUserOrderByIdDesc(){
        return this.userService.allUserDesc();
    }

    @GetMapping("/alluserbyrol/{rol}")
    public ArrayList<UserModel> allUserByRol(@PathVariable("rol")Long rol){
        return this.userService.allUserByRol(rol);
    }

    @GetMapping("{id}")
    public Optional<UserModel> findUserById(@PathVariable("id") Long id){
        return userService.findUserById(id);
    }
    @PostMapping("")
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @DeleteMapping(path = "{id}")
    public String deleteUser(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUserById(id);
        if(ok){
            return "Se elimino el usuario con el ID: "+id;
        }else {
            return "No se elimino el usuario con el ID: "+id;
        }
    }

    @GetMapping("/numberuserbyrol")
    public ArrayList<NumberOfUserbyRol> allUserByRol(){
        return this.userService.numberOfUsersByRole();
    }

}
