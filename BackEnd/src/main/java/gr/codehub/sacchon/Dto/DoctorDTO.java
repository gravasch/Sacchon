package gr.codehub.sacchon.Dto;

import gr.codehub.sacchon.model.Doctor;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorDTO {
    private Long doctor_id;
    private String firstName;
    private String lastName;
    private String username;
    private LocalDate dateOfBirth;

    private Boolean isActive;


        public DoctorDTO(Doctor doctor){
            if (doctor!= null){
                doctor_id= doctor.getDoctor_id();
                firstName = doctor.getFirstName();
                lastName = doctor.getLastName();
                username = doctor.getUsername();
                dateOfBirth = doctor.getDateOfBirth();
                isActive = doctor.getIsActive();

            }
        }
        public Doctor asDoctor(){
            Doctor doctor = new Doctor();
            doctor.setDoctor_id(doctor_id);
            doctor.setFirstName(firstName);
            doctor.setLastName(lastName);
            doctor.setUsername(username);
            doctor.setDateOfBirth(dateOfBirth);
            doctor.setIsActive(isActive);
            return doctor;
        }

    }

