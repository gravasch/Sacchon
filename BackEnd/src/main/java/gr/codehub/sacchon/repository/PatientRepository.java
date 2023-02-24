package gr.codehub.sacchon.repository;

import gr.codehub.sacchon.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

//    @Query(value = "", nativeQuery = true)
//    List<Patient> findUnconsultedPatients(long did, LocalDate today, LocalDate before30);
}
