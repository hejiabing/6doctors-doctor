package cn.sixdoctors.doctor;

import cn.sixdoctors.doctor.dao.HospitalDAO;
import cn.sixdoctors.doctor.model.Hospital;
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
public class HospitalDAOTest {

    @Resource
    private HospitalDAO hospitalDAO;

    @Test
    public void insert() {
        Hospital hospital = new Hospital();
        hospital.setHospitalName("第一医院");
        hospitalDAO.insert(hospital);
    }

    @Test
    public void insertAll() {
        List<Hospital> hospitals = new ArrayList<>();
        Hospital hospital = new Hospital();
        hospital.setHospitalName("第二医院");
        hospitals.add(hospital);

        Hospital hospital1 = new Hospital();
        hospital1.setHospitalName("第三医院");
        hospitals.add(hospital1);

        hospitalDAO.insertAll(hospitals);
    }

    @Test
    public void selectAll() {
        System.out.println(hospitalDAO.selectAll());

    }
}
