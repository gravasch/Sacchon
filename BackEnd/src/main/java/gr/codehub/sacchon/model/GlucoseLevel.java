package gr.codehub.sacchon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GlucoseLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long glucId;

    private LocalDate glDate;
    private LocalTime glTime;
    private BigDecimal measurement;
    @ManyToOne
    Patient patient;

}




//~~~~~~~~~~~~~Αυτά δε νομίζω να χρειαζονται~~~~~~~~~~~~~~~~~
//    public Long getGlucId() {
//        return glucId;
//    }
//
//    public void setGlucId(Long glucId) {
//        this.glucId = glucId;
//    }
//
//    public LocalDate getGlDate() {
//        return glDate;
//    }
//
//    public void setGlDate(LocalDate glDate) {
//        this.glDate = glDate;
//    }
//
//    public LocalTime getGlTime() {
//        return glTime;
//    }
//
//    public void setGlTime(LocalTime glTime) {
//        this.glTime = glTime;
//    }
//
//    public BigDecimal getMeasurement() {
//        return measurement;
//    }
//
//    public void setMeasurement(BigDecimal measurement) {
//        this.measurement = measurement;
//    }
//}
