package gr.codehub.sacchon.service;

import gr.codehub.sacchon.Dto.DoctorDTO;
import gr.codehub.sacchon.Dto.GlucoseLevelDto;
import gr.codehub.sacchon.Dto.PatientDTO;
import gr.codehub.sacchon.Dto.ReporterDTO;
import gr.codehub.sacchon.model.Reporter;

import java.util.List;

public interface ReporterService {

    ReporterDTO createReporter(ReporterDTO reporter);

    //Αυτό ίσως χρειάζεται να το δούμε.
    // Μπορεί να είναι λάθος η παράμετρος. Μπορεί να θέλει το id.
    List<ReporterDTO> findConsultation(String medicationName);

    Reporter createReporter(Long patientId);

    //Add consultation to Reporter
    boolean addConsultationToReporter(long consultationId, long reporter_id);

    List<String> getReporterConsultationIds(long reporter_id);
    List<PatientDTO> readAllPatient();

    List<DoctorDTO> readAllDoctor();


}
