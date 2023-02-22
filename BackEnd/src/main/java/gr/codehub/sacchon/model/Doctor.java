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
public class  Doctor {
    @jakarta.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long doctor_id;

    private String firstName;
    private String lastName;
    private String username;
    private LocalDate dateOfBirth;
    private Boolean isActive = false;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients = new ArrayList<>();


    @OneToMany(mappedBy = "doctor")
    private List<Consultation> consultations = new ArrayList<>();
}
