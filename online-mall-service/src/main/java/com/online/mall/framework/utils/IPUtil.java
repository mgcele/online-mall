package com.online.mall.framework.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class IPUtil {
    
    /**
     * 获取本机IP
     */
    public static String getLocalIP() throws SocketException {
        String localIP = null;
        String netIP = null;
        Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
        InetAddress ip = null;
        boolean findIP = false;//是否找到外网IP
        while (networkInterfaceEnumeration.hasMoreElements() && !findIP) {
            NetworkInterface ni = networkInterfaceEnumeration.nextElement();
            Enumeration<InetAddress> address = ni.getInetAddresses();
            while (address.hasMoreElements()) {
                ip = address.nextElement();
                if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && !ip.getHostAddress().contains(":")) {// 外网IP
                    netIP = ip.getHostAddress();
                    findIP = true;
                    break;
                } else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && !ip.getHostAddress().contains(":")) {// 内网IP
                    localIP = ip.getHostAddress();
                }
            }
        }
    
        //若没配置外网IP，则返回本地IP
        if (netIP != null && !"".equals(netIP)) {
            return netIP;
        } else {
            return localIP;
        }
    }
    
    private IPUtil(){
    
    }
    
}
