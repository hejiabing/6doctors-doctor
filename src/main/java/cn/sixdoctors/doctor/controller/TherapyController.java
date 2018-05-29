package cn.sixdoctors.doctor.controller;

import cn.sixdoctors.doctor.model.Patient;
import cn.sixdoctors.doctor.model.Therapy;
import cn.sixdoctors.doctor.vo.TherapyVO;
import cn.sixdoctors.doctor.vo.VO;
import cn.sixdoctors.doctor.wrapper.TherapyWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TherapyController {

    @Resource
    private TherapyWrapper therapyWrapper;

    @GetMapping("/getTherapies")
    public VO<List<TherapyVO>> getTherapies(@RequestParam String token, @RequestParam int patientId) {
        return therapyWrapper.getTherapies(patientId);
    }

    @GetMapping("/getTherapy")
    public VO<TherapyVO> getTherapy(@RequestParam String token, @RequestParam int therapyId) {
        return therapyWrapper.getTherapy(therapyId);
    }

    @PostMapping("/createTherapy")
    public VO<TherapyVO> createTherapy(@RequestParam MultipartFile[] photos,
                                     @RequestParam String token,
                                     @RequestParam int doctorId,
                                     @RequestParam int patientId,
                                     @RequestParam String state,
                                     @RequestParam String date,
                                     @RequestParam String record) throws IOException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = format.parse(date);
        return therapyWrapper.createTherapy(photos, doctorId, patientId, state, d, record);
    }

    @PostMapping("/updateTherapy")
    public VO<TherapyVO> updateTherapy(@RequestParam MultipartFile[] photos,
                                       @RequestParam String token,
                                       @RequestParam int therapyId,
                                       @RequestParam int doctorId,
                                       @RequestParam int patientId,
                                       @RequestParam String state,
                                       @RequestParam String date,
                                       @RequestParam String record) throws IOException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = format.parse(date);
        return therapyWrapper.updateTherapy(photos,therapyId, doctorId, patientId, state, d, record);
    }
}
