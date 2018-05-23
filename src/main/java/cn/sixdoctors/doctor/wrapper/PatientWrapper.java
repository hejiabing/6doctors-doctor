package cn.sixdoctors.doctor.wrapper;

import cn.sixdoctors.doctor.model.DoctorPatient;
import cn.sixdoctors.doctor.model.Patient;
import cn.sixdoctors.doctor.service.PatientService;
import cn.sixdoctors.doctor.vo.VO;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class PatientWrapper {

    @Resource
    private PatientService patientService;

    public VO<List<DoctorPatient>> getPatients(int doctorId) {
        return new VO<>(patientService.getPatients(doctorId));
    }

    public VO<Patient> getPatient(int patientId) {
        return new VO<>(patientService.getPatient(patientId));
    }

    public VO<Patient> createPatient(Patient patient) {
        return new VO<>(patientService.createPatient(patient));
    }

    public VO<Patient> updatePatient(Patient patient) {
        return new VO<>(patientService.updatePatient(patient));
    }
}
