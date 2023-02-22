package gr.codehub.sacchon.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class ConsultationReporter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long consRepId;
    private String medicationName;
    private double dosage;
    private String advice;

    @ManyToOne
    @JoinColumn(name = "reporter_id")
    private Reporter reporter_id;
    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation_id;

}
