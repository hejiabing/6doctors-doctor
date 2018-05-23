package cn.sixdoctors.doctor.dao;

import cn.sixdoctors.doctor.model.Doctor;

import java.util.List;
import java.util.Map;

/**
 * Created by wangpengcheng on 2018/5/20.
 */
public interface DoctorDAO {

    int insert(Doctor doctor);

    Doctor findByDoctorId(int doctorId);

    List<Doctor> findByDoctorName(String doctorName);

    List<Doctor> findBySearch(Map<String, String> params);

    int update(Doctor doctor);
}
