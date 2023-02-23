package gr.codehub.sacchon.model;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @jakarta.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String username;
    private LocalDate dateOfBirth;
    private DoctorType doctorType;
    private Boolean isActive = false;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private List<Patient> patients = new ArrayList<>();


    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private List<Consultation> consultations = new ArrayList<>();
}
