package gr.codehub.sacchon.controller;

import gr.codehub.sacchon.Dto.DoctorDTO;
import gr.codehub.sacchon.Dto.GlucoseLevelDto;
import gr.codehub.sacchon.Dto.PatientDTO;
import gr.codehub.sacchon.service.DoctorAdviceService;
import gr.codehub.sacchon.service.MediDataVaultService;
import gr.codehub.sacchon.service.ReporterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;




@RestController
@AllArgsConstructor
@Slf4j
public class ChiefController {
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

}
