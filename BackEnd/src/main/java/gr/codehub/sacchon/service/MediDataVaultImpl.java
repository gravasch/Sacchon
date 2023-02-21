package gr.codehub.sacchon.service;
import gr.codehub.sacchon.Dto.GlucoseLevelDto;
import gr.codehub.sacchon.Dto.PatientDTO;
import gr.codehub.sacchon.exceptions.MediDataVaultException;
import gr.codehub.sacchon.model.GlucoseLevel;
import gr.codehub.sacchon.model.Patient;
import gr.codehub.sacchon.repository.GlucoseRepository;
import gr.codehub.sacchon.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class MediDataVaultImpl implements MediDataVaultService {

    private final PatientRepository patientRepository;
    private  final GlucoseRepository glucoseRepository;


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
            dbPatient.setIsActive(patient.getIsActive());
            dbPatient.setAddress(patient.getAddress());
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
    public GlucoseLevelDto createGlucose(GlucoseLevelDto glucoseLevelDto) {
        GlucoseLevel glucoseLevel = glucoseLevelDto.asGlucoseLevel();
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


//
//    @Override
//    public CarbMeasurements addCarbMeasure(CarbMeasurementsDTO dciMeasurementDTO, Long patientId) {
//        return null;
//    }
//
//    //Updates Measurements
//    @Override
//    public GlucoseLevel updateBloodMeasure(BloodGlucoseMeasurementDTO BloodMeasureDTO, Long patientId) {
//        return null;
//    }
//
//    @Override
//    public CarbMeasurements updateCarbMeasure(CarbMeasurementsDTO dciMeasurementDTO, Long patientId) {
//        return null;
//    }
//
//
//    //Delete Measurements
//    @Override
//    public boolean deleteBloodMeasure(Long bloodMeasureId) {
//        return false;
//    }
//
//    @Override
//    public boolean deleteCarbMeasure(Long carbMeasureId) {
//        return false;
//    }
//
//    @Override
//    public List<Patient> getAllPatients() {
//        return null;
//    }



//    //Average Measurements
//    @Override
//    public Double avgBloodGlucoseMeasure(LocalDate begin, LocalDate end, Long patientId) {
//        return null;
//    }
//
//    @Override
//    public Double avgCarbMeasure(LocalDate begin, LocalDate end, Long patientId) {
//        return null;
//    }




}