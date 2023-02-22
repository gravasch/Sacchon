package gr.codehub.sacchon.configuration;

import gr.codehub.sacchon.model.Patient;
import gr.codehub.sacchon.repository.DoctorRepository;
import gr.codehub.sacchon.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(
    PatientRepository patientRepository , DoctorRepository doctorRepository){
        return args -> {
            //Patient patient1 = new Patient(1, "Chris", "Zaoro", "Xalkidikis 1", "1990-2-1", "A", true);

        };
    }
}
