package cn.sixdoctors.doctor.dao;

import cn.sixdoctors.doctor.model.Department;

import java.util.List;

/**
 * Created by wangpengcheng on 2018/5/20.
 */
public interface DepartmentDAO {
    void insert(Department department);

    void insertAll(List<Department> departments);

    List<Department> selectAll();
}
