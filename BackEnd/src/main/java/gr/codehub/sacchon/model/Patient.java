package gr.codehub.sacchon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;



@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long patientId;
    private String firstName;
    private String lastName;

    public Patient(long patientId, String firstName, String lastName) {
    }

    public Patient() {

    }


//    private String address;
//    private String city;
//    private Date date;
//    private String diabetesTypes;
//    private boolean isActive;


}
