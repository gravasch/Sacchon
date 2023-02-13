package gr.codehub.sacchon.service;

import gr.codehub.sacchon.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class MediDataVaultImpl implements gr.codehub.sacchon.service.MediDataVault {

    @Override
    public Patient getPatient() {
        Patient patient = new Patient(11241421, "Nikos", "Takos");
//        patient.setPatientId(11241421);
//        patient.setFirstname("Nikos");
//        patient.setLastName("Takos");

        return patient;
    }
}
