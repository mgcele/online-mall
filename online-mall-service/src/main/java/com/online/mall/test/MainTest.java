package com.online.mall.test;

import com.mgcele.framework.exception.model.ConfigConstant;
import com.mgcele.framework.identifier.SimpleSerialIdGenerator;
import com.mgcele.framework.system.SystemProperty;
import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class MainTest {
    
    public static void main(String[] args) {
        SimpleSerialIdGenerator simpleSerialIdGenerator = new SimpleSerialIdGenerator(0xFFF);
        StringBuilder sb = new StringBuilder();
        String systemName = SystemProperty.getInstance().getSystemName();
        String machineId = SystemProperty.getInstance().getMachineId();
        sb.append(systemName == null ? ConfigConstant.UNKONWN_DEFAULE : systemName);
        sb.append("-");
        sb.append(machineId == null ? ConfigConstant.UNKONWN_DEFAULE : systemName);
        System.out.println(sb);
        
        Calendar current = Calendar.getInstance();
        int currentDate = current.get(6);
        System.out.println(currentDate);
        
        int currentHour = current.get(11);
        System.out.println(currentHour);
        
        int currentHourLength = 5;
        int currentMinute = current.get(12);
        System.out.println(currentMinute);
        
        int currentMinuteLength = 6;
        currentDate <<= currentHourLength + currentMinuteLength;
        System.out.println(currentDate);
        
        currentHour <<= currentMinuteLength;
        System.out.println(currentHour);
        
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
    
}
