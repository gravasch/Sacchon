package gr.codehub.sacchon.service;

import gr.codehub.sacchon.Dto.DoctorDTO;
import gr.codehub.sacchon.Dto.GlucoseLevelDto;
import gr.codehub.sacchon.Dto.PatientDTO;

import java.util.List;

public interface ReporterService {
    List<PatientDTO> readAllPatient();

    List<DoctorDTO> readAllDoctor();




}
