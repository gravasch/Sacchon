package gr.codehub.sacchon.repository;

import gr.codehub.sacchon.model.GlucoseLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GlucoseRepository extends JpaRepository<GlucoseLevel, Long> {
}
