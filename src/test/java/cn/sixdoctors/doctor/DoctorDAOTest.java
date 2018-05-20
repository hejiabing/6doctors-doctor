package cn.sixdoctors.doctor;

import cn.sixdoctors.doctor.dao.DoctorDAO;
import cn.sixdoctors.doctor.model.Doctor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangpengcheng on 2018/5/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorDAOTest {

    @Resource
    private DoctorDAO doctorDAO;


    @Test
    public void insert() {
        Doctor doctor = new Doctor();
        doctor.setDoctorName("王鹏程");
        doctor.setHospitalName("同济医院");
        doctor.setDepartName("骨科");
        doctorDAO.insert(doctor);

    }

    @Test
    public void findByDoctorId() {
        System.out.println(doctorDAO.findByDoctorId(1));

    }

    @Test
    public void findByDoctorName() {
        List<Doctor> doctors = doctorDAO.findByDoctorName("王鹏程");
        System.out.println(doctors);

    }

    @Test
    public void findBySearch() {
        Map<String, String> pa = new HashMap<>();
        pa.put("doctorName","王鹏程");
        pa.put("hospitalName","同济医院");
        List<Doctor> doctors = doctorDAO.findBySearch(pa);
        System.out.println(doctors);

    }

    @Test
    public void update() {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(1);
        doctor.setDoctorName("王鹏程");
        doctor.setHospitalName("同济医院");
        doctor.setDepartName("update");
        doctorDAO.update(doctor);

    }

}
