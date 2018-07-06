package cn.sixdoctors.doctor.dao;

import cn.sixdoctors.doctor.model.Label;

import java.util.List;

/**
 * Created by wangpengcheng on 2018/7/5.
 */
public interface LabelDAO {

    int addLabel(Label label);

    int updateLabel(Label label);

    int delLabel(Label label);

    List<Label> findByDoctorId(int doctorId);

}
