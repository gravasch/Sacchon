package gr.codehub.sacchon.service;


import gr.codehub.sacchon.Dto.CarbMeasurementsDTO;
import gr.codehub.sacchon.Dto.GlucoseLevelDto;
import gr.codehub.sacchon.Dto.PatientDTO;

import java.util.List;

public interface MediDataVaultService {

    //Account settings

    PatientDTO createPatient(PatientDTO patient);


    //Account settings

    PatientDTO readPatient(Long id) throws Exception;

    boolean updatePatient(PatientDTO patient, Long id);

    boolean deletePatient(Long id);
    String ping();

    //  Measurements

    //Glucose Level

    //
    //
    //    //Add measurements
    //
    //    //GlucoseLevel
    GlucoseLevelDto createGlucose(GlucoseLevelDto glucoseLevelDto, Long patientId) throws Exception;

    List<GlucoseLevelDto> readAllGlucose();

    GlucoseLevelDto readGlucose(Long id) throws Exception;

    boolean updateGlucose(GlucoseLevelDto glucoseLevel, Long id);

    boolean deleteGlucose(Long id);

    //Carb Measurements


    CarbMeasurementsDTO createCarb(CarbMeasurementsDTO carbMeasurementsDto, Long patientId) throws Exception;

    List<CarbMeasurementsDTO> readAllCarbs();

    //CarbMeasurementsDTO readCarbsDb(Long id) throws Exception;

    CarbMeasurementsDTO updateCarb(CarbMeasurementsDTO dto, Long id) throws Exception;

    boolean deleteCarb(long id) throws Exception;

    CarbMeasurementsDTO readCarbs(Long id) throws Exception;
}
