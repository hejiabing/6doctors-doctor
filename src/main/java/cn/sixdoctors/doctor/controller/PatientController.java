package cn.sixdoctors.doctor.controller;

import cn.sixdoctors.doctor.model.DoctorPatient;
import cn.sixdoctors.doctor.model.PassportUser;
import cn.sixdoctors.doctor.model.Patient;
import cn.sixdoctors.doctor.vo.VO;
import cn.sixdoctors.doctor.wrapper.PatientWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

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
    public VO<Patient> getPatient(@ApiIgnore @RequestAttribute PassportUser user, @RequestParam String token, @RequestParam int patientId) {
        return patientWrapper.getPatient(patientId);
    }

    @GetMapping("/getPatientInfo")
    public VO<Patient> getPatientInfo(@ApiIgnore @RequestAttribute PassportUser user, @RequestParam String token, @RequestParam int patientId) {
        return null;
    }

    @PostMapping("/createPatient")
    public VO<Patient> createPatient(@ApiIgnore @RequestAttribute PassportUser user,
                                     @RequestParam(required = false) MultipartFile photo,
                                     @RequestParam String token,
                                     @RequestParam String patientName,
                                     @RequestParam String gender,
                                     @RequestParam String mobPhone,
                                     @RequestParam int age,
                                     @RequestParam String identityType,
                                     @RequestParam String identityNum,
                                     @RequestParam String address,
                                     @RequestParam String place) throws IOException {
        return patientWrapper.createPatient(user, photo, patientName, gender, mobPhone, age, identityType, identityNum, address, place);
    }

    @PostMapping("/updatePatient")
    public VO<Patient> updatePatient(@ApiIgnore @RequestAttribute PassportUser user,
                                     @RequestParam(required = false) MultipartFile photo,
                                     @RequestParam String token,
                                     @RequestParam int patientId,
                                     @RequestParam String patientName,
                                     @RequestParam String gender,
                                     @RequestParam String mobPhone,
                                     @RequestParam int age,
                                     @RequestParam String identityType,
                                     @RequestParam String identityNum,
                                     @RequestParam String address,
                                     @RequestParam String place) throws IOException {
        return patientWrapper.updatePatient(user, photo, patientId, patientName, gender, mobPhone, age, identityType, identityNum, address, place);
    }

}
