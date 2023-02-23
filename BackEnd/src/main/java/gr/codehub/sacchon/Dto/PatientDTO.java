package gr.codehub.sacchon.Dto;

import gr.codehub.sacchon.model.DiabetesType;
import gr.codehub.sacchon.model.Doctor;
import gr.codehub.sacchon.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private LocalDate birthDate;
    private DiabetesType diabetesType;
    private Boolean isActive;

    public PatientDTO(Patient patient) {
        if (patient!= null){
            id = patient.getId();
            firstName = patient.getFirstName();
            lastName = patient.getLastName();
            diabetesType = patient.getDiabetesType();
            birthDate = patient.getBirthDate();
            isActive = patient.getIsActive();

        }
    }


    public Patient asPatient() {
        Patient patient = new Patient();
        patient.setId(id);
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setAddress(address);
        patient.setCity(city);
        patient.setDiabetesType(diabetesType);
        patient.setBirthDate(birthDate);
        patient.setIsActive(isActive);
        return patient;
    }


}