package cl.talentodigital.sprint_JSP.controller;


import cl.talentodigital.sprint_JSP.models.UserModel;
import cl.talentodigital.sprint_JSP.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;
import java.util.Optional;

@Controller
public class UserControllerJSP {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
    public String loginPage(){
        return "loginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String menuPage(ModelMap modelMap, @RequestParam String userName, @RequestParam String password){

        try {
            UserModel userModel = userService.findUserByUserName(userName);
            if(userModel.getPassword().equals(password)) {
                modelMap.put("userModel", userModel);
                modelMap.put("listUser",this.userService.allUser());
                return "menu";
            }

        }catch (Exception e){
            //modelMap.put("errorMsg","Credenciales incorrectas,"+e.toString());
            modelMap.put("errorMsg","Credenciales incorrectas");
        }
        return "loginForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model){
        UserModel userModel = new UserModel();
        model.addAttribute("user", userModel);
        return "register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") UserModel userModel, ModelMap modelMap){
        UserModel userCreate = userService.saveUser(userModel);

        if(Objects.isNull(userCreate)){
            modelMap.put("errorMsg","Ocurrio un problema durante la creacion");
        }

        modelMap.put("successMsg", "Usuario creado exitosamente");
        return "loginForm";
    }

    /*@RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menuPage(Model model){
        UserModel userModel = new UserModel();
        //model.addAttribute("user", userModel);
        return "menu";
    }*/


//En mantenedor
    @GetMapping("menu")
    public String getAllUser(Model model){
        model.addAttribute("listUser",this.userService.allUser());
        return "menu";
    }

    @GetMapping("/addUser")
    public String addUser(Model model){
        model.addAttribute("user", new UserModel());

        return "AddUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(UserModel user, RedirectAttributes redirectAttributes){

        UserModel userCreate = userService.saveUser(user);

        if(!Objects.isNull(userCreate)){
            redirectAttributes.addFlashAttribute("message", "Usuario Creado");
        }

        return "redirect:/menu";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        boolean ok = this.userService.deleteUserById(id);

        if(ok){
            redirectAttributes.addFlashAttribute("message", "Usuario Eliminado");
        }else {
            redirectAttributes.addFlashAttribute("message", "NO se pudo borrar usuario");
        }

        return "redirect:/menu";
    }








}
