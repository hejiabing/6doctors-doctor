package cn.sixdoctors.doctor;

import cn.sixdoctors.doctor.dao.PatientDTODAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by wangpengcheng on 2018/6/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDTODAOTest {

    @Resource
    private PatientDTODAO patientDTODAO;

    @Test
    public void findByDoctorId() {
        System.out.println(patientDTODAO.findByDoctorId(2));
    }



}
