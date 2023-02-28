package gr.codehub.sacchon.service;

import gr.codehub.sacchon.Dto.ConsultationDTO;
import gr.codehub.sacchon.Dto.DoctorDTO;
import gr.codehub.sacchon.exceptions.DoctorAdviceException;
import gr.codehub.sacchon.model.Patient;

import java.util.List;


public interface DoctorAdviceService {
    DoctorDTO createDoctor(DoctorDTO doctor);

    DoctorDTO readDoctor(Long id) throws DoctorAdviceException;
    boolean updateDoctor(DoctorDTO doctor, Long id);
    boolean deleteDoctor(Long id) ;

    ConsultationDTO createConsultation(ConsultationDTO consultationDTO, Long doctorId, Long patientId) throws DoctorAdviceException;
    List<ConsultationDTO> readAllPatientConsultation(Long patientId) throws DoctorAdviceException;

    List<ConsultationDTO> findPatientConsultation(Long patientId);
    ConsultationDTO readConsultation(Long id) throws DoctorAdviceException;
    boolean updateConsultation(ConsultationDTO consultationDTO, Long id);
    boolean deleteConsultation(Long id) ;

    String ping();
}
