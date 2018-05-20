package cn.sixdoctors.doctor.exception;

import cn.sixdoctors.doctor.vo.VO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void unauthorized(UnauthorizedException e, HttpServletResponse response) {
        tryCatch(VO.INVALID_PARAMS, response);
    }

    private void tryCatch(VO result, HttpServletResponse response) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(result));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
