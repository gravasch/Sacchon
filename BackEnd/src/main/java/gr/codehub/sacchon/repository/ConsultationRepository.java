package gr.codehub.sacchon.repository;

import gr.codehub.sacchon.model.CarbMeasurements;
import gr.codehub.sacchon.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    @Query(value= "SELECT * FROM Consultation WHERE patient_id = :id ORDER BY consultation_date DESC", nativeQuery = true)
    List<Consultation>  findPatientConsultation(Long id);

    @Query(value="SELECT c FROM Consultation c WHERE c.patient.id = :patient_id AND c.doctor.id = :doctor_id AND (c.consultationDate BETWEEN :startDate AND :endDate)",nativeQuery = false)
    List<Consultation> findConsultationBetweenDates(@Param("patient_id") Long patient_id, @Param("doctor_id")Long doctor_id, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
