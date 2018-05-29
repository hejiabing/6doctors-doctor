package cn.sixdoctors.doctor;


import cn.sixdoctors.doctor.util.CaptchaUtil;
import cn.sixdoctors.doctor.util.FileUtils;
import org.junit.Test;

import java.io.IOException;

public class CaptchaUtilTest {

    @Test
    public void testCaptcha() throws IOException {
//        System.out.println(CaptchaUtil.getCaptcha());
//        String phoneReg = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
//        System.out.println("15171501841".matches(phoneReg));
        System.out.println(FileUtils.getFileName("abc.txt.png"));
        System.out.println(FileUtils.randomName(101, "abc.txt.png"));
    }
}
