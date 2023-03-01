package gr.codehub.sacchon.service;

import gr.codehub.sacchon.Dto.DoctorDTO;
import gr.codehub.sacchon.Dto.GlucoseLevelDTO;
import gr.codehub.sacchon.Dto.PatientDTO;

import java.time.LocalDate;
import java.util.List;

public interface ReporterService {
    List<PatientDTO> readAllPatient();

    List<DoctorDTO> readAllDoctor();

  //List<GlucoseLevelDTO> findGlucoseBetweenDates(Long id, LocalDate startDate, LocalDate endDate);
  List<GlucoseLevelDTO> findGlucoseBetweenDates(Long id, LocalDate startDate, LocalDate endDate);



}
