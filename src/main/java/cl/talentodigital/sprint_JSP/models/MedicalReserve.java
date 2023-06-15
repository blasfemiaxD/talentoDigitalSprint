package cl.talentodigital.sprint_JSP.models;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "medicalreserves")
public class MedicalReserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MEDICAL_RESERVE", unique = true, nullable = false)
    private int idMedicalReserve;
    @Column(name = "MEDICAL_RESERVATION_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date medicalReservationDate;
    @Column(name = "MEDICAL_RESERVATION_TIME", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date medicalReservationTime;
    @ManyToOne
    @JoinColumn(name = "ID_NUTRITIONIST")
    nutritionistModel nutritionistModel;
    @ManyToOne
    @JoinColumn(name = "ID_PATIENT")
    PatientModel patientModel;


    public MedicalReserve() {
    }

    public MedicalReserve(int idMedicalReserve, Date medicalReservationDate, Date medicalReservationTime) {
        this.idMedicalReserve = idMedicalReserve;
        this.medicalReservationDate = medicalReservationDate;
        this.medicalReservationTime = medicalReservationTime;
    }

    public int getIdMedicalReserve() {
        return idMedicalReserve;
    }

    public void setIdMedicalReserve(int idMedicalReserve) {
        this.idMedicalReserve = idMedicalReserve;
    }

    public Date getMedicalReservationDate() {
        return medicalReservationDate;
    }

    public void setMedicalReservationDate(Date medicalReservationDate) {
        this.medicalReservationDate = medicalReservationDate;
    }

    public Date getMedicalReservationTime() {
        return medicalReservationTime;
    }

    public void setMedicalReservationTime(Date medicalReservationTime) {
        this.medicalReservationTime = medicalReservationTime;
    }
}
