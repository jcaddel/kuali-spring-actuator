package org.kuali.common.devops;

import org.kuali.common.core.system.VirtualRuntime;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.stereotype.Component;

@Component
public class RuntimeEndpoint extends AbstractEndpoint<VirtualRuntime> {

    public RuntimeEndpoint() {
        super("runtime");
    }

    @Override
    public VirtualRuntime invoke() {
        return VirtualRuntime.build();
    }

}