package com.mgcele.framework.identifier;

import com.mgcele.framework.utils.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基于IP地址的ID生成器工作类，调用SnowflakeIDGenerater生成各类业务ID
 *
 * @author mgcele
 * @since 1.0.0
 */
public class NetAddressIdWorker implements IdentifierGenerator<Long>, IdentifierAnalyzer<Long, SnowflakeIDElement> {
    
    private Logger logger = LoggerFactory.getLogger(NetAddressIdWorker.class);
    
    private long workerId = 0;
    
    private SnowflakeIDGenerator idGen = null;
    
    public NetAddressIdWorker() {
        try {
            String ip = IPUtil.getLocalIP();
            logger.info("IP Address:" + ip);
            String last = ip.substring(ip.lastIndexOf('.') + 1);
            workerId = Long.parseLong(last);
        } catch (Exception e) {
            logger.error("Error Initializing ID Generator : " + e.getMessage(), e);
            System.exit(-1);
        }
        idGen = new SnowflakeIDGenerator(workerId);
    }
    
    @Override
    public Long generate() {
        return idGen.generate();
    }
    
    @Override
    public SnowflakeIDElement analyze(Long id) {
        return idGen.analyze(id);
    }
    
}
