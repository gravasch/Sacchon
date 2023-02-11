package gr.codehub.sacchon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long docId;
    private String firstName;
    private String lastName;
    private String username;
    private Date dateOfBirth;
    private Boolean isActive = false;
}
