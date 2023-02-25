package gr.codehub.sacchon.Dto;

import gr.codehub.sacchon.model.DiabetesType;
import gr.codehub.sacchon.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String address;
    private String city;
    private LocalDate birthdate;
    private DiabetesType diabetestype;
    private Boolean isactive;

    public PatientDTO(Patient patient) {
        if (patient!= null){
            id = patient.getId();
            firstname = patient.getFirstname();
            lastname = patient.getLastname();
            username = patient.getUsername();
            address= patient.getAddress();
            city = patient.getCity();
            diabetestype = patient.getDiabetestype();
            birthdate = patient.getBirthdate();
            isactive = patient.getIsactive();

        }
    }


    public Patient asPatient() {
        Patient patient = new Patient();
        patient.setId(id);
        patient.setFirstname(firstname);
        patient.setLastname(lastname);
        patient.setUsername(username);
        patient.setAddress(address);
        patient.setCity(city);
        patient.setDiabetestype(diabetestype);
        patient.setBirthdate(birthdate);
        patient.setIsactive(isactive);
        return patient;
    }


}