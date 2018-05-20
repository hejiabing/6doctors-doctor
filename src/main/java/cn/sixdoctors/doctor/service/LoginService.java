package cn.sixdoctors.doctor.service;

import cn.sixdoctors.doctor.dao.DoctorDAO;
import cn.sixdoctors.doctor.dao.NurseDAO;
import cn.sixdoctors.doctor.dao.PassportUserDAO;
import cn.sixdoctors.doctor.dao.PatientDAO;
import cn.sixdoctors.doctor.exception.NotFoundException;
import cn.sixdoctors.doctor.exception.UnauthorizedException;
import cn.sixdoctors.doctor.model.PassportUser;
import cn.sixdoctors.doctor.util.CaptchaUtil;
import cn.sixdoctors.doctor.util.TokenUtil;
import cn.sixdoctors.doctor.vo.Login;
import cn.sixdoctors.doctor.vo.VO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

import static cn.sixdoctors.doctor.exception.ExceptionMsg.ACCOUNT_NOT_FOUND;
import static cn.sixdoctors.doctor.exception.ExceptionMsg.PASSWORD_ERROR;
import static cn.sixdoctors.doctor.exception.ExceptionMsg.ROLE_NOT_FOUND;

/**
 * Created by hejiabing on 2018/5/14.
 */

@Service
public class LoginService {

    @Resource
    private PassportUserDAO userDAO;

    @Resource
    private DoctorDAO doctorDAO;

    @Resource
    private NurseDAO nurseDAO;

    @Resource
    private PatientDAO patientDAO;

    public Map<String, String> getCaptcha() throws IOException {
        return CaptchaUtil.getCaptcha();
    }

    public VO<Login> login(String account, String password) {
        String phoneReg = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        PassportUser user;
        if (account.matches(phoneReg)) {
            user = userDAO.findByMobile(account);
        } else {
            user = userDAO.findByUserName(account);
        }

        if (user == null) {
            throw new NotFoundException(ACCOUNT_NOT_FOUND);
        } else if (!user.getPassword().equals(password)){
            throw new UnauthorizedException(PASSWORD_ERROR);
        } else {
            String token = TokenUtil.genToken(String.valueOf(user.getUserId()));
            Login<Object> login = new Login<>();
            login.setToken(token);
            switch (user.getRoleId()) {
                case 101:
                    login.setData(doctorDAO.findByDoctorId(user.getUserDetailId()));
                    break;
                case 201:
                    login.setData(patientDAO.findByPatientId(user.getUserDetailId()));
                    break;
                case 301:
                    login.setData(nurseDAO.findByNurseId(user.getUserDetailId()));
                    break;
                case 501:
                    throw new NotFoundException(ROLE_NOT_FOUND);
                default:
                    throw new NotFoundException(ROLE_NOT_FOUND);
            }
            return new VO<>(login);
        }
    }

}
