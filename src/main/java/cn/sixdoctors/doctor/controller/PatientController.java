package cn.sixdoctors.doctor.controller;

import cn.sixdoctors.doctor.model.DoctorPatient;
import cn.sixdoctors.doctor.model.Patient;
import cn.sixdoctors.doctor.vo.VO;
import cn.sixdoctors.doctor.wrapper.PatientWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Resource
    private PatientWrapper patientWrapper;

    @GetMapping("/getPatients")
    public VO<List<DoctorPatient>> getPatients(@RequestParam String token, @RequestParam int doctorId) {
        return patientWrapper.getPatients(doctorId);
    }

    @GetMapping("/getPatient")
    public VO<Patient> getPatient(@PathVariable int patientId, @RequestParam String token) {
        return patientWrapper.getPatient(patientId);
    }

    @PostMapping("/createPatient")
    public VO<Patient> createPatient(@RequestParam String token, @ModelAttribute Patient patient) {
        return patientWrapper.createPatient(patient);
    }

    @PostMapping("/updatePatient")
    public VO<Patient> updatePatient(@RequestParam String token, @ModelAttribute Patient patient) {
        return patientWrapper.updatePatient(patient);
    }

}
