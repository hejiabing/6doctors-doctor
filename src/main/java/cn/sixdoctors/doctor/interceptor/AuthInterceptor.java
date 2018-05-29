package cn.sixdoctors.doctor.interceptor;

import cn.sixdoctors.doctor.dao.PassportUserDAO;
import cn.sixdoctors.doctor.model.PassportUser;
import cn.sixdoctors.doctor.util.GsonUtils;
import cn.sixdoctors.doctor.util.JedisUtils;
import cn.sixdoctors.doctor.vo.VO;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private PassportUserDAO userDAO;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String path = request.getServletPath();

        if (path.startsWith("captcha", 5)) {
            return true;
        }
        if (path.startsWith("login", 5)) {
            return true;
        }

        String token = request.getParameter("token");
        System.out.println(path + "-:-" + token);
        String uidStr = JedisUtils.get(token);

        if (token == null || uidStr == null) {
            response.getWriter().print(GsonUtils.toJson(VO.INVALID_TOKEN));
            return false;
        }

        int uid = Integer.valueOf(uidStr);

        PassportUser user = userDAO.findByUserId(uid);

        if (user != null) {
            request.setAttribute("user", user);
        }

        return true;
    }
}
