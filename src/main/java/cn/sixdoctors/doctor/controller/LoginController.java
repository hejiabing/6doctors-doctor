package cn.sixdoctors.doctor.controller;


import cn.sixdoctors.doctor.model.Constants;
import cn.sixdoctors.doctor.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hejiabing on 2018/5/14.
 */

@Controller
public class LoginController {

    @RequestMapping("/doctor/login")
    @ResponseBody
    public String validateUser(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        return Constants.SUCCESS;
    }

}
