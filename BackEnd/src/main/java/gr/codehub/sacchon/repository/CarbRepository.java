package gr.codehub.sacchon.repository;

import gr.codehub.sacchon.model.CarbMeasurements;
import gr.codehub.sacchon.model.GlucoseLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface CarbRepository extends JpaRepository<CarbMeasurements, Long> {

    @Query(value = "SELECT avg(gram) FROM carb_measurements WHERE patient_id = :patientId",nativeQuery = true)
    Double findAvgCarb(@Param("patientId") Long patientId);

    @Query(value="SELECT c FROM CarbMeasurements c WHERE c.patient.id = :id AND (c.date BETWEEN :startDate AND :endDate)",nativeQuery = false)
    List<CarbMeasurements> findCarbsBetweenDates(@Param("id") Long id, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);




}
