package main.java.gr.codehub.sacchon.repository;

import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepository extends JpaRepository<gr.codehub.sacchon.model.Doctor, Long> {
}
