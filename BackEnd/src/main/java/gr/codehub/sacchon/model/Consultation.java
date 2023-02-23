package gr.codehub.sacchon.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consultationId;
    private String medicationName;
    private double dosage;
    private String advice;
    private LocalDate consultationDate;

//    @OneToMany(mappedBy = "consultation" , fetch = FetchType.LAZY)
//    private List<ConsultationReporter> consultationReporters;
    @ManyToOne
    @JoinColumn(name= "doctor")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name= "patient")
    private Patient patient;

}