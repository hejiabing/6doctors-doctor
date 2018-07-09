package cn.sixdoctors.doctor;

import cn.sixdoctors.doctor.dao.LabelDAO;
import cn.sixdoctors.doctor.dao.LabelPatientDAO;
import cn.sixdoctors.doctor.model.Label;
import cn.sixdoctors.doctor.model.LabelPatient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangpengcheng on 2018/5/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LabelPatientDAOTest {

    @Resource
    private LabelPatientDAO labelPatientDAO;

    @Test
    public void addLabelPatients() {
        LabelPatient labelPatient = new LabelPatient();
        labelPatient.setPatientId(35);
        labelPatient.setLabelId(1);
        LabelPatient labelPatient2 = new LabelPatient();
        labelPatient2.setPatientId(35);
        labelPatient2.setLabelId(2);

        List<LabelPatient> labelPatients = new ArrayList<>();
        labelPatients.add(labelPatient);
        labelPatients.add(labelPatient2);
        System.out.println(labelPatientDAO.addLabelPatients(labelPatients));
        System.out.println(labelPatients);
    }

    @Test
    public void delLabelPatient() {
        System.out.println(labelPatientDAO.delLabelPatient(18,39));
    }

    @Test
    public void findByLabelId() {
        System.out.println(labelPatientDAO.findByLabelId(1));
    }

    @Test
    public void findByPatientId() {
        System.out.println(labelPatientDAO.findByPatientId(35));
    }


}
