package gr.codehub.sacchon.controller;

import gr.codehub.sacchon.Dto.*;
import gr.codehub.sacchon.service.ReporterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;




@RestController
@AllArgsConstructor
@Slf4j
public class ReporterController {
    private ReporterService reporterService;


    //View Patient Account
    @GetMapping("/patient")
    public List<PatientDTO> getPatient() {
        log.info("The end point get patient has been used");
        return reporterService.readAllPatient();
    }


    @GetMapping("/doctor")
    public List<DoctorDTO> findAllDoctor() {
        log.info("The end point DoctorDto has been used");
        return reporterService.readAllDoctor();
    }

    @GetMapping("/glucose/{id}/betweenDates")
    public List<GlucoseLevelDTO> findGlucoseBetweenDates(@PathVariable(name = "id") Long id, @RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
        return reporterService.findGlucoseBetweenDates(id, startDate, endDate);
    }

    @GetMapping("/carbs/{id}/betweenDates")
    public List<CarbMeasurementsDTO> findCarbsBetweenDates(@PathVariable(name = "id") Long id, @RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
        return reporterService.findCarbsBetweenDates(id, startDate, endDate);
    }

    @GetMapping("/consultation/betweenDates/patient/{patient_id}/doctor/{doctor_id}")
    public List<ConsultationDTO> findConsultationBetweenDates(@PathVariable(name = "patient_id") Long patient_id, @PathVariable(name = "doctor_id") Long doctor_id, @RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
        return reporterService.findConsultationBetweenDates(patient_id, doctor_id,startDate, endDate);
    }
}
