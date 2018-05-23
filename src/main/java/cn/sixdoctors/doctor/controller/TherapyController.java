package cn.sixdoctors.doctor.controller;

import cn.sixdoctors.doctor.model.Patient;
import cn.sixdoctors.doctor.model.Therapy;
import cn.sixdoctors.doctor.vo.VO;
import cn.sixdoctors.doctor.wrapper.TherapyWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TherapyController {

    @Resource
    private TherapyWrapper therapyWrapper;

    @GetMapping("/getTherapies")
    public VO<List<Therapy>> getTherapies(@RequestParam String token, @RequestParam int patientId) {
        return therapyWrapper.getTherapies(patientId);
    }

    @GetMapping("/getTherapy")
    public VO<Therapy> getTherapy(@RequestParam String token, @RequestParam int therapyId) {
        return therapyWrapper.getTherapy(therapyId);
    }

    @PostMapping("/createTherapy")
    public VO<Therapy> createTherapy(@RequestParam String token, @ModelAttribute Therapy therapy) {
        return therapyWrapper.createTherapy(therapy);
    }

    @PostMapping("/updateTherapy")
    public VO<Therapy> updateTherapy(@RequestParam String token, @ModelAttribute Therapy therapy) {
        return therapyWrapper.updateTherapy(therapy);
    }
}
