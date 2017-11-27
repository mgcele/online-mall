package com.online.mall.exception.base;

import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;

/**
 * @author mgcele
 * @since 1.0.0 SimpleSerialIdGenerator
 */
public class ExceptionTraceIdGenerator {
    
    private static ExceptionTraceIdGenerator exceptionTraceIdGenerator;
    
    private static final int ROLL_SEED = 0xFFF;
    private SimpleSerialIdGenerator simpleSerialIdGenerator = new SimpleSerialIdGenerator(ROLL_SEED);
    
    public String getTraceId(){
        StringBuilder sb = new StringBuilder();
        String systemName = SystemProperty.getInstance().getSystemName();
        String machineId = SystemProperty.getInstance().getMachineId();
        sb.append(systemName == null ? ConfigConstant.UNKONWN_DEFAULE : systemName);
        sb.append("-");
        sb.append(machineId == null ? ConfigConstant.UNKONWN_DEFAULE :machineId);
        synchronized(this){
            Calendar current = Calendar.getInstance();
            int currentDate = current.get(6);
            int currentHour = current.get(11);
            int currentHourLength = 5;
            int currentMinute = current.get(12);
            int currentMinuteLength = 6;
            currentDate <<= currentHourLength + currentMinuteLength;
            currentHour <<= currentMinuteLength;
            int currentStamp = currentDate + currentHour + currentMinute;
            String currentStampHEX = Integer.toHexString(currentStamp);
            currentStampHEX = StringUtils.leftPad(currentStampHEX, 5, "0");
            int result = simpleSerialIdGenerator.generate().intValue();
            String strSerial = Integer.toHexString(result);
            strSerial = StringUtils.leftPad(strSerial, 3, "0");
            sb.append(currentStampHEX);
            sb.append("-");
            sb.append(strSerial);
        }
        return sb.toString().toUpperCase();
    }
    
    public static ExceptionTraceIdGenerator getInstance(){
        if (exceptionTraceIdGenerator == null) {
            synchronized(ExceptionTraceIdGenerator.class) {
                if (exceptionTraceIdGenerator  == null) {
                    exceptionTraceIdGenerator = new ExceptionTraceIdGenerator();
                }
            }
        }
        return exceptionTraceIdGenerator;
    }
    
    private ExceptionTraceIdGenerator(){
    
    }
    
}
