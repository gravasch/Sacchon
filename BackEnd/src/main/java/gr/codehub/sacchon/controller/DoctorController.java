package gr.codehub.sacchon.controller;

import gr.codehub.sacchon.Dto.ConsultationDTO;
import gr.codehub.sacchon.Dto.DoctorDTO;
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


    @GetMapping("/Doctor/{id}")
    public DoctorDTO findDoctor(@PathVariable(name = "id") Long id) throws Exception {
        log.info("The end point DoctorDto has been used");
        return doctorService.readDoctor(id);
    }

    @PostMapping("/Doctor")
    public DoctorDTO createDoctorDto(@RequestBody DoctorDTO doctorDto) {
        log.info("The end point doctor has been used");
        return doctorService.createDoctor(doctorDto);
    }

    @PutMapping("/Doctor/{id}")
    public boolean updateDoctorDto(@RequestBody DoctorDTO doctorDto,
                                   @PathVariable(name = "id") Long id) {
        return doctorService.updateDoctor(doctorDto, id);
    }

    @DeleteMapping("/Doctor/{id}")
    public boolean deleteDoctorDto(@PathVariable(name = "id") Long id) {
        return doctorService.deleteDoctor(id);
    }

    @PostMapping("/Doctor/Consult")

    public ConsultationDTO createConsultation(@RequestBody ConsultationDTO consultationDTO) {
        log.info("The end point consultation has been used");
        return doctorService.createConsultation(consultationDTO);
    }

    @GetMapping("/Doctor/Consult/{id}")
    public ConsultationDTO findConsultation(@PathVariable(name = "id") Long id) throws Exception {
        log.info("The end point ConsultationDto has been used");
        return doctorService.readConsultation(id);
    }

    @PutMapping("/Doctor/Consult/{id}")
    public boolean updateConsultation(@RequestBody ConsultationDTO consultationDTO,
                                   @PathVariable(name = "id") Long id) {
        return doctorService.updateConsultation(consultationDTO, id);
    }

    @DeleteMapping("/Doctor/Consult/{id}")
    public boolean deleteConsultationDto(@PathVariable(name = "id") Long id) {
        return doctorService.deleteConsultation(id);
    }


}

