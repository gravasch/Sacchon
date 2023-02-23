package gr.codehub.sacchon.service;

import gr.codehub.sacchon.Dto.ConsultationDTO;
import gr.codehub.sacchon.Dto.DoctorDTO;
import gr.codehub.sacchon.Dto.PatientDTO;
import jdk.javadoc.doclet.Reporter;

import java.util.List;

public interface ReporterService {



    //Αυτό ίσως χρειάζεται να το δούμε.
    // Μπορεί να είναι λάθος η παράμετρος. Μπορεί να θέλει το id.
    List<ConsultationDTO> findConsultation(String medicationName);

    List<PatientDTO> readAllPatient();

    List<DoctorDTO> readAllDoctor();


}
