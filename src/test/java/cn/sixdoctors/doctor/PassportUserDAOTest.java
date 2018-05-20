package cn.sixdoctors.doctor;

import cn.sixdoctors.doctor.dao.PassportUserDAO;
import cn.sixdoctors.doctor.model.PassportUser;
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
public class PassportUserDAOTest {

    @Resource
    private PassportUserDAO userDAO;

    @Test
    public void insert() {
        PassportUser user = new PassportUser();
        user.setUserName("deven");
        user.setRoleId(101);
        user.setUserDetailId(1);
        userDAO.insert(user);
    }

    @Test
    public void findByUserId() {
        System.out.println(userDAO.findByUserId(1));
    }

    @Test
    public void findByUserName() {
        System.out.println(userDAO.findByUserName("deven"));
    }

    @Test
    public void findByMobile() {
        System.out.println(userDAO.findByMobile("155000000"));
    }

    @Test
    public void update() {
        PassportUser user = new PassportUser();
        user.setUserName("deven");
        user.setMobile("update");
        user.setUserId(1);
        userDAO.update(user);
    }
}
