package gr.codehub.sacchon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gr.codehub.sacchon.model.Doctor;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
