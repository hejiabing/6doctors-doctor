package cn.sixdoctors.doctor;

import cn.sixdoctors.doctor.dao.PatientDAO;
import cn.sixdoctors.doctor.model.Patient;
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
public class PatientDAOTest {

    @Resource
    private PatientDAO patientDAO;

    @Test
    public void insert() {
        Patient patient = new Patient();
        patient.setPatientName("赵病人");
        patient.setAddress("地址");
        patient.setAge(18);
        patient.setGender("男");
        patient.setIdentityNum("420684100000000000");
        patient.setIdentityType("身份证");
        patient.setMobPhone("15500000000");
        patient.setPhotoPath("/usr/local/");
        patient.setPlace("地点");

        patientDAO.insert(patient);
    }

    @Test
    public void findByPatientId() {
        System.out.println(patientDAO.findByPatientId(1));
    }

    @Test
    public void findByPatientName() {
        System.out.println(patientDAO.findByPatientName("赵病人"));
    }

    @Test
    public void findByMobPhone() {
        System.out.println(patientDAO.findByMobPhone("15500000000"));
    }


}
