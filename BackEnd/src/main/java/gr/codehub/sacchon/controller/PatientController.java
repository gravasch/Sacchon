package gr.codehub.sacchon.controller;

import gr.codehub.sacchon.Dto.CarbMeasurementsDTO;
import gr.codehub.sacchon.Dto.GlucoseLevelDto;
import gr.codehub.sacchon.Dto.PatientDTO;
import gr.codehub.sacchon.exceptions.MediDataVaultException;
import gr.codehub.sacchon.service.MediDataVaultService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j

public class PatientController {

    private MediDataVaultService mediDataVaultService ;

    @GetMapping("Patient/ping")
    public String ping() {
        log.info("The end point ping has been used");
        return mediDataVaultService.ping();
    }

    //View Patient Account by ID
    @GetMapping("/Patient/{id}")
    public PatientDTO getPatient(@PathVariable(name = "id") Long id) throws Exception {
        log.info("The end point patient by id has been used");
        return mediDataVaultService.readPatient(id);
    }
    //Create patient
    @PostMapping("/Patient")
    public PatientDTO createPatientDto(@RequestBody PatientDTO patientDTO) {
        log.info("The end point PatientDto - create patient has been used");
        return mediDataVaultService.createPatient(patientDTO);
    }
    //Update patient with ID
    @PutMapping("/Patient/{id}")
    public boolean updatePatientDTO(@RequestBody PatientDTO patientDTO, @PathVariable(name = "id") Long id) {
        //log.info("The end point PatientDto - update patient has been used");
        return mediDataVaultService.updatePatient(patientDTO, id);
    }

    //Delete patient by ID
    @DeleteMapping("/Patient/{id}")
    public boolean deletePatientDTO(@PathVariable(name = "id") Long id) {
        log.info("The end point PatientDto - delete patient has been used");
        return mediDataVaultService.deletePatient(id);
    }

    //Glucose

    //Stores glucose level
    @PostMapping("/Patient/glucose")
    public GlucoseLevelDto storeGlucose(@RequestBody GlucoseLevelDto glucoseLevelDto) {
        log.info("The end point save glucose level has been used");
        return mediDataVaultService.createGlucose(glucoseLevelDto);
    }


    //View glucose level by patient's id
    @GetMapping("/Patient/glucose/{id}")
    public GlucoseLevelDto viewGlucose(@PathVariable(name = "id") Long id) throws Exception {
        log.info("The end point GlucoseLevelDto - view by id has been used");
        return mediDataVaultService.readGlucose(id);
    }

    //Save glucose level by patient's id
    @PutMapping("/Patient/glucose/{id}")
    public boolean updateGlucose(@RequestBody GlucoseLevelDto glucoseLevelDto,
                                 @PathVariable(name = "id") Long id) {
        log.info("The end point PatientDto - save glucose by patient id has been used");
        return mediDataVaultService.updateGlucose(glucoseLevelDto, id);
    }
    //Delete glucose level by patient's id
    @DeleteMapping("/Patient/glucose/{id}")
    public boolean deleteGlucose(@PathVariable(name = "id") Long id) {
        log.info("The end point PatientDto - delete glucose by patient id has been used");
        return mediDataVaultService.deleteGlucose(id);
    }

    //Carb Measurements

    // Stores carb measurements
    @PostMapping("/Patient/carbs")
public CarbMeasurementsDTO storeCarbMeasurement(@RequestBody CarbMeasurementsDTO carbMeasurementsDto) {
        log.info("The endpoint to store carb measurements has been used");
        return mediDataVaultService.create(carbMeasurementsDto);
    }

    // View carb measurements by patient's id
    @GetMapping("/Patient/{id}/carbs/{id}")
    public CarbMeasurementsDTO viewCarbMeasurements(@PathVariable(name = "id") Long id) throws Exception {
        log.info("The endpoint to view carb measurements by patient id has been used");
        return mediDataVaultService.readCarbs(id);
    }

    // Update carb measurements by patient's id
    @PutMapping("/Patient/{id}/carbs/{id}")
    public CarbMeasurementsDTO updateCarbMeasurement(@RequestBody CarbMeasurementsDTO carbMeasurementsDto,
                                                     @PathVariable(name = "id") Long id) throws Exception {
        log.info("The endpoint to update carb measurements by patient id has been used");
        carbMeasurementsDto.setCarbId(id);
        return mediDataVaultService.update(carbMeasurementsDto, id);
    }

    // Delete carb measurements by patient's id
    @DeleteMapping("/Patient/{id}/carbs/{id}")
    public void deleteCarbMeasurement(@PathVariable(name = "id") Long id) throws Exception {
        log.info("The endpoint to delete carb measurements by patient id has been used");
        mediDataVaultService.deleteCarb(id);
    }




}

