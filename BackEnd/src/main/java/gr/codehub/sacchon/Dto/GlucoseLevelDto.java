package gr.codehub.sacchon.Dto;

import gr.codehub.sacchon.model.GlucoseLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlucoseLevelDto {

    private Long glucId;
    private LocalDate glDate;
    private LocalTime glTime;
    private BigDecimal measurement;

    public GlucoseLevelDto(GlucoseLevel glucoseLevel){
        if (glucoseLevel!= null){
            glucId = glucoseLevel.getGlucId();
            glDate = glucoseLevel.getGlDate();
            glTime = glucoseLevel.getGlTime();
            measurement = glucoseLevel.getMeasurement();

        }
    }


    public GlucoseLevel asGlucoseLevel() {
        GlucoseLevel glucoseLevel = new GlucoseLevel();
        glucoseLevel.setGlucId(glucId);
        glucoseLevel.setGlDate(glDate);
        glucoseLevel.setGlTime(glTime);
        glucoseLevel.setMeasurement(measurement);
        return glucoseLevel;
    }
}