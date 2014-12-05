package hello;

import static org.kuali.common.core.net.InetAddress.buildLocalHost;
import static org.kuali.common.util.base.Exceptions.illegalState;

import java.io.IOException;

import org.kuali.common.core.net.InetAddress;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.stereotype.Component;

@Component
public class LocalhostEndpoint extends AbstractEndpoint<InetAddress> {

    public LocalhostEndpoint() {
        super("localhost");
    }

    @Override
    public InetAddress invoke() {
        try {
            return buildLocalHost();
        } catch (IOException e) {
            throw illegalState(e);
        }
    }

}