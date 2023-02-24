package gr.codehub.sacchon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CarbMeasurements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carbId;

    private LocalDate date;
    private BigDecimal gram;

    @ManyToOne
    @JoinColumn(name= "patient_id")
    private Patient patient;

}
