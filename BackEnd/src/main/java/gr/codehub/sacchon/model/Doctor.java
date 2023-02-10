package gr.codehub.sacchon.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    private String firstName="";
    private String lastName="";
    private String username="";
    private Date dateOfBirth;
    private Boolean isActive = false;
}
