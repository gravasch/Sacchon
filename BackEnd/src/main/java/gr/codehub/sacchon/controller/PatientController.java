package gr.codehub.sacchon.controller;

import gr.codehub.sacchon.Dto.CarbMeasurementsDTO;
import gr.codehub.sacchon.Dto.GlucoseLevelDto;
import gr.codehub.sacchon.Dto.PatientDTO;
import gr.codehub.sacchon.service.MediDataVaultService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;



@RestController
@AllArgsConstructor
@Slf4j

public class PatientController {

    private MediDataVaultService mediDataVaultService ;

    @GetMapping("patient/ping")
    public String ping() {
        log.info("The end point ping has been used");
        return mediDataVaultService.ping();
    }

    //View Patient Account by ID
    @GetMapping("/patient/{id}")
    public PatientDTO getPatient(@PathVariable(name = "id") Long id) throws Exception {
        log.info("The end point patient by id has been used");
        return mediDataVaultService.readPatient(id);
    }
    //Create patient
    @PostMapping("/patient")
    public PatientDTO createPatientDto(@RequestBody PatientDTO patientDTO) {
        log.info("The end point PatientDto - create patient has been used");
        return mediDataVaultService.createPatient(patientDTO);
    }
    //Update patient with ID
    @PutMapping("/patient/{id}")
    public boolean updatePatientDTO(@RequestBody PatientDTO patientDTO, @PathVariable(name = "id") Long id) {
        //log.info("The end point PatientDto - update patient has been used");
        return mediDataVaultService.updatePatient(patientDTO, id);
    }

    //Delete patient by ID
    @DeleteMapping("/patient/{id}")
    public boolean deletePatientDTO(@PathVariable(name = "id") Long id) {
        log.info("The end point PatientDto - delete patient has been used");
        return mediDataVaultService.deletePatient(id);
    }

    //Glucose

    //Stores glucose level
    @PostMapping("/patient/glucose/{patientId}")
    public GlucoseLevelDto storeGlucose(@RequestBody GlucoseLevelDto glucoseLevelDto,
                                        @PathVariable (name = "patientId") Long patientId) throws Exception{
        log.info("The end point save glucose level has been used");
        return mediDataVaultService.createGlucose(glucoseLevelDto,patientId);
    }


    //View glucose level by patient's id
    @GetMapping("/patient/glucose/{id}")
    public GlucoseLevelDto viewGlucose(@PathVariable(name = "id") Long id) throws Exception {
        log.info("The end point GlucoseLevelDto - view by id has been used");
        return mediDataVaultService.readGlucose(id);
    }

    //Save glucose level by patient's id
    @PutMapping("/patient/glucose/{id}")
    public boolean updateGlucose(@RequestBody GlucoseLevelDto glucoseLevelDto,
                                 @PathVariable(name = "id") Long id) {
        log.info("The end point PatientDto - save glucose by patient id has been used");
        return mediDataVaultService.updateGlucose(glucoseLevelDto, id);
    }
    //Delete glucose level by patient's id
    @DeleteMapping("/patient/glucose/{id}")
    public boolean deleteGlucose(@PathVariable(name = "id") Long id) {
        log.info("The end point PatientDto - delete glucose by patient id has been used");
        return mediDataVaultService.deleteGlucose(id);
    }

    //Carb Measurements

    // Stores carb measurements
    @PostMapping("/patient/carbs/{patientId}")
    public CarbMeasurementsDTO storeCarbMeasurement(@RequestBody CarbMeasurementsDTO carbMeasurementsDTO,
                                                    @PathVariable (name = "patientId") Long patientId) throws Exception {
        log.info("The endpoint to store carb measurements has been used");
        return mediDataVaultService.createCarb(carbMeasurementsDTO,patientId);
    }

    // View carb measurements by patient's id
    @GetMapping("/patient/carbs/{carbsId}")
    public CarbMeasurementsDTO viewCarbMeasurements(@PathVariable(name = "carbsId") Long carbsId) throws Exception {
        log.info("The endpoint to view carb measurements by patient id has been used");
        return mediDataVaultService.readCarbs(carbsId);
    }

    // Update carb measurements by patient's id
    @PutMapping("/patient/carbs/{id}")
    public boolean updateCarbMeasurement(@RequestBody CarbMeasurementsDTO carbMeasurementsDto,
                                                     @PathVariable(name = "id") Long id)  {
        log.info("The endpoint to update carb measurements by patient id has been used");
        return mediDataVaultService.updateCarb(carbMeasurementsDto, id);
    }

    // Delete carb measurements by patient's id
    @DeleteMapping("/patient/carbs/{id}")
    public boolean deleteCarbMeasurement(@PathVariable(name = "id") Long id)  {
        log.info("The endpoint to delete carb measurements by patient id has been used");
       return mediDataVaultService.deleteCarb(id);
    }




}

