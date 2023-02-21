package gr.codehub.sacchon.repository;

import gr.codehub.sacchon.model.CarbMeasurements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarbRepository extends JpaRepository<CarbMeasurements, Long> {
}
