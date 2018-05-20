package cn.sixdoctors.doctor.dao;

import cn.sixdoctors.doctor.model.Case;

import java.util.List;
import java.util.Map;

/**
 * Created by wangpengcheng on 2018/5/20.
 */
public interface CaseDAO {
    int insert(Case ca);

    int insertAll(List<Case> cases);

    List<Case> selectByTherapyId(int therapyId);
}
