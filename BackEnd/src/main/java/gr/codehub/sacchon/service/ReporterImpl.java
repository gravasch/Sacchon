package gr.codehub.sacchon.service;

import gr.codehub.sacchon.Dto.DoctorDTO;
import gr.codehub.sacchon.Dto.PatientDTO;
import gr.codehub.sacchon.Dto.ReporterDTO;
import gr.codehub.sacchon.model.Reporter;
import gr.codehub.sacchon.repository.DoctorRepository;
import gr.codehub.sacchon.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReporterImpl implements ReporterService{
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public ReporterDTO createReporter(ReporterDTO reporter) {
        return null;
    }

    @Override
    public List<ReporterDTO> findConsultation(String medicationName) {
        return null;
    }

    @Override
    public Reporter createReporter(Long patientId) {
        return null;
    }

    @Override
    public boolean addConsultationToReporter(long consultationId, long reporter_id) {
        return false;
    }

    @Override
    public List<String> getReporterConsultationIds(long reporter_id) {
        return null;
    }

    @Override
    public List<PatientDTO> readAllPatient() {
        return patientRepository
                .findAll()
                .stream()
                .map(PatientDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<DoctorDTO> readAllDoctor() {
        return doctorRepository
                .findAll()
                .stream()
                .map(DoctorDTO::new)
                .collect(Collectors.toList());
    }


}

