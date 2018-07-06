package cn.sixdoctors.doctor.dao;

import cn.sixdoctors.doctor.vo.PatientVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangpengcheng on 2018/6/1.
 */
public interface PatientDTODAO {

    List<PatientVO> findByDoctorId(int doctorId);

    List<PatientVO> findAll();

    List<PatientVO> findAllByLabelId(int labelId);

    List<PatientVO> findByLabelId(@Param("labelId") int labelId, @Param("doctorId") int doctorId);
}
