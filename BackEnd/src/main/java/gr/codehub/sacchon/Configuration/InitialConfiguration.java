package gr.codehub.sacchon.Configuration;


import gr.codehub.sacchon.model.*;
import gr.codehub.sacchon.repository.CarbRepository;
import gr.codehub.sacchon.repository.ConsultationRepository;
import gr.codehub.sacchon.repository.DoctorRepository;
import gr.codehub.sacchon.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class InitialConfiguration {

        @Bean
        CommandLineRunner commandLineRunner(
                DoctorRepository doctorRepository, ConsultationRepository consultationRepository, PatientRepository patientRepository,CarbRepository carbRepository) {
            return args -> {
                Doctor doctor1 = new Doctor(  1L,  "Malvina", "Zatka", "mzatka", LocalDate.now(),
                        DoctorType.DOCTOR, true ,null, null);

                Doctor doctor2 = new Doctor(  2L,  "Evaggelia", "Milosi", "emilosi", LocalDate.now(),
                        DoctorType.CHIEF, true ,null, null);

                List<Doctor> list =  doctorRepository.saveAll(List.of(doctor1, doctor2));

                Patient patient1 = new Patient(  1L,  "Malvina", "Zatka","zatkam", "martiou 25", "thessaloniki" , LocalDate.now(),
                        DiabetesType.TYPE1, true ,doctor1, null,null,null);

                Patient patient2 = new Patient(  2L,  "Evaggelia", "Milosi","emilosi", "karamanli", "Drama", LocalDate.now(),
                        DiabetesType.GESTATIONAL, true ,doctor2, null,null,null);

                List<Patient> list2 =  patientRepository.saveAll(List.of(patient1, patient2));



                Consultation consultation1 = new Consultation( 1L,"xanax",null, "once a day", LocalDate.now() ,doctor1, null);
                Consultation consultation2 = new Consultation( 2L,"zoloft",  new BigDecimal("2.05"), "three every day",LocalDate.now() ,doctor2, null);

                consultationRepository.saveAll(List.of(consultation1, consultation2));

                CarbMeasurements carbMeasurements1 = new CarbMeasurements(1L,LocalDate.now(), new BigDecimal("133.3"),patient1);
                CarbMeasurements carbMeasurements2 = new CarbMeasurements(2L,LocalDate.of(2023,02,28), new BigDecimal("142.9"),patient1);
                CarbMeasurements carbMeasurements3 = new CarbMeasurements(3L,LocalDate.now(), new BigDecimal("125.6"),patient2);
                CarbMeasurements carbMeasurements4 = new CarbMeasurements(4L,LocalDate.of(2023,02,28), new BigDecimal("130.4"),patient2);


                List<CarbMeasurements> list3 = carbRepository.saveAll(List.of(carbMeasurements1,carbMeasurements2,carbMeasurements3,carbMeasurements4));


                System.out.println(consultation1);
                System.out.println(doctor1);

            };
        }
}
