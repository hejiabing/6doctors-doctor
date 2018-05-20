package cn.sixdoctors.doctor.dao;


import cn.sixdoctors.doctor.model.Patient;

import java.util.List;
import java.util.Map;

/**
 * Created by wangpengcheng on 2018/5/20.
 */
public interface PatientDAO {

    void insert(Patient patient);

    Patient findByPatientId(int patientId);

    List<Patient> findByPatientName(String patientName);

    Patient findByMobPhone(String mobPhone);

    void update(Patient patient);

}
