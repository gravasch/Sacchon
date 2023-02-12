package gr.codehub.sacchon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrmRestController {

    @GetMapping("/ping")
    public String ping(){
        return "ping";

    }
}
