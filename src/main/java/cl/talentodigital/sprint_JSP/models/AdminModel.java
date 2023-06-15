package cl.talentodigital.sprint_JSP.models;

import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "admins")
public class AdminModel extends Person{
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ADMIN", unique = true, nullable = false)
    private int idAdmin;*/

    @OneToOne
    private UserModel user;
    /*@Column(name = "ID_USER", unique = true, nullable = false)
    private int userId;*/

    public AdminModel() {
    }

    public AdminModel(int id, String dni, String name, String lastName, String phone, String address, Date birthDate, UserModel user) {
        super(id, dni, name, lastName, phone, address, birthDate);
        this.user = user;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
