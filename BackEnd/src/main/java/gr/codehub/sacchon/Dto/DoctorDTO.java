package gr.codehub.sacchon.Dto;

import gr.codehub.sacchon.model.Doctor;
import gr.codehub.sacchon.model.DoctorType;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private LocalDate dateOfBirth;

    private DoctorType doctorType;

    private Boolean isActive;


        public DoctorDTO(Doctor doctor){
            if (doctor!= null){
                id = doctor.getId();
                firstName = doctor.getFirstName();
                lastName = doctor.getLastName();
                username = doctor.getUsername();
                dateOfBirth = doctor.getDateOfBirth();
                doctorType = doctor.getDoctorType();
                isActive = doctor.getIsActive();

            }
        }
        public Doctor asDoctor(){
            Doctor doctor = new Doctor();
            doctor.setId(id);
            doctor.setFirstName(firstName);
            doctor.setLastName(lastName);
            doctor.setUsername(username);
            doctor.setDateOfBirth(dateOfBirth);
            doctor.setDoctorType(doctorType);
            doctor.setIsActive(isActive);
            return doctor;
        }

    }

