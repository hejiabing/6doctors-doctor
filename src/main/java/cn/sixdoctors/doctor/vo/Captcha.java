package cn.sixdoctors.doctor.vo;

public class Captcha {

    private String captcha;

    private String base64;

    public Captcha(String captcha, String base64) {
        this.captcha = captcha;
        this.base64 = base64;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
