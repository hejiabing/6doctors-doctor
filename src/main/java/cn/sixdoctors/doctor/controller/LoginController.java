package cn.sixdoctors.doctor.controller;

import cn.sixdoctors.doctor.model.Doctor;
import cn.sixdoctors.doctor.vo.Captcha;
import cn.sixdoctors.doctor.vo.Login;
import cn.sixdoctors.doctor.vo.VO;
import cn.sixdoctors.doctor.wrapper.LoginWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * Created by hejiabing on 2018/5/14.
 */

@RestController
@RequestMapping("/api")
public class LoginController {

    @Resource
    private LoginWrapper loginWrapper;


    @GetMapping("/captcha")
    public VO<Captcha> getCaptcha() throws IOException {
        return loginWrapper.getCaptcha();
    }

    @PostMapping("/login")
    public VO<Login> login(@RequestParam String account, @RequestParam String password) {
        return loginWrapper.login(account, password);
    }

}
