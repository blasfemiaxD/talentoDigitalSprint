package cl.talentodigital.sprint_JSP.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "patient")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PatientModel extends Person{
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PATIENT", unique = true, nullable = false)
    private int idPatient;*/
    @Column(name = "HEAlTH_FORECAST")//Presision
    private String healthForecast;
    @Column(name = "BLOODY_TYPE")
    private String bloodType;
    @OneToMany(mappedBy = "patientModel")
    private ArrayList<MedicalReserve> medicalReserves;

    public PatientModel() {
    }

    public PatientModel(int id, String dni, String name, String lastName, String phone, String address, Date birthDate, String healthForecast, String bloodType, ArrayList<MedicalReserve> medicalReserves) {
        super(id, dni, name, lastName, phone, address, birthDate);
        this.healthForecast = healthForecast;
        this.bloodType = bloodType;
        this.medicalReserves = medicalReserves;
    }

    public String getHealthForecast() {
        return healthForecast;
    }

    public void setHealthForecast(String healthForecast) {
        this.healthForecast = healthForecast;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public ArrayList<MedicalReserve> getMedicalReserves() {
        return medicalReserves;
    }

    public void setMedicalReserves(ArrayList<MedicalReserve> medicalReserves) {
        this.medicalReserves = medicalReserves;
    }
}
