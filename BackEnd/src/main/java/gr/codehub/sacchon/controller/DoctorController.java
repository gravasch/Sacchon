package gr.codehub.sacchon.controller;

import gr.codehub.sacchon.Dto.ConsultationDTO;
import gr.codehub.sacchon.Dto.DoctorDTO;
import gr.codehub.sacchon.model.Patient;
import gr.codehub.sacchon.service.DoctorAdviceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@AllArgsConstructor
@Slf4j
public class DoctorController {
    private DoctorAdviceService doctorService;


    @GetMapping("/doctor/{id}")
    public DoctorDTO findDoctor(@PathVariable(name = "id") Long id) throws Exception {
        log.info("The end point DoctorDto has been used");
        return doctorService.readDoctor(id);
    }

    @PostMapping("/doctor")
    public DoctorDTO createDoctorDto(@RequestBody DoctorDTO doctorDto) {
        log.info("The end point doctor has been used");
        return doctorService.createDoctor(doctorDto);
    }

    @PutMapping("/doctor/{id}")
    public boolean updateDoctorDto(@RequestBody DoctorDTO doctorDto,
                                   @PathVariable(name = "id") Long id) {
        return doctorService.updateDoctor(doctorDto, id);
    }

    @DeleteMapping("/doctor/{id}")
    public boolean deleteDoctorDto(@PathVariable(name = "id") Long id) {
        return doctorService.deleteDoctor(id);
    }

    @PostMapping("/doctor/{doctorId}/consult/{patientId}")

    public ConsultationDTO createConsultation(@RequestBody ConsultationDTO consultationDTO,
                                              @PathVariable (name = "doctorId") Long doctorId,
                                              @PathVariable (name = "patientId") Long patientId) throws Exception{
        log.info("The end point consultation has been used");
        return doctorService.createConsultation(consultationDTO,doctorId,patientId);
    }

    @GetMapping("/doctor/consult/{patientId}")
    public List<ConsultationDTO>findAllPatientConsultation(@PathVariable(name = "patientId") Long patientId) throws Exception {
        log.info("The end point ConsultationDto has been used");
        return doctorService.readAllPatientConsultation(patientId);
    }

    @GetMapping("/doctor/consultation/{patientId}")
    public List<ConsultationDTO>findPatientConsultation(@PathVariable(name = "patientId") Long patientId) throws Exception {
        log.info("The end point ConsultationDto has been used");
        return doctorService.findPatientConsultation(patientId);
    }

    @PutMapping("/doctor/consult/{id}")
    public boolean updateConsultation(@RequestBody ConsultationDTO consultationDTO,
                                   @PathVariable(name = "id") Long id) {
        return doctorService.updateConsultation(consultationDTO, id);
    }

    @DeleteMapping("/doctor/consult/{id}")
    public boolean deleteConsultationDto(@PathVariable(name = "id") Long id) {
        return doctorService.deleteConsultation(id);
    }


}

