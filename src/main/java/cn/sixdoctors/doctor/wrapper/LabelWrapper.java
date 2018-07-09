package cn.sixdoctors.doctor.wrapper;

import cn.sixdoctors.doctor.dao.LabelPatientDAO;
import cn.sixdoctors.doctor.exception.MyException;
import cn.sixdoctors.doctor.model.Label;
import cn.sixdoctors.doctor.model.LabelPatient;
import cn.sixdoctors.doctor.service.LabelService;
import cn.sixdoctors.doctor.service.PatientService;
import cn.sixdoctors.doctor.vo.PatientVO;
import cn.sixdoctors.doctor.vo.VO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wangpengcheng on 2018/7/6.
 */
@Service
public class LabelWrapper {

    @Resource
    private LabelService labelService;

    @Resource
    private PatientService patientService;

    public VO<Label> addLabel(String name, int doctorId) {
        if (name == null || name.trim().equals("") || doctorId == 0) {
            throw new MyException("参数有误!" + "name:" + name + "doctorId:" + doctorId);
        }

        Label label = new Label();
        label.setName(name);
        label.setDoctorId(doctorId);
        labelService.addLabel(label);
        return new VO<>(label);
    }

    public VO<Label> updateLabel(int labelId, String name, int doctorId) {
        if (name == null || name.trim().equals("") || doctorId == 0 || labelId == 0) {
            throw new MyException("参数有误!" + "name:" + name + "doctorId:" + doctorId + "labelId:" + labelId);
        }
        Label label = new Label();
        label.setDoctorId(doctorId);
        label.setName(name);
        label.setLabelId(labelId);

        if (labelService.updateLabel(label) == 1) {
            return new VO<>(label);
        } else {
            return new VO<Label>(0, "更新失败", label);
        }
    }

    public VO<Label> delLabel(int labelId, int doctorId) {
        if (doctorId == 0 || labelId == 0) {
            throw new MyException("参数有误!" + "doctorId:" + doctorId + "labelId:" + labelId);
        }
        Label label = new Label();
        label.setDoctorId(doctorId);
        label.setLabelId(labelId);
        labelService.delLabel(label);
        return new VO<>(label);
    }

    public VO<List<Label>> findLabelsByDoctorId(int doctorId) {
        if (doctorId == 0) {
            throw new MyException("参数有误!" + "doctorId:" + doctorId);
        }
        return new VO<>(labelService.findLabelsByDoctorId(doctorId));
    }

    public VO<List<LabelPatient>> addLabelPatient(int labelId, List<Integer> patientsId, int doctorId) {

        if (doctorId == 0 || labelId == 0 || patientsId.size() <= 0) {
            throw new MyException("参数有误!" + "doctorId:" + doctorId + "labelId:" + labelId + "patientsId:" + patientsId);
        }
        List<LabelPatient> labelPatients = createLabelPatients(labelId, patientsId);
        if (labelService.addLabelPatient(labelPatients) >= 0) {
            return new VO<>(labelPatients);
        } else {
            return new VO<>(0, "添加失败", labelPatients);
        }
    }

    public VO<LabelPatient> delLabelPatient(int labelPatientId, int doctorId) {
        if (doctorId == 0 || labelPatientId == 0) {
            throw new MyException("参数有误!" + "doctorId:" + doctorId + "labelPatientId:" + labelPatientId);
        }
        LabelPatient labelPatient = new LabelPatient();
        labelPatient.setLabelId(labelPatientId);
        labelService.delLabelPatient(labelPatientId);
        return new VO<>(labelPatient);
    }

    public List<LabelPatient> findLabelPatientsByLabelId(int labelId) {
        return labelService.findLabelPatientsByLabelId(labelId);
    }

    public List<LabelPatient> findLabelPatientsByPatientId(int patientId) {
        return labelService.findLabelPatientsByPatientId(patientId);
    }

    public VO<List<PatientVO>> findByLabelId(int labelId, Integer doctorId) {
        if (doctorId == 0 || labelId == 0) {
            throw new MyException("参数有误!" + "doctorId:" + doctorId + "labelId:" + labelId);
        }

        return new VO<>(patientService.getByLabelId(labelId, doctorId));

    }

    private List<LabelPatient> createLabelPatients(int labelId, List<Integer> patientsId) {
        List<LabelPatient> labelPatients = new ArrayList<>();
        for (int i : patientsId) {
            labelPatients.add(new LabelPatient(labelId, i));
        }
        return labelPatients;
    }

    public VO<List<LabelPatient>> addPatientToNoLabel(String labelName, List<Integer> patientsId, int doctorId) {

        if (doctorId == 0 || labelName == null || labelName.trim().equals("") || patientsId.size() <= 0) {
            throw new MyException("参数有误!" + "doctorId:" + doctorId + "labelName:" + labelName + "patientsId:" + patientsId);
        }

        // 最好数据库一次性通信完成，这里分成了两步网络访问
        List<Label> labels = labelService.findLabelsByDoctorId(doctorId);
        int labelId = 0;
        for (Label label : labels) {
            if (label.getName().equals(labelName.trim())) {
                labelId = label.getLabelId();
                break;
            }
        }

        if (labelId == 0) {
            Label label = new Label();
            label.setName(labelName.trim());
            label.setDoctorId(doctorId);
            labelService.addLabel(label);
            labelId = label.getLabelId();
        }

        List<LabelPatient> labelPatients = createLabelPatients(labelId, patientsId);
        if (labelService.addLabelPatient(labelPatients) >= 0) {
            return new VO<>(labelPatients);
        } else {
            return new VO<>(0, "添加失败", labelPatients);
        }
    }
}
