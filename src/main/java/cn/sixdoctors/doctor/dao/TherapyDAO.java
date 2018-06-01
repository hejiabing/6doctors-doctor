package cn.sixdoctors.doctor.dao;


import cn.sixdoctors.doctor.model.Therapy;
import cn.sixdoctors.doctor.vo.TherapyVO;

import java.util.List;
import java.util.Map;

/**
 * Created by wangpengcheng on 2018/5/20.
 */
public interface TherapyDAO {
    int insert(Therapy therapy);

    List<Therapy> findByDoctorId(int doctorId);

    Therapy findById(int therapyId);

    List<Therapy> findByPatientId(int PatientId);

    List<TherapyVO> findDTOByPatientId(int PatientId);

    int update(Therapy therapy);

}
