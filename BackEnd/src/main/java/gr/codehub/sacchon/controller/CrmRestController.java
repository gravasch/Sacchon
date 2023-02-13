package gr.codehub.sacchon.controller;

import gr.codehub.sacchon.model.Patient;

import gr.codehub.sacchon.service.MediDataVault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrmRestController {


    private final MediDataVault mediDataVault;

    public CrmRestController(MediDataVault mediDataVault) {
        this.mediDataVault = mediDataVault;
    }

    @GetMapping("/patient")
    public Patient getPatient(){
        return mediDataVault.getPatient();

    }
}
