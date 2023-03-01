package gr.codehub.sacchon.service;

import gr.codehub.sacchon.Dto.DoctorDTO;
import gr.codehub.sacchon.Dto.GlucoseLevelDTO;
import gr.codehub.sacchon.Dto.PatientDTO;
import gr.codehub.sacchon.model.GlucoseLevel;
import gr.codehub.sacchon.repository.DoctorRepository;
import gr.codehub.sacchon.repository.GlucoseRepository;
import gr.codehub.sacchon.repository.PatientRepository;
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


}

