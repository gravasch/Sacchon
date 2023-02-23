package gr.codehub.sacchon.repository;

import gr.codehub.sacchon.model.CarbMeasurements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;



@Repository
public interface CarbRepository extends JpaRepository<CarbMeasurements, Long> {



//
//    @Query(value = "SELECT AVG(gram) FROM carb_measurements WHERE patient_id = :patientId AND measurement_datetime >= :startDate AND measurement_datetime <= :endDate", nativeQuery = true)
//    Double findAverageCarbIntakeByPatientIdAndDateRange(@Param("patientId") Long patientId, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
//



}
