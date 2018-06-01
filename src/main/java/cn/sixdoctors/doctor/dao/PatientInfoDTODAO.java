package cn.sixdoctors.doctor.dao;

import cn.sixdoctors.doctor.vo.PatientInfoVO;

import java.util.List;

/**
 * Created by wangpengcheng on 2018/6/1.
 */
public interface PatientInfoDTODAO {

    PatientInfoVO findByPatientId(int patientId);

}
