package cn.sixdoctors.doctor.wrapper;

import cn.sixdoctors.doctor.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginWrapper {

    @Resource
    private LoginService loginService;

}
