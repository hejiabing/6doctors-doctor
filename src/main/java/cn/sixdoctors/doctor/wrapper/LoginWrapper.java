package cn.sixdoctors.doctor.wrapper;

import cn.sixdoctors.doctor.exception.UnauthorizedException;
import cn.sixdoctors.doctor.service.LoginService;
import cn.sixdoctors.doctor.vo.Captcha;
import cn.sixdoctors.doctor.vo.Login;
import cn.sixdoctors.doctor.vo.VO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

import static cn.sixdoctors.doctor.exception.ExceptionMsg.PASSWORD_ERROR;

@Service
public class LoginWrapper {

    @Resource
    private LoginService loginService;

    public VO<Captcha> getCaptcha() throws IOException {
        Map<String, String> captchaParams = loginService.getCaptcha();
        String code = captchaParams.get("captcha");
        String base64 = captchaParams.get("base64");
        Captcha captcha = new Captcha(code, base64);
        return new VO<>(captcha);
    }

    public VO<Login> login(String account, String password) {
        if (account == null || password == null) {
            throw new UnauthorizedException(PASSWORD_ERROR);
        } else {
            return loginService.login(account, password);
        }
    }

}
