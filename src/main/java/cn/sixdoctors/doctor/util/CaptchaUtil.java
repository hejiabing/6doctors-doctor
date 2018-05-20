package cn.sixdoctors.doctor.util;

import io.netty.handler.codec.base64.Base64Encoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CaptchaUtil {

    private static Random random = new Random();

    //验证码宽度
    private static int width = 95;
    //验证码高度
    private static int height = 25;
    //验证码干扰线数量
    private static int line = 10;
    //验证码字符个数
    private static int charNum = 4;
    //随机字符集
    private static String baseChar = "QWERTYUIOPLKJHGFDSAZXCVBNM123456789";

    public static Map<String, String> getCaptcha() throws IOException {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.createGraphics();
        graphics.fillRect(0, 0, width, height);
        graphics.setFont(new Font("Arial", Font.BOLD, 18));
        graphics.setColor(new Color(138, 43, 226));
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < charNum; i++) {
            int index = random.nextInt(baseChar.length());
            String s = String.valueOf(baseChar.charAt(index));
            int y = 15 + random.nextInt(10);
            graphics.drawString(s, 5 + i * width / 4, y);
            captcha.append(s);
        }
        for (int i = 0; i < line; i++) {
            Color c = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
            graphics.setColor(c);
            graphics.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
        }
        graphics.dispose();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", outputStream);
        BASE64Encoder encoder = new BASE64Encoder ();
        String base64Image =  "data:image/jpg;base64," + encoder.encode(outputStream.toByteArray());
        Map<String, String> results = new HashMap<>();
        results.put("captcha", captcha.toString());
        results.put("base64", base64Image);
        return results;
    }


}
