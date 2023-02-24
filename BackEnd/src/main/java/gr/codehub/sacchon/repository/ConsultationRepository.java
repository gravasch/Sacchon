package gr.codehub.sacchon.repository;

import gr.codehub.sacchon.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    @Query(value= "SELECT * FROM Consultation WHERE patient_id = :id ORDER BY consultation_date DESC", nativeQuery = true)
    List<Consultation>  findPatientConsultation(Long id);
}
