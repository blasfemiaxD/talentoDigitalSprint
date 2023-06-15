package cl.talentodigital.sprint_JSP.models;

import jakarta.persistence.*;


import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private int id;
    private String dni;
    private String name;
    @Column(name = "LAST_NAME")
    private String lastName;
    private String phone;
    private String address;
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRT_DATE")
    private Date birthDate;

    public Person() {
    }

    public Person(int id, String dni, String name, String lastName, String phone, String address, Date birthDate) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
