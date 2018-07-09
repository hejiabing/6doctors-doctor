package cn.sixdoctors.doctor.dao;

import cn.sixdoctors.doctor.model.LabelPatient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangpengcheng on 2018/7/5.
 */
public interface LabelPatientDAO {

    int addLabelPatients(List<LabelPatient> labelPatients);

    int delLabelPatient(@Param("labelId") int labelId, @Param("patientId") int patientId);

    List<LabelPatient> findByLabelId(int labelId);

    List<LabelPatient> findByPatientId(int patientId);

}
