package cn.sixdoctors.doctor.dao;

import cn.sixdoctors.doctor.model.LabelPatient;

import java.util.List;

/**
 * Created by wangpengcheng on 2018/7/5.
 */
public interface LabelPatientDAO {

    int addLabelPatients(List<LabelPatient> labelPatients);

    int delLabelPatient(int id);

    List<LabelPatient> findByLabelId(int labelId);

    List<LabelPatient> findByPatientId(int patientId);

}
