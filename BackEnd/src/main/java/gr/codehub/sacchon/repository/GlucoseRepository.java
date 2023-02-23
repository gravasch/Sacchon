package gr.codehub.sacchon.repository;

import gr.codehub.sacchon.model.GlucoseLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GlucoseRepository extends JpaRepository<GlucoseLevel, Long> {



//    @Query(value = "SELECT AVG(measurement) FROM blood_glucose_level WHERE patient_id = :patientId AND measurement_datetime >= :startDate AND measurement_datetime <= :endDate", nativeQuery = true)
//    Double findAverageBloodGlucoseLevelByPatientIdAndDateRange(@Param("patientId") Long patientId, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);


}
