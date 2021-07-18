package com.hichat.common.util;

import java.security.MessageDigest;
import java.util.Random;

public class IDUtil {


    public static String genImageName() {


        long millis = System.currentTimeMillis();


        Random random = new Random();
        int end3 = random.nextInt(999);

        String str = millis + String.format("%03d", end3);

        return str;
    }



    public static long genItemId() {

        long millis = System.currentTimeMillis();


        Random random = new Random();
        int end2 = random.nextInt(99);

        String str = millis + String.format("%02d", end2);
        long id = new Long(str);
        return id;
    }



    public static String getRandomString(int length) {

        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }


    public static String getSha1(String str){
        if(str==null||str.length()==0){
            return null;
        }
        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9',
                'a','b','c','d','e','f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j*2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            // TODO: handle exception

            return null;
        }
    }


    public static void main(String[] args) {
        for(int i=0;i< 100;i++)
            System.out.println(genItemId());
    }
}