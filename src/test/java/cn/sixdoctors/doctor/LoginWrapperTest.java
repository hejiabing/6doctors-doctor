package cn.sixdoctors.doctor;

import cn.sixdoctors.doctor.wrapper.LoginWrapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginWrapperTest {

    @Resource
    private LoginWrapper loginWrapper;

    @Test
    public void testLogin() throws Exception {
//        loginWrapper.login("deven", "123456");
    }

}
