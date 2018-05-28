package cn.sixdoctors.doctor.controller;

import cn.sixdoctors.doctor.model.DoctorPatient;
import cn.sixdoctors.doctor.model.Patient;
import cn.sixdoctors.doctor.vo.VO;
import cn.sixdoctors.doctor.wrapper.PatientWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
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
    public VO<Patient> getPatient(@RequestParam String token, @RequestParam int patientId) {
        return patientWrapper.getPatient(patientId);
    }

    @PostMapping("/createPatient")
    public VO<Patient> createPatient(@RequestParam MultipartFile[] photos,
                                     @RequestParam String token,
                                     @RequestParam String patientName,
                                     @RequestParam String gender,
                                     @RequestParam String mobPhone,
                                     @RequestParam int age,
                                     @RequestParam String identityType,
                                     @RequestParam String identityNum,
                                     @RequestParam String address,
                                     @RequestParam String place) throws IOException {
        return patientWrapper.createPatient(photos, patientName, gender, mobPhone, age, identityType, identityNum, address, place);
    }

    @PostMapping("/updatePatient")
    public VO<Patient> updatePatient(@RequestParam String token, @ModelAttribute Patient patient) {
        return patientWrapper.updatePatient(patient);
    }

}
