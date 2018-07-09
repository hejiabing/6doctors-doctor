package cn.sixdoctors.doctor.service;

import cn.sixdoctors.doctor.dao.LabelDAO;
import cn.sixdoctors.doctor.dao.LabelPatientDAO;
import cn.sixdoctors.doctor.model.Label;
import cn.sixdoctors.doctor.model.LabelPatient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangpengcheng on 2018/7/5.
 */
@Service
public class LabelService {

    @Resource
    private LabelDAO labelDAO;

    @Resource
    private LabelPatientDAO labelPatientDAO;

    public int addLabel(Label label) {
        return labelDAO.addLabel(label);
    }

    public int updateLabel(Label label) {
        return labelDAO.updateLabel(label);
    }

    public void delLabel(Label label) {
        labelDAO.delLabel(label);
    }

    public List<Label> findLabelsByDoctorId(int doctorId) {
        return labelDAO.findByDoctorId(doctorId);
    }


    public int addLabelPatient(List<LabelPatient> labelPatients) {
        return labelPatientDAO.addLabelPatients(labelPatients);
    }

    public void delLabelPatient(int labelId, int patientId) {
        labelPatientDAO.delLabelPatient(labelId, patientId);
    }

    public List<LabelPatient> findLabelPatientsByLabelId(int labelId) {
        return labelPatientDAO.findByLabelId(labelId);
    }

    public List<LabelPatient> findLabelPatientsByPatientId(int patientId) {
        return labelPatientDAO.findByPatientId(patientId);
    }

}
