package cl.talentodigital.sprint_JSP;

import cl.talentodigital.sprint_JSP.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.talentodigital.sprint_JSP.models.UserModel;
import cl.talentodigital.sprint_JSP.services.UserService;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class UserServiceTest {
    /*
    * Prueba de la clase UserModel, se valida la creación de usuario.
    * */
    @DisplayName("Test que valida la creación de un usuarios a partir del UserModel ")
    @Test
    public void testCreatetUserModel(){
        //Creao Usuario
        UserModel usuarioEsperado = new UserModel();
        usuarioEsperado.setIdUser(44);
        usuarioEsperado.setUserName("Usuario Pureba1");
        usuarioEsperado.setRol("0");
        usuarioEsperado.setPassword("laClabe");
        //Creo Usuario de Servicio

        final UserModel usuarioResiltado = new UserModel(44, "Usuario Pureba1", "laClabe", "0");

        Assertions.assertEquals(usuarioEsperado.getIdUser(),usuarioResiltado.getIdUser());
        Assertions.assertEquals(usuarioEsperado.getUserName(),usuarioResiltado.getUserName());
        Assertions.assertEquals(usuarioEsperado.getRol(),usuarioResiltado.getRol());
        Assertions.assertEquals(usuarioEsperado.getPassword(),usuarioResiltado.getPassword());
        //Assertions.assertEquals(usuarioEsperado,usuarioResiltado);

    }


    @DisplayName("Test que valida el insert de usuario en la BD")
    @Test
    public void testInsertUser(){
        UserRepository userRepository = null;

        //Creao Usuario
        UserModel usuarioEsperado = new UserModel();
        //usuarioEsperado.setIdUser(44);
        usuarioEsperado.setUserName("Usuario Pureba1");
        usuarioEsperado.setRol("0");
        usuarioEsperado.setPassword("laClabe");


        UserService userService = new  UserService();
        UserModel result = userService.saveUser(userRepository.save(usuarioEsperado));

        UserModel expResult = usuarioEsperado;
        Assertions.assertEquals(expResult.getIdUser(), result.getIdUser());

    }

    @DisplayName("Test que valida el insert de usuario en la BD")
    @Test
    public void testListUser(){

        UserService userService = new  UserService();
        ArrayList<UserModel> lista = userService.allUser();
        Assertions.assertNotNull(lista);

    }

}
