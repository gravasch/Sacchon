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

    //  Measurements

    //Glucose Level

    GlucoseLevelDto createGlucose(GlucoseLevelDto glucoseLevel);

    List<GlucoseLevelDto> readAllGlucose();

    GlucoseLevelDto readGlucose(Long id) throws Exception;

    boolean updateGlucose(GlucoseLevelDto glucoseLevel, Long id);

    boolean deleteGlucose(Long id);

    //Carb Measurements

    CarbMeasurementsDTO createCarbMeasurement(CarbMeasurementsDTO carbMeasurementsDTO);

    List<CarbMeasurementsDTO> readCarbMeasurements();


    CarbMeasurementsDTO create(CarbMeasurementsDTO dto);

    List<CarbMeasurementsDTO> readAllCarbs();

    CarbMeasurementsDTO readCarbsDb(long id) throws Exception;

    CarbMeasurementsDTO update(CarbMeasurementsDTO dto, long id) throws Exception;

    boolean deleteCarb(long id) throws Exception;

    CarbMeasurementsDTO readCarbs(Long id) throws Exception;
}
