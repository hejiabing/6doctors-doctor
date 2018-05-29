package cn.sixdoctors.doctor.util;

import java.io.*;

public class FileUtils {

    public static void uploadFile(byte[] file, String filePath, String fileName) throws IOException {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    public static String randomName(int uid, String originName) {
        String lx = originName.substring(originName.lastIndexOf("."));
        long time = System.currentTimeMillis();
        return uid + time + lx;
    }

    public static String getFileName(String originName) {
        return originName.substring(0, originName.lastIndexOf("."));
    }
}

