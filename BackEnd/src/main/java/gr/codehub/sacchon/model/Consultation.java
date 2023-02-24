package gr.codehub.sacchon.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;



@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String medicationName;
    private BigDecimal dosage;
    private String advice;
    private LocalDate consultationDate;

    @ManyToOne
    @JoinColumn(name= "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name= "patient_id")
    private Patient patient;

}