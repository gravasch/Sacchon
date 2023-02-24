package gr.codehub.sacchon.Dto;

import gr.codehub.sacchon.model.Consultation;
import gr.codehub.sacchon.model.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsultationDTO {

    private Long id;
    private String medicationName;
    private BigDecimal dosage;
    private String advice;
    private LocalDate consultationDate;

    public ConsultationDTO(Consultation consultation){
        if (consultation!= null){
            id = consultation.getId();
            medicationName = consultation.getMedicationName();
            dosage = consultation.getDosage();
            advice = consultation.getAdvice();
            consultationDate = consultation.getConsultationDate();
        }
    }
    public Consultation asConsultation(){
        Consultation consultation = new Consultation();
        consultation.setId(id);
        consultation.setMedicationName(medicationName);
        consultation.setDosage(dosage);
        consultation.setAdvice(advice);
        consultation.setConsultationDate(consultationDate);
        return consultation;
    }

}
