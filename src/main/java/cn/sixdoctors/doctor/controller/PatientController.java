package cn.sixdoctors.doctor.controller;

import cn.sixdoctors.doctor.model.Patient;
import cn.sixdoctors.doctor.vo.VO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PatientController {

    @GetMapping("/patients")
    public VO<List<Patient>> getPatients(@RequestParam String token) {
        return null;
    }

    @GetMapping("/patient")
    public VO<Patient> getPatient(@RequestParam String token) {
        return null;
    }

    @PostMapping("/patient")
    public VO<Patient> createPatient(@RequestParam String token) {
        return null;
    }

    @PutMapping("/patient")
    public VO<Patient> updatePatient(@RequestParam String token) {
        return null;
    }

}
