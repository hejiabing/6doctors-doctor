package cn.sixdoctors.doctor.service;

import cn.sixdoctors.doctor.dao.*;
import cn.sixdoctors.doctor.model.Doctor;
import cn.sixdoctors.doctor.model.DoctorPatient;
import cn.sixdoctors.doctor.model.PassportUser;
import cn.sixdoctors.doctor.model.Patient;
import cn.sixdoctors.doctor.vo.PatientInfoVO;
import cn.sixdoctors.doctor.vo.PatientVO;
import cn.sixdoctors.doctor.vo.TherapyVO;
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

    @Resource
    private PatientDTODAO patientDTODAO;

    @Resource
    private PatientInfoDTODAO patientInfoDTODAO;

    public List<PatientVO> getPatients(int doctorId) {

        Doctor doctor = doctorDAO.findByDoctorId(doctorId);

        if (doctor.getRole() == 101) {
            return patientDTODAO.findAll();
        } else {
            return patientDTODAO.findByDoctorId(doctorId);
        }

    }

    public Patient getPatient(int patientId) {
        return patientDAO.findByPatientId(patientId);
    }

    public PatientInfoVO getPatientInfo(int patientId) {
        PatientInfoVO patientInfoVO = patientInfoDTODAO.findByPatientId(patientId);
        for (int i = 0; i < patientInfoVO.getTherapies().size(); i++) {
            if (patientInfoVO.getTherapies().get(i).getPhotos().size() == 1
                    && patientInfoVO.getTherapies().get(i).getPhotos().get(0).getCaseId() == 0) {
                patientInfoVO.getTherapies().get(i).setPhotos(null);
            }
        }
        patientInfoVO.initPatientInfo();
        return patientInfoVO;
    }

    public Patient createPatient(PassportUser user, Patient patient) {
        patientDAO.insert(patient);
        DoctorPatient doctorPatient = new DoctorPatient();
        doctorPatient.setDoctorId(user.getUserDetailId());
        doctorPatient.setDoctorName(doctorDAO.findByDoctorId(user.getUserDetailId()).getDoctorName());
        doctorPatient.setPatientId(patient.getPatientId());
        doctorPatient.setPatientName(patient.getPatientName());
        doctorPatient.setStatus("未就诊");
        doctorPatientDAO.insert(doctorPatient);
        return patient;
    }

    public Patient updatePatient(Patient patient) {
        patientDAO.update(patient);
        return patient;
    }

    public List<PatientVO> getByLabelId(int labelId, int doctorId) {

        Doctor doctor = doctorDAO.findByDoctorId(doctorId);

        if (doctor.getRole() == 101) {
            return patientDTODAO.findAllByLabelId(labelId);
        } else {
            return patientDTODAO.findByLabelId(labelId, doctorId);
        }

    }
}
