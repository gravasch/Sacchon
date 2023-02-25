package gr.codehub.sacchon.repository;

import gr.codehub.sacchon.model.GlucoseLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface GlucoseRepository extends JpaRepository<GlucoseLevel, Long> {



//    @Query(value = "SELECT AVG(measurement) FROM blood_glucose_level WHERE patient_id = :patientId AND measurement_datetime >= :startDate AND measurement_datetime <= :endDate", nativeQuery = true)
//    Double findAverageBloodGlucoseLevelByPatientIdAndDateRange(@Param("patientId") Long patientId, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

//    @Query("SELECT g FROM GlucoseLevel g WHERE g.date BETWEEN :startDate AND :endDate")
//    List<GlucoseLevel> findGlucoseInRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = "SELECT avg(measurement) FROM glucose_level WHERE patient_id = :patientId",nativeQuery = true)
    Double findAvgGlucose(@Param("patientId") Long patientId);
}
