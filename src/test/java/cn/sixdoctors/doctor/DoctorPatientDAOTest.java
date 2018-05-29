package cn.sixdoctors.doctor;

import cn.sixdoctors.doctor.dao.DoctorPatientDAO;
import cn.sixdoctors.doctor.model.DoctorPatient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangpengcheng on 2018/5/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorPatientDAOTest {

    @Resource
    private DoctorPatientDAO doctorPatientDAO;

    @Test
    public void insert() {
        DoctorPatient doctorPatient = new DoctorPatient();
        doctorPatient.setDoctorId(1);
        doctorPatient.setPatientId(1);
        doctorPatient.setDoctorName("赵医生");
        doctorPatient.setPatientName("赵病人");
        doctorPatient.setStatus("复诊");
        doctorPatientDAO.insert(doctorPatient);
    }

    @Test
    public void findByDoctorId() {
        System.out.println(doctorPatientDAO.findByDoctorId(2));
    }

    @Test
    public void findByPatientId() {
        System.out.println(doctorPatientDAO.findByPatientId(1));
    }

    @Test
    public void findByPatientName() {
        System.out.println(doctorPatientDAO.findByPatientName("赵病人"));
    }

    @Test
    public void findByDoctorName() {
        System.out.println(doctorPatientDAO.findByDoctorName("赵医生"));
    }

    @Test
    public void update() {
        DoctorPatient doctorPatient = new DoctorPatient();
        doctorPatient.setDoctorId(1);
        doctorPatient.setPatientId(1);
        doctorPatient.setDoctorName("赵医生");
        doctorPatient.setPatientName("赵病人");
        doctorPatient.setStatus("update");
        doctorPatient.setDoctorPatientId(1);
        doctorPatientDAO.update(doctorPatient);
    }
}
