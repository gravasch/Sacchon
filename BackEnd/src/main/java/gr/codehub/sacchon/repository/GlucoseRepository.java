package main.java.gr.codehub.sacchon.repository;

import org.springframework.data.jpa.repository.JpaRepository;


public interface GlucoseRepository extends JpaRepository<gr.codehub.sacchon.model.Glucose, Long> {
}
