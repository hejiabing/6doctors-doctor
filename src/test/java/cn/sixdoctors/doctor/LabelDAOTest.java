package cn.sixdoctors.doctor;

import cn.sixdoctors.doctor.dao.DoctorPatientDAO;
import cn.sixdoctors.doctor.dao.LabelDAO;
import cn.sixdoctors.doctor.model.DoctorPatient;
import cn.sixdoctors.doctor.model.Label;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by wangpengcheng on 2018/5/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LabelDAOTest {

    @Resource
    private LabelDAO labelDAO;

    @Test
    public void addLabel() {
        Label label = new Label();
        label.setName("标签三");
        label.setDoctorId(2);
        System.out.println(labelDAO.addLabel(label));
        System.out.println(label);
    }

    @Test
    public void updateLabel() {
        Label label = new Label();
        label.setName("标签三update");
        label.setDoctorId(2);
        label.setLabelId(3);
        System.out.println(labelDAO.updateLabel(label));
    }

    @Test
    public void delLabel() {
        Label label = new Label();
        label.setDoctorId(2);
        label.setLabelId(3);
        System.out.println(labelDAO.delLabel(label));
    }

    @Test
    public void findByDoctorId() {
        System.out.println(labelDAO.findByDoctorId(2));
    }

}
