package gr.codehub.sacchon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long patientId;
    private String firstname;
    private String lastName;
    private String address;
    private String city;
    private Date date;
    private String diabetesTypes;
    private boolean isActive;


}
