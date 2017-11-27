package com.online.mall.framework.exception.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Properties;

/**
 * @author mgcele
 * @since 1.0.0
 */
public final class SystemProperty {
    
    private static Logger logger = LoggerFactory.getLogger(SystemProperty.class);
    private static SystemProperty instance;
    private Properties systemProperties;
    private String hostName;
    private static String SYSTEM_PROPERTIES = "system.properties";
    private static String KEY_SYSTEM_NAME = "systemname";
    private static String KEY_HOSTNAME = "myhost";
    private static String MACHINE_ID;
    
    public String getMachineId(){
        if (MACHINE_ID == null) {
            MACHINE_ID = getInnerSystemProperty(KEY_HOSTNAME);
            if (MACHINE_ID == null) {
                if (hostName == null) {
                    hostName = getHostNmae();
                }
                if (hostName != null) {
                    try {
                        MACHINE_ID = hostName.substring(this.hostName.length() < 2 ? 0 : hostName.length() - 2);
                    } catch (Exception e) {
                        logger.error("get machine id failed", e);
                    }
                }
            }
        }
        return MACHINE_ID;
    }
    
    public String getSystemName(){
        return getSystemProperty(KEY_SYSTEM_NAME);
    }
    
    public String getSystemProperty(String key){
        if(systemProperties == null) {
            return getInnerSystemProperty(key);
        } else {
            return systemProperties.getProperty(key) == null ? getInnerSystemProperty(key) :systemProperties.getProperty(key);
        }
    }
    
    private String getInnerSystemProperty(String key){
        return System.getProperty(key);
    }

    public static SystemProperty getInstance(){
        if(instance == null) {
            synchronized(SystemProperty.class) {
                if (instance == null) {
                    instance = new SystemProperty();
                }
            }
        }
        return instance;
    }
    
    private SystemProperty(){
        init(SYSTEM_PROPERTIES);
    }
    
    private void init(String propertyFile){
        hostName = getHostNmae();
        if (systemProperties == null) {
            URL url = getClassLoader().getResource(propertyFile);
            if (url == null) {
                logger.debug("try to load system-properties from file:{}, but not existed", SYSTEM_PROPERTIES);
                return;
            }
            logger.debug("try to load system-properties from file:{}", SYSTEM_PROPERTIES);
            InputStream is = null;
            try{
                is = url.openStream();
                systemProperties = new Properties();
                systemProperties.load(is);
            } catch (Exception e) {
                logger.error("load system-properties from file:{} failed,the url is:{}", SYSTEM_PROPERTIES, url.toExternalForm(), e);
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        logger.error("关闭流失败", e);
                    }
                }
            }
        }
    }
    
    private String getHostNmae(){
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            logger.error("get machine id failed", e);
            return null;
        }
    }
    
    private ClassLoader getClassLoader() {
        try{
            return Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {
            return ResourceUtils.class.getClassLoader();
        }
    }

}
