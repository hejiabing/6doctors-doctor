package cn.sixdoctors.doctor.dao;


import cn.sixdoctors.doctor.model.Hospital;

import java.util.List;

/**
 * Created by wangpengcheng on 2018/5/20.
 */
public interface HospitalDAO {

    int insert(Hospital hospital);

    int insertAll(List<Hospital> hospitals);

    List<Hospital> selectAll();

}
