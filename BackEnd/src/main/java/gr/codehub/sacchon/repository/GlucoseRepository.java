package gr.codehub.sacchon.repository;

import gr.codehub.sacchon.model.GlucoseLevel;
import gr.codehub.sacchon.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface GlucoseRepository extends JpaRepository<GlucoseLevel, Long> {




    @Query(value="SELECT gl FROM GlucoseLevel gl WHERE gl.patient.id = :id AND (gl.glDate BETWEEN :startDate AND :endDate)",nativeQuery = false)
    List<GlucoseLevel> findGlucoseBetweenDates(@Param("id") Long id,@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


    @Query(value = "SELECT avg(measurement) FROM glucose_level WHERE patient_id = :patientId",nativeQuery = true)
    Double findAvgGlucose(@Param("patientId") Long patientId);
}
