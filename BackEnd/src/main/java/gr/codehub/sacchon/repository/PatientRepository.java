package main.java.gr.codehub.sacchon.repository;

import org.springframework.data.jpa.repository.JpaRepository;



public interface PatientRepository extends JpaRepository<gr.codehub.sacchon.model.Patient, Long> {
}
