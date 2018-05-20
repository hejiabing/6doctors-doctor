package cn.sixdoctors.doctor.dao;


import cn.sixdoctors.doctor.model.Nurse;

import java.util.List;
import java.util.Map;

/**
 * Created by wangpengcheng on 2018/5/20.
 */
public interface NurseDAO {
    void insert(Nurse nurse);

    Nurse findByDoctorId(int nurseId);

    List<Nurse> findByNurseName(String nurseName);

    List<Nurse> findBySearch(Map<String, String> params);
}
