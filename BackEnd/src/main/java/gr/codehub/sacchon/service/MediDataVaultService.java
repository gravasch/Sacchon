package gr.codehub.sacchon.service;


import gr.codehub.sacchon.Dto.CarbMeasurementsDTO;
import gr.codehub.sacchon.Dto.GlucoseLevelDto;
import gr.codehub.sacchon.Dto.PatientDTO;
import gr.codehub.sacchon.exceptions.MediDataVaultException;
import gr.codehub.sacchon.model.GlucoseLevel;
import gr.codehub.sacchon.model.CarbMeasurements;
import gr.codehub.sacchon.model.Patient;

import java.time.LocalDate;
import java.util.List;

public interface MediDataVaultService {

    //Account settings

    PatientDTO createPatient(PatientDTO patient);


    PatientDTO readPatient(Long id) throws Exception;

    boolean updatePatient(PatientDTO patient, Long id);

    boolean deletePatient(Long id);
    String ping();

    //Add measurements

    //GlucoseLevel

    GlucoseLevelDto createGlucose(GlucoseLevelDto glucoseLevel);

    List<GlucoseLevelDto> readAllGlucose();

    GlucoseLevelDto readGlucose(Long id) throws Exception;

    boolean updateGlucose(GlucoseLevelDto glucoseLevel, Long id);

    boolean deleteGlucose(Long id);



//    CarbMeasurements addCarbMeasure(CarbMeasurementsDTO CarbMeasureDTO, Long patientId);
//
//
//    Double avgBloodGlucoseMeasure(LocalDate begin, LocalDate end , Long patientId);
//
//    Double avgCarbMeasure(LocalDate begin, LocalDate end , Long patientId);
//
//    CarbMeasurements updateCarbMeasure(CarbMeasurementsDTO CarbMeasureDTO, Long patientId);
//    boolean deleteCarbMeasure(Long patientId);
//
//
//
//
////    Δεν ξερω αν τα χρειαζόμαστε αυτα
//
//
//    List<Patient> getAllPatients();
//
//    Patient getPatientById(Long patientId);
//
//    Patient createPatient(Patient patient);
//
//
//
//    Patient updatePatient(Patient patient);
//
//    String ping();
//
//    Patient readPatient(int id);
//
//    List<Patient> readPatient();
//
//    boolean deletePatient(Long id);
//
//    boolean updatePatient(Patient patient, int id);



}
