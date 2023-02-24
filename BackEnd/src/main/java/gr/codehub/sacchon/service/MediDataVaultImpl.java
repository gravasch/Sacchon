package gr.codehub.sacchon.service;
import gr.codehub.sacchon.Dto.CarbMeasurementsDTO;
import gr.codehub.sacchon.Dto.GlucoseLevelDto;
import gr.codehub.sacchon.Dto.PatientDTO;
import gr.codehub.sacchon.model.CarbMeasurements;
import gr.codehub.sacchon.model.GlucoseLevel;
import gr.codehub.sacchon.model.Patient;
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
    public PatientDTO readPatient(Long id) throws Exception {
        return new PatientDTO(readPatientDb(id));
    }


    private Patient readPatientDb(Long id) throws Exception{
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent())
            return patientOptional.get() ;
        throw new Exception("Patient not found id= " +id) ;
    }



    @Override
    public boolean updatePatient(PatientDTO patient, Long id) {
        boolean action ;
        try {
            Patient dbPatient = readPatientDb(id);
            dbPatient.setFirstName(patient.getFirstName());
            dbPatient.setLastName(patient.getLastName());
            dbPatient.setUsername(patient.getUsername());
            dbPatient.setIsActive(patient.getIsActive());
            dbPatient.setAddress(patient.getAddress());
            dbPatient.setCity(patient.getCity());
            dbPatient.setDiabetesType(patient.getDiabetesType());
            patientRepository.save(dbPatient);
            action = true;
        } catch (Exception e) {
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
        }catch (Exception e) {
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
    public GlucoseLevelDto createGlucose(GlucoseLevelDto glucoseLevelDto, Long patientId) throws Exception {
        GlucoseLevel glucoseLevel = glucoseLevelDto.asGlucoseLevel();
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isEmpty() ){
            throw new Exception("PatientId is not found.");
        }
        Patient patient = patientOptional.get();
        glucoseLevel.setPatient(patient);
        return new GlucoseLevelDto(glucoseRepository.save(glucoseLevel));
    }

    @Override
    public List<GlucoseLevelDto> readAllGlucose(){
        return glucoseRepository
                .findAll()
                .stream()
                .map(GlucoseLevelDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public GlucoseLevelDto readGlucose(Long id) throws Exception {
        return new GlucoseLevelDto( readGlucoseDb(id));

    }

    public GlucoseLevel readGlucoseDb(Long id) throws Exception {
        Optional<GlucoseLevel> glucoseLevelOptional = glucoseRepository.findById(id);
        if (glucoseLevelOptional.isPresent())
            return glucoseLevelOptional.get() ;
        throw new Exception("Glucose Level not found id= " + id);
    }

    @Override
    public boolean updateGlucose(GlucoseLevelDto glucoselevel, Long id) {
        boolean action;
        try {
            GlucoseLevel dbGlucose = readGlucoseDb(id);
            dbGlucose.setGlTime(glucoselevel.getGlTime());
            dbGlucose.setGlDate(glucoselevel.getGlDate());
            dbGlucose.setMeasurement(glucoselevel.getMeasurement());
            glucoseRepository.save(dbGlucose);
            action = true;
        } catch (Exception e)   {
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
        } catch (Exception e) {
            action = false;
        }
        return  action;
    }



    //CarbMeasurements

    @Override
    public CarbMeasurementsDTO createCarb(CarbMeasurementsDTO carbMeasurementsDto, Long patientId) throws Exception {
        CarbMeasurements carbMeasurements = carbMeasurementsDto.asCarbMeasurements();
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isEmpty() ){
            throw new Exception("PatientId is not found.");
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


    public CarbMeasurements readCarbsDb(Long id) throws Exception {
        Optional<CarbMeasurements> carbMeasurements = carbRepository.findById(id);
        if (carbMeasurements.isPresent())
            return carbMeasurements.get();
        throw new Exception("CarbMeasurement with id " + id + " not found");
    }

    @Override
    public CarbMeasurementsDTO readCarbs(Long id) throws Exception {
        return new CarbMeasurementsDTO(readCarbsDb(id));

    }


    @Override
    public CarbMeasurementsDTO updateCarb(CarbMeasurementsDTO carbMeasurementsDTO, Long id) throws Exception {
        Optional<CarbMeasurements> optionalCarbMeasurements = carbRepository.findById(id);
        if (optionalCarbMeasurements.isPresent())
            throw new Exception("CarbMeasurement with id " + id + " not found");
        CarbMeasurements carbMeasurements = optionalCarbMeasurements.get();
        carbMeasurements.setDate(carbMeasurementsDTO.getDate());
        carbMeasurements.setGram(carbMeasurementsDTO.getGram());
        return new CarbMeasurementsDTO(carbRepository.save(carbMeasurements));
    }

    @Override
    public boolean deleteCarb(long id) throws Exception {
        Optional<CarbMeasurements> optionalCarbMeasurements = carbRepository.findById(id);
        if (optionalCarbMeasurements.isPresent())
            throw new Exception("CarbMeasurement with id " + id + " not found");
        carbRepository.deleteById(id);
        return true;
    }












}