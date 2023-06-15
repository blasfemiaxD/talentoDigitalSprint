package cl.talentodigital.sprint_JSP.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "nutritionists")

public class nutritionistModel extends Person {

    @Column(name = "SPECIALTY", unique = true, nullable = false)
    private String specialty;
    @OneToMany(mappedBy = "nutritionistModel")
    private ArrayList<MedicalReserve> medicalReserves;
    @OneToOne
    private UserModel user;
    @OneToOne
    private Schedule schedule;

    public nutritionistModel() {
    }

    public nutritionistModel(int id, String dni, String name, String lastName, String phone, String address, Date birthDate, String specialty, ArrayList<MedicalReserve> medicalReserves, UserModel user, Schedule schedule) {
        super(id, dni, name, lastName, phone, address, birthDate);
        this.specialty = specialty;
        this.medicalReserves = medicalReserves;
        this.user = user;
        this.schedule = schedule;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public ArrayList<MedicalReserve> getMedicalReserves() {
        return medicalReserves;
    }

    public void setMedicalReserves(ArrayList<MedicalReserve> medicalReserves) {
        this.medicalReserves = medicalReserves;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
