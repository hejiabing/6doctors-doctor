package cn.sixdoctors.doctor;

import cn.sixdoctors.doctor.dao.TherapyDAO;
import cn.sixdoctors.doctor.model.Therapy;
import cn.sixdoctors.doctor.service.TherapyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TherapyServiceTest {

    @Resource
    private TherapyService therapyService;

    @Test
    public void getTherapies() {
        System.out.println(therapyService.getTherapies(7));
    }
}
