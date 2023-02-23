package gr.codehub.sacchon.repository;

import gr.codehub.sacchon.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    //JPL
    //SQL Native

    //@Query(value = "SELECT * FROM Patient p WHERE p. LIKE value(null) , nativeQuery =true)
     //List<Patient> findPatientsNoActivity
}
