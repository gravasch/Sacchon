package gr.codehub.sacchon.repository;

import gr.codehub.sacchon.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    @Query(value = "select c from Consultation c where c.consultationId = :consultationId")
    List<Consultation> findAllConsultationbyId(long consultationId);
}
