package cn.sixdoctors.doctor.controller;

import cn.sixdoctors.doctor.model.Patient;
import cn.sixdoctors.doctor.model.Therapy;
import cn.sixdoctors.doctor.vo.VO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TherapyController {

    @GetMapping("/therapies")
    public VO<List<Therapy>> getTherapies(@RequestParam String token) {
        return null;
    }

    @GetMapping("/therapy")
    public VO<Therapy> getTherapy(@RequestParam String token) {
        return null;
    }

    @PostMapping("/therapy")
    public VO<Therapy> createTherapy(@RequestParam String token) {
        return null;
    }

    @PutMapping("/therapy")
    public VO<Therapy> updateTherapy(@RequestParam String token) {
        return null;
    }
}
