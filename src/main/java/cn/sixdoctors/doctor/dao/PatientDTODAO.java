package cn.sixdoctors.doctor.dao;

import cn.sixdoctors.doctor.vo.PatientVO;

import java.util.List;

/**
 * Created by wangpengcheng on 2018/6/1.
 */
public interface PatientDTODAO {

    List<PatientVO> findByDoctorId(int doctorId);

}
