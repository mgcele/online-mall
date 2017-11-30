package com.mgcele.framework.utils;

import java.util.Random;

/**
 * @author mgcele
 */
public class RandomUtil {
    
    /**
     *  生成指定长度的随机字符窜
     */
    public static String getRandomString(int length) { // length表示生成字符串的长度
        String base = "abcdefghjklmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ23456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    
    /**
     * 生成 len 位随机数
     * @param len
     * @return
     */
    public static int randomInt(final int len){
        int min = 1;
        for(int i=1; i<len; i++){
            min = min * 10;
        }
        int max = min*10 -1;
        return randomInt(min,max);
    }
    
    /**
     * 生成指定范围内的int随机数
     * @param min
     * @param max
     * @return
     */
    public static int randomInt(final int min, final int max) {
        Random rand = new Random();
        int tmp = Math.abs(rand.nextInt());
        return tmp % (max - min + 1) + min;
    }
    
}
