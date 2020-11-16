package com.china.white_jotter.util;

import java.util.Random;

/**
 * @author majiaju
 * @date
 */
public class StringUtils {

    public static String getRandomString(int length){
        String base = "abcdefghigklmnopqrstuvwxyz1234567890";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
