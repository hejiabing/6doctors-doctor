package cn.sixdoctors.doctor.controller;

import cn.sixdoctors.doctor.model.Label;
import cn.sixdoctors.doctor.model.LabelPatient;
import cn.sixdoctors.doctor.vo.PatientVO;
import cn.sixdoctors.doctor.vo.VO;
import cn.sixdoctors.doctor.wrapper.LabelWrapper;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by wangpengcheng on 2018/7/5.
 */
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Resource
    private LabelWrapper labelWrapper;

    @PostMapping(value = "/addLabel")
    public VO<Label> addLabel(@RequestParam String token, @RequestParam String name, @ApiIgnore @RequestAttribute Integer doctorId) {
        return labelWrapper.addLabel(name, doctorId);
    }

    @PostMapping(value = "/updateLabel")
    public VO<Label> updateLabel(@RequestParam String token, @RequestParam String name,
                                 @RequestParam int labelId,
                                 @ApiIgnore @RequestAttribute Integer doctorId) {
        return labelWrapper.updateLabel(labelId, name, doctorId);
    }

    @PostMapping(value = "/delLabel")
    public VO<Label> delLabel(@RequestParam String token, @RequestParam int labelId,
                              @ApiIgnore @RequestAttribute Integer doctorId) {
        return labelWrapper.delLabel(labelId, doctorId);
    }

    @PostMapping(value = "/findLabelsByDoctorId")
    public VO<List<Label>> findLabelsByDoctorId(@RequestParam String token,
                                                @ApiIgnore @RequestAttribute Integer doctorId) {
        return labelWrapper.findLabelsByDoctorId(doctorId);
    }

    @PostMapping(value = "/addLabelPatients")
    public VO<List<LabelPatient>> addLabelPatients(@RequestParam String token,
                                                   @RequestParam List<Integer> patientsId,
                                                   @RequestParam int labelId,
                                                   @ApiIgnore @RequestAttribute Integer doctorId) {
        return labelWrapper.addLabelPatient(labelId, patientsId, doctorId);
    }

    @PostMapping(value = "/delLabelPatient")
    public VO<LabelPatient> delLabelPatient(@RequestParam String token, @RequestParam int labelPatientId,
                                     @ApiIgnore @RequestAttribute Integer doctorId) {
        return labelWrapper.delLabelPatient(labelPatientId, doctorId);
    }

    @PostMapping(value = "/findByLabelId")
    public VO<List<PatientVO>> findByLabelId(@RequestParam String token,
                                                    @RequestParam int labelId,
                                                    @ApiIgnore @RequestAttribute Integer doctorId) {
        return labelWrapper.findByLabelId(labelId, doctorId);
    }
}
