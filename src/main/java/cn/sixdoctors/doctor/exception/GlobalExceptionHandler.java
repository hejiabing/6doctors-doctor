package cn.sixdoctors.doctor.exception;

import cn.sixdoctors.doctor.vo.VO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void unauthorized(UnauthorizedException e, HttpServletResponse response) {
        tryCatch(VO.PASSWORD_ERROR, response);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void notFound(NotFoundException e, HttpServletResponse response) {
        tryCatch(VO.ACCOUNT_NOT_FOUND, response);
    }

    @ExceptionHandler(ParseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void badRequest(ParseException e, HttpServletResponse response) {
        tryCatch(VO.TIME_FORMAT_ERROR, response);
    }

    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void badRequest(IOException e, HttpServletResponse response) {
        tryCatch(VO.IMAGE_WRITE_ERROR, response);
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
