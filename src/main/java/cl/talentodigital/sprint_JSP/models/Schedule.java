package cl.talentodigital.sprint_JSP.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SCHEDULE",unique = true, nullable = false)
    private int idSchedule;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_TIME", nullable = false)
    private String startTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_TIME", nullable = false)
    private String endTime;

    public Schedule() {
    }

    public Schedule(int idSchedule, String startTime, String endTime) {
        this.idSchedule = idSchedule;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
