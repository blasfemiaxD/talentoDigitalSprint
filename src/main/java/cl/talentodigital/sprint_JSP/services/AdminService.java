package cl.talentodigital.sprint_JSP.services;

import cl.talentodigital.sprint_JSP.models.AdminModel;
import cl.talentodigital.sprint_JSP.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public ArrayList<AdminModel> allAdmin(){
        return (ArrayList<AdminModel>) adminRepository.findAll();
    }

    public AdminModel saveAdmin(AdminModel admin){
        return adminRepository.save(admin);
    }

    public Optional<AdminModel> findAdminById(long id){
        return adminRepository.findById(id);
    }

    public boolean deleteAdminById(Long id){
        try {
            adminRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}

