package gr.codehub.sacchon.service;

import gr.codehub.sacchon.Dto.*;
import gr.codehub.sacchon.model.CarbMeasurements;
import gr.codehub.sacchon.model.Consultation;
import gr.codehub.sacchon.model.GlucoseLevel;
import gr.codehub.sacchon.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReporterImpl implements ReporterService{
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final GlucoseRepository glucoseRepository;
    private final CarbRepository carbRepository;
    private final ConsultationRepository consultationRepository;


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

    @Override
    public List<GlucoseLevelDTO> findGlucoseBetweenDates(Long id, LocalDate startDate, LocalDate endDate) {
        List<GlucoseLevel> glList = glucoseRepository.findGlucoseBetweenDates(id,startDate, endDate);
        return glList
                .stream()
                .map(GlucoseLevelDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarbMeasurementsDTO> findCarbsBetweenDates(Long id, LocalDate startDate, LocalDate endDate) {
        List<CarbMeasurements> cList = carbRepository.findCarbsBetweenDates(id,startDate, endDate);
        return cList
                .stream()
                .map(CarbMeasurementsDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ConsultationDTO> findConsultationBetweenDates(Long patient_id, Long doctor_id, LocalDate startDate, LocalDate endDate) {
        List<Consultation> cList = consultationRepository.findConsultationBetweenDates(patient_id,doctor_id,startDate, endDate);
        return cList
                .stream()
                .map(ConsultationDTO::new)
                .collect(Collectors.toList());
    }


}

