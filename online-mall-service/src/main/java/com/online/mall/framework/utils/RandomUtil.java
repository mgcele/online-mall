package com.online.mall.framework.utils;

import java.util.Random;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class RandomUtil {
    
    /**
     * 生成 len 位随机数
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
     */
    public static int randomInt(final int min, final int max) {
        Random rand = new Random();
        int tmp = Math.abs(rand.nextInt());
        return tmp % (max - min + 1) + min;
    }
    
    private RandomUtil(){
    
    }
    
}
