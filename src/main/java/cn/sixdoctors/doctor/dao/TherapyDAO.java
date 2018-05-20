package cn.sixdoctors.doctor.dao;


import cn.sixdoctors.doctor.model.Therapy;

import java.util.List;
import java.util.Map;

/**
 * Created by wangpengcheng on 2018/5/20.
 */
public interface TherapyDAO {
    void insert(Therapy doctor);

    Therapy findByDoctorId(int doctorId);

    Therapy findByPatientId(int PatientId);

    List<Therapy> findByDoctorName(String doctorName);

}
