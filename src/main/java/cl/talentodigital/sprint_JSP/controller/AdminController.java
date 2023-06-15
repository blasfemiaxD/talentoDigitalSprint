package cl.talentodigital.sprint_JSP.controller;

import cl.talentodigital.sprint_JSP.models.AdminModel;
import cl.talentodigital.sprint_JSP.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/v1/admin/")
public class AdminController {

    @Autowired
    AdminService adminService;

    //Test para saver si servicio esta arriba
    @GetMapping("test")
    public String hello(){
        return "Service Up";
    }

    @GetMapping("")
    public ArrayList<AdminModel> allAdmin(){
        return this.adminService.allAdmin();
    }

    @PostMapping("")
    public AdminModel saveAdmin(@RequestBody AdminModel admin) throws SQLException {
        return this.adminService.saveAdmin(admin);
    }

    @GetMapping("{id}")
    public Optional<AdminModel> findAdminById(@PathVariable("id") Long id){
        return this.adminService.findAdminById(id);
    }
    @DeleteMapping(path = "{id}")
    public  String deleteAdmin(@PathVariable("id") Long id){
        boolean ok = this.adminService.deleteAdminById(id);
        if(ok){
            return "Se elimino el administrador con el ID: "+id;
        }else {
            return "No se elimino el administrador con el ID: "+id;
        }
    }
}
