package gr.codehub.sacchon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GlucoseLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long glucId;

    private LocalDate glDate;
    private LocalTime glTime;
    private BigDecimal measurement;
    @ManyToOne
    Patient patient;

}




