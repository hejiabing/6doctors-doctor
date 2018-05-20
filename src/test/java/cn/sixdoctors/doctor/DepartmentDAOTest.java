package cn.sixdoctors.doctor;

import cn.sixdoctors.doctor.dao.DepartmentDAO;
import cn.sixdoctors.doctor.model.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangpengcheng on 2018/5/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentDAOTest {

    @Resource
    private DepartmentDAO departmentDAO;

    @Test
    public void insert() {
        Department department = new Department();
        department.setDepartmentName("眼科");
        departmentDAO.insert(department);

    }

    @Test
    public void insertAll() {
        List<Department> departments = new ArrayList<>();
        Department department = new Department();
        department.setDepartmentName("眼科1");
        departments.add(department);

        Department department1 = new Department();
        department1.setDepartmentName("眼科2");
        departments.add(department1);
        departmentDAO.insertAll(departments);

    }

    @Test
    public void selectAll() {
        List<Department> departments = new ArrayList<>();
        departments = departmentDAO.selectAll();
        System.out.println(departments);

    }

}
