package cl.talentodigital.sprint_JSP.repositories;

import cl.talentodigital.sprint_JSP.models.NumberOfUserbyRol;
import cl.talentodigital.sprint_JSP.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface UserRepository extends JpaRepository<UserModel, Long> {


    public abstract UserModel findUserByUserName(String userName);

    //JPL Utiliza cláusulas de ordenamiento para presentar la información

    @Query(value = "SELECT u.id_user, u.user_name, u.password, u.rol FROM users u order by u.ID_USER DESC", nativeQuery = true)
    public abstract ArrayList<UserModel> allUserDesc();

    //JPL Utiliza WHERE para filtrar la información requerida
    @Query(value = "select u.id_user, u.user_name, u.password, u.rol from users u where u.rol = :rol", nativeQuery = true)
    public abstract ArrayList<UserModel> allUserByRol(@Param("rol") Long rol);

    //Utiliza cláusulas de agrupación de información para obtener datos agregados
    @Query(value = "select u.ROL, COUNT(u.ROL) from users u GROUP by u.rol", nativeQuery = true)
    public abstract ArrayList<NumberOfUserbyRol> numberOfUsersByRole();
}
