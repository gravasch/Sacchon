package gr.codehub.sacchon.controller;

import gr.codehub.sacchon.repository.ConsultationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ReporterController {

    @GetMapping("/Reporter/ping")
    public String ping() {
        log.info("The end point Reporter ping has been used");
        return "Reporter ping";
    }



}
