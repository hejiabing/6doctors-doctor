package cn.sixdoctors.doctor;

import cn.sixdoctors.doctor.dao.NurseDAO;
import cn.sixdoctors.doctor.model.Nurse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by wangpengcheng on 2018/5/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NurseDAOTest {

    @Resource
    private NurseDAO nurseDAO;

    @Test
    public void insert() {
        Nurse nurse = new Nurse();
        nurse.setNurseName("赵护士");
        nurse.setHospitalName("第一医院");
        nurse.setDepartName("第一部门");
        nurseDAO.insert(nurse);
    }

    @Test
    public void findByNurseId() {
        System.out.println(nurseDAO.findByNurseId(1));
    }

    @Test
    public void findByNurseName() {
        System.out.println(nurseDAO.findByNurseName("赵护士"));
    }

    @Test
    public void findBySearch() {

    }

    @Test
    public void update() {
        Nurse nurse = new Nurse();
        nurse.setNurseName("赵护士");
        nurse.setHospitalName("第一医院");
        nurse.setDepartName("update");
        nurse.setNurseId(1);
        nurseDAO.update(nurse);
    }

}
