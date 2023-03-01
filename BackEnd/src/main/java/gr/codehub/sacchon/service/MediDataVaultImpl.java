package gr.codehub.sacchon.service;
import gr.codehub.sacchon.Dto.CarbMeasurementsDTO;
import gr.codehub.sacchon.Dto.GlucoseLevelDTO;
import gr.codehub.sacchon.Dto.PatientDTO;
import gr.codehub.sacchon.exceptions.MediDataVaultException;
import gr.codehub.sacchon.model.*;
import gr.codehub.sacchon.repository.CarbRepository;
import gr.codehub.sacchon.repository.GlucoseRepository;
import gr.codehub.sacchon.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class MediDataVaultImpl implements MediDataVaultService {



//    @Autowired needed?
    private final PatientRepository patientRepository;
    private  final GlucoseRepository glucoseRepository;
    private final CarbRepository carbRepository;

    @Override
    public String ping() {
        return "This is patient's endpoints";
    }


    //Account settings
    @Override
    public PatientDTO createPatient(PatientDTO patientDto) {
        Patient patient = patientDto.asPatient();
        return new PatientDTO(patientRepository.save(patient)) ;
    }



    @Override
    public PatientDTO readPatient(Long id) throws MediDataVaultException {
        return new PatientDTO(readPatientDb(id));
    }


    private Patient readPatientDb(Long id) throws MediDataVaultException{
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent())
            return patientOptional.get() ;
        throw new MediDataVaultException("Patient not found id= " +id) ;
    }



    @Override
    public boolean updatePatient(PatientDTO patient, Long id) {
        boolean action ;
        try {
            Patient dbPatient = readPatientDb(id);
            dbPatient.setFirstname(patient.getFirstname());
            dbPatient.setLastname(patient.getLastname());
            dbPatient.setUsername(patient.getUsername());
            dbPatient.setIsactive(patient.getIsactive());
            dbPatient.setAddress(patient.getAddress());
            dbPatient.setCity(patient.getCity());
            dbPatient.setDiabetestype(patient.getDiabetestype());
            patientRepository.save(dbPatient);
            action = true;
        } catch (MediDataVaultException e) {
            action = false;
        }
        return action;
    }

    @Override
    public boolean deletePatient(Long id) {
        boolean action;
        try {
            Patient dbPatient = readPatientDb(id);
            patientRepository.delete(dbPatient);
            action = true;
        }catch (MediDataVaultException e) {
            action = false;
        }
        return action;
    }
//
//
//    //Add measurements
//
//    //GlucoseLevel
    @Override
    public GlucoseLevelDTO createGlucose(GlucoseLevelDTO glucoseLevelDto, Long patientId) throws MediDataVaultException {
        GlucoseLevel glucoseLevel = glucoseLevelDto.asGlucoseLevel();
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isEmpty() ){
            throw new MediDataVaultException("PatientId is not found.");
        }
        Patient patient = patientOptional.get();
        glucoseLevel.setPatient(patient);
        return new GlucoseLevelDTO(glucoseRepository.save(glucoseLevel));
    }

    @Override
    public List<GlucoseLevelDTO> readAllGlucose(){
        return glucoseRepository
                .findAll()
                .stream()
                .map(GlucoseLevelDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public GlucoseLevelDTO readGlucose(Long id) throws MediDataVaultException {
        return new GlucoseLevelDTO( readGlucoseDb(id));

    }

    public GlucoseLevel readGlucoseDb(Long id) throws MediDataVaultException {
        Optional<GlucoseLevel> glucoseLevelOptional = glucoseRepository.findById(id);
        if (glucoseLevelOptional.isPresent())
            return glucoseLevelOptional.get() ;
        throw new MediDataVaultException("Glucose Level not found id= " + id);
    }

    @Override
    public boolean updateGlucose(GlucoseLevelDTO glucoselevel, Long id) {
        boolean action;
        try {
            GlucoseLevel dbGlucose = readGlucoseDb(id);
            dbGlucose.setGlTime(glucoselevel.getGlTime());
            dbGlucose.setGlDate(glucoselevel.getGlDate());
            dbGlucose.setMeasurement(glucoselevel.getMeasurement());
            glucoseRepository.save(dbGlucose);
            action = true;
        } catch (MediDataVaultException e)   {
            action = false;
        }
        return action;
    }

    @Override
    public boolean deleteGlucose(Long id){
        boolean action;
        try {
            GlucoseLevel dbGlucose = readGlucoseDb((id));
            glucoseRepository.delete(dbGlucose);
            action = true;
        } catch (MediDataVaultException e) {
            action = false;
        }
        return  action;
    }



    //CarbMeasurements

    @Override
    public CarbMeasurementsDTO createCarb(CarbMeasurementsDTO carbMeasurementsDto, Long patientId) throws MediDataVaultException {
        CarbMeasurements carbMeasurements = carbMeasurementsDto.asCarbMeasurements();
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isEmpty() ){
            throw new MediDataVaultException("PatientId is not found.");
        }
        Patient patient = patientOptional.get();
        carbMeasurements.setPatient(patient);
        return new CarbMeasurementsDTO(carbRepository.save(carbMeasurements));
    }

    @Override
    public List<CarbMeasurementsDTO> readAllCarbs() {
        return carbRepository.findAll()
                .stream()
                .map(CarbMeasurementsDTO::new)
                .collect(Collectors.toList());
    }


    public CarbMeasurements readCarbsDb(Long id) throws MediDataVaultException {
        Optional<CarbMeasurements> carbMeasurements = carbRepository.findById(id);
        if (carbMeasurements.isPresent())
            return carbMeasurements.get();
        throw new MediDataVaultException("CarbMeasurement with id " + id + " not found");
    }

    @Override
    public CarbMeasurementsDTO readCarbs(Long id) throws MediDataVaultException {
        return new CarbMeasurementsDTO(readCarbsDb(id));

    }

    @Override
    public Double findAvgGlucose(Long patientId) {
        return glucoseRepository.findAvgGlucose(patientId);
    }

    @Override
    public Double findAvgCarb(Long patientId) {
        return carbRepository.findAvgCarb(patientId);
    }

    private CarbMeasurements readCarbMeasurementsDb(Long id) throws MediDataVaultException {
        Optional<CarbMeasurements> carbMeasurementsOptional = carbRepository.findById(id);
        if (carbMeasurementsOptional.isPresent())
            return   carbMeasurementsOptional.get() ;
        throw new MediDataVaultException("CarbMeasurements not found id= " + id);
    }



    @Override
    public boolean updateCarb(CarbMeasurementsDTO carbMeasurementsDTO, Long id) {
        boolean action;
        try {
            CarbMeasurements dbCarbMeasurements = readCarbMeasurementsDb(id);
            dbCarbMeasurements.setDate(carbMeasurementsDTO.getDate());
            dbCarbMeasurements.setGram(carbMeasurementsDTO.getGram());
            carbRepository.save(dbCarbMeasurements);
            action = true;
        } catch (MediDataVaultException e) {
            action = false;
        }
        return action;
    }

    @Override
    public boolean deleteCarb(Long id)  {
        boolean action;
        try {
            CarbMeasurements dbCarbMeasurements = readCarbMeasurementsDb(id);
            carbRepository.delete(dbCarbMeasurements);
            action = true;
        } catch (MediDataVaultException e) {
            action = false;
        }
        return action;

    }












}