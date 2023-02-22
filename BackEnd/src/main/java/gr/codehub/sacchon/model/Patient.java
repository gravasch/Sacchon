package gr.codehub.sacchon.model;

import gr.codehub.sacchon.service.MediDataVaultService;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patient_id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private LocalDate birthDate;
    private String diabetesType;
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name= "doctor_id")
    private Doctor doctor;

    @OneToMany(mappedBy = "patient")
    private List<Consultation> consultations = new ArrayList<>();

//    private boolean hasConsultant;
//    private boolean consultationPending;      *under discussion*
//    private boolean hasDoctor;
//    private boolean modified;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "patient")
//    private List<BloodGlucoseMeasurement> bloodGlucoseLevels = new ArrayList<>();
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "patient")
//    private List<CarbMeasurements> carbonatesIntakes = new ArrayList<>();


//    The @OneToMany annotations in the Patient class specify a one-to-many relationship
//    between the Patient and BloodGlucoseLevel or CarbonatesIntake entities.
//
//    -fetch = FetchType.LAZY: This means that the related entities will be loaded only when they are accessed,
//    not when the parent entity is loaded. This is useful when dealing with a large number of related
//    entities, as it can help to reduce the amount of data that needs to be loaded into memory.
//
//    -cascade = CascadeType.ALL: This means that when an operation (such as persist, remove, merge, etc.)
//    is performed on the parent entity, the same operation will be automatically performed on the related
//    entities. In this case, if a patient is deleted, their blood glucose level and carbonates intake
//    records will also be deleted.
//
//    -mappedBy = "patient": This specifies the name of the field in the related entity
//    (BloodGlucoseLevel or CarbonatesIntake) that defines the relationship back to
//    the parent entity (Patient).
//
//    So in the Patient entity, the bloodGlucoseLevels and carbonatesIntakes fields define lists of
//    related BloodGlucoseLevel and CarbonatesIntake entities, respectively, that belong to the Patient.



//    public boolean isActive() {
//        return isActive;
//    }
//
//    public void setActive(boolean active) {
//        isActive = active;
//    }
//
//
//    public boolean getActive() { return isActive;
//    }
}
