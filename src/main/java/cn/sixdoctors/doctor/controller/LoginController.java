package cn.sixdoctors.doctor.controller;

import cn.sixdoctors.doctor.model.User;
import cn.sixdoctors.doctor.vo.VO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by hejiabing on 2018/5/14.
 */

@RestController
public class LoginController {

    @RequestMapping("/doctor/login")
    public VO validateUser(@RequestBody Map<String, Object> params) {
        String username = params.get("username").toString();
        String password = params.get("password").toString();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        return VO.SUCCESS;
    }

}
