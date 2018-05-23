package cn.sixdoctors.doctor.dao;

import cn.sixdoctors.doctor.model.DoctorPatient;

import java.util.List;

/**
 * Created by wangpengcheng on 2018/5/20.
 */
public interface DoctorPatientDAO {

    int insert(DoctorPatient doctorPatient);

    List<DoctorPatient> findByDoctorId(int doctorId);

    List<DoctorPatient> findByPatientId(int patientId);

    List<DoctorPatient> findByPatientName(String patientName);

    List<DoctorPatient> findByDoctorName(String doctorName);

    int update(DoctorPatient doctorPatient);

}
