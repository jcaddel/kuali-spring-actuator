package hello;

import org.kuali.common.core.system.VirtualSystem;
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