package cn.sixdoctors.doctor.service;

import cn.sixdoctors.doctor.dao.DoctorDAO;
import cn.sixdoctors.doctor.dao.DoctorPatientDAO;
import cn.sixdoctors.doctor.dao.PatientDAO;
import cn.sixdoctors.doctor.model.Doctor;
import cn.sixdoctors.doctor.model.DoctorPatient;
import cn.sixdoctors.doctor.model.PassportUser;
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

    @Resource
    private DoctorDAO doctorDAO;

    public List<DoctorPatient> getPatients(int doctorId) {
        return doctorPatientDAO.findByDoctorId(doctorId);
    }

    public Patient getPatient(int patientId) {
        return patientDAO.findByPatientId(patientId);
    }

    public Patient createPatient(PassportUser user, Patient patient) {
        patientDAO.insert(patient);
        DoctorPatient doctorPatient = new DoctorPatient();
        doctorPatient.setDoctorId(user.getUserDetailId());
        doctorPatient.setDoctorName(doctorDAO.findByDoctorId(user.getUserDetailId()).getDoctorName());
        doctorPatient.setPatientId(patient.getPatientId());
        doctorPatient.setPatientName(patient.getPatientName());
        doctorPatient.setStatus("update");
        doctorPatientDAO.insert(doctorPatient);
        return patient;
    }

    public Patient updatePatient(Patient patient) {
        patientDAO.update(patient);
        return patient;
    }
}
