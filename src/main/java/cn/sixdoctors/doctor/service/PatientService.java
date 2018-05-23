package cn.sixdoctors.doctor.service;

import cn.sixdoctors.doctor.dao.DoctorPatientDAO;
import cn.sixdoctors.doctor.dao.PatientDAO;
import cn.sixdoctors.doctor.model.DoctorPatient;
import cn.sixdoctors.doctor.model.Patient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Resource
    private DoctorPatientDAO doctorPatientDAO;

    @Resource
    private PatientDAO patientDAO;

    public List<DoctorPatient> getPatients(int doctorId) {
        return doctorPatientDAO.findByDoctorId(doctorId);
    }

    public Patient getPatient(int patientId) {
        return patientDAO.findByPatientId(patientId);
    }

    public Patient createPatient(Patient patient) {
        patientDAO.insert(patient);
        return patient;
    }

    public Patient updatePatient(Patient patient) {
        patientDAO.update(patient);
        return patient;
    }
}
