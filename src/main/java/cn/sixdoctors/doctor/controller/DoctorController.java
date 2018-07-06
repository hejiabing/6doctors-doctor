package cn.sixdoctors.doctor.controller;

import cn.sixdoctors.doctor.model.Label;
import cn.sixdoctors.doctor.model.LabelPatient;
import cn.sixdoctors.doctor.vo.PatientVO;
import cn.sixdoctors.doctor.vo.VO;
import cn.sixdoctors.doctor.wrapper.LabelWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation("添加标签（分组）")
    @PostMapping(value = "/addLabel")
    public VO<Label> addLabel(@RequestParam String token, @RequestParam String name, @ApiIgnore @RequestAttribute Integer doctorId) {
        return labelWrapper.addLabel(name, doctorId);
    }

    @ApiOperation("更新已经存在的标签（分组）名")
    @PostMapping(value = "/updateLabel")
    public VO<Label> updateLabel(@RequestParam String token, @RequestParam String name,
                                 @RequestParam int labelId,
                                 @ApiIgnore @RequestAttribute Integer doctorId) {
        return labelWrapper.updateLabel(labelId, name, doctorId);
    }

    @ApiOperation("删除标签（分组）")
    @PostMapping(value = "/delLabel")
    public VO<Label> delLabel(@RequestParam String token, @RequestParam int labelId,
                              @ApiIgnore @RequestAttribute Integer doctorId) {
        return labelWrapper.delLabel(labelId, doctorId);
    }

    @ApiOperation("查看自己创建的所有标签（分组）（主治医生显示全部）")
    @PostMapping(value = "/findLabelsByDoctorId")
    public VO<List<Label>> findLabelsByDoctorId(@RequestParam String token,
                                                @ApiIgnore @RequestAttribute Integer doctorId) {
        return labelWrapper.findLabelsByDoctorId(doctorId);
    }

    @ApiOperation("给病人添加已经存在标签（分组）")
    @PostMapping(value = "/addLabelPatients")
    public VO<List<LabelPatient>> addLabelPatients(@RequestParam String token,
                                                   @RequestParam List<Integer> patientsId,
                                                   @RequestParam int labelId,
                                                   @ApiIgnore @RequestAttribute Integer doctorId) {
        return labelWrapper.addLabelPatient(labelId, patientsId, doctorId);
    }

    @ApiOperation("移除病人的标签（分组）")
    @PostMapping(value = "/delLabelPatient")
    public VO<LabelPatient> delLabelPatient(@RequestParam String token, @RequestParam int labelPatientId,
                                            @ApiIgnore @RequestAttribute Integer doctorId) {
        return labelWrapper.delLabelPatient(labelPatientId, doctorId);
    }

    @ApiOperation("查看标签（分组）中的所有患者")
    @PostMapping(value = "/findByLabelId")
    public VO<List<PatientVO>> findByLabelId(@RequestParam String token,
                                             @RequestParam int labelId,
                                             @ApiIgnore @RequestAttribute Integer doctorId) {
        return labelWrapper.findByLabelId(labelId, doctorId);
    }

    @ApiOperation("给病人添加不存在的标签（分组）")
    @PostMapping(value = "/addPatientToNoLabel")
    public VO<List<LabelPatient>> addPatientToNoLabel(@RequestParam String token,
                                                      @RequestParam List<Integer> patientsId,
                                                      @RequestParam String labelName,
                                                      @ApiIgnore @RequestAttribute Integer doctorId) {
        return labelWrapper.addPatientToNoLabel(labelName, patientsId, doctorId);
    }
}
