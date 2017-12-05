package com.online.mall;

import com.mgcele.framework.identifier.NetAddressIdWorker;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.annotation.Resource;

/**
 * @author mgcele
 * @since 1.0.0
 */
@Component
public class SaveEventListener extends AbstractMongoEventListener<Object>{
    
    @Resource(name = "netAddressIdWorker")
    private NetAddressIdWorker netAddressIdWorker;
    
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        super.onBeforeConvert(event);
        if (event != null) {
            ReflectionUtils.doWithFields(event.getSource().getClass(), field -> {
                ReflectionUtils.makeAccessible(field);
                if (field.isAnnotationPresent(Id.class)) {
                    field.set(event.getSource(), netAddressIdWorker.generate());
                }
            });
        }
    }
}

