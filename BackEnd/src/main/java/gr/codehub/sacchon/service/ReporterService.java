package gr.codehub.sacchon.service;

import gr.codehub.sacchon.Dto.*;

import java.time.LocalDate;
import java.util.List;

public interface ReporterService {
    List<PatientDTO> readAllPatient();

    List<DoctorDTO> readAllDoctor();

  List<GlucoseLevelDTO> findGlucoseBetweenDates(Long id, LocalDate startDate, LocalDate endDate);

  List<CarbMeasurementsDTO> findCarbsBetweenDates(Long id, LocalDate startDate, LocalDate endDate);

  List<ConsultationDTO> findConsultationBetweenDates(Long patient_id, Long doctor_id, LocalDate startDate, LocalDate endDate);



}
