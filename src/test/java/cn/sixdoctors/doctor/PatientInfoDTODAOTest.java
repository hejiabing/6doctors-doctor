package cn.sixdoctors.doctor;

import cn.sixdoctors.doctor.dao.PatientInfoDTODAO;
import cn.sixdoctors.doctor.service.PatientService;
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
public class PatientInfoDTODAOTest {

    @Resource
    private PatientInfoDTODAO patientInfoDTODAO;

    @Resource
    private PatientService service;

    @Test
    public void findByPatientId() {
        System.out.println(patientInfoDTODAO.findByPatientId(35));
    }

    @Test
    public void getPatientInfo() {
        System.out.println(service.getPatientInfo(7));
    }



}
