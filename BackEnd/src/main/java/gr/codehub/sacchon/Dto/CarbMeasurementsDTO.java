package gr.codehub.sacchon.Dto;

import gr.codehub.sacchon.model.CarbMeasurements;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarbMeasurementsDTO {
    private Long carbId;
    private LocalDate date;
    private double gram;

    public CarbMeasurementsDTO(CarbMeasurements carbMeasurements) {
        carbId = carbMeasurements.getCarbId();
        date = carbMeasurements.getDate();
        gram = carbMeasurements.getGram();
    }

    public CarbMeasurements asCarbMeasurements() {
        CarbMeasurements carbMeasurements = new CarbMeasurements();
        carbMeasurements.setCarbId(carbId);
        carbMeasurements.setDate(date);
        carbMeasurements.setGram(gram);
        return carbMeasurements;
    }
}
