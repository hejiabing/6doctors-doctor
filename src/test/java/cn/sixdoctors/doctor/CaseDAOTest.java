package cn.sixdoctors.doctor;

import cn.sixdoctors.doctor.dao.CaseDAO;
import cn.sixdoctors.doctor.model.Case;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangpengcheng on 2018/5/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CaseDAOTest {

    @Resource
    private CaseDAO caseDAO;

    @Test
    public void insertAll() {
        List<Case> cases = new ArrayList<>();
        Case ca = new Case();
        ca.setTherapyId(123456);
        ca.setCasePath("/home/deven/index.img");
        cases.add(ca);
        Case ca1 = new Case();
        ca1.setTherapyId(123456);
        ca1.setCasePath("/home/deven/index2.img");
        cases.add(ca1);
        caseDAO.insertAll(cases);
    }

    @Test
    public void insert() {
        Case ca = new Case();
        ca.setTherapyId(123456);
        ca.setCasePath("/home/deven/index.img");
        caseDAO.insert(ca);
    }

    @Test
    public void selectByTherapyId() {
        List<Case> cases = caseDAO.selectByTherapyId(123456);
        System.out.println(cases);
    }
}
