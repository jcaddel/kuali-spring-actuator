package org.kuali.common.devops;

import org.kuali.common.jute.system.VirtualSystem;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.stereotype.Component;

@Component
public class SystemEndpoint extends AbstractEndpoint<VirtualSystem> {

    public SystemEndpoint() {
        super("system");
    }

    @Override
    public VirtualSystem invoke() {
        return VirtualSystem.build();
    }

}