package cn.sixdoctors.doctor;

import cn.sixdoctors.doctor.dao.TherapyDAO;
import cn.sixdoctors.doctor.model.Therapy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by wangpengcheng on 2018/5/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TherapyDAOTest {

    @Resource
    private TherapyDAO therapyDAO;

    @Test
    public void insert() {
        Therapy therapy = new Therapy();
        therapy.setDoctorId(2);
        therapy.setPatientId(7);
        therapy.setState("复诊");
        therapy.setDate(new Date());
        therapy.setRecord("记录2");
        therapyDAO.insert(therapy);
    }

    @Test
    public void findByDoctorId() {
        System.out.println(therapyDAO.findByDoctorId(1));
    }

    @Test
    public void findById() {
        System.out.println(therapyDAO.findById(1));
    }

    @Test
    public void findByPatientId() {
        System.out.println(therapyDAO.findByPatientId(1));
    }

    @Test
    public void update() {
        Therapy therapy = new Therapy();
        therapy.setDoctorId(1);
        therapy.setPatientId(1);
        therapy.setState("update");
        therapy.setDate(new Date());
        therapy.setRecord("记录");
        therapy.setTherapyId(1);
        therapyDAO.update(therapy);
    }

    @Test
    public void findDTOByPatientId() {
        System.out.println(therapyDAO.findDTOByPatientId(7));
    }

}
