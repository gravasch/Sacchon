package gr.codehub.sacchon.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class CrmRestController {

    @GetMapping("/ping")
    public String ping(){
        return "ping";

    }
}
