package org.kuali.common.devops;

import static org.kuali.common.jute.base.Exceptions.illegalState;
import static org.kuali.common.jute.net.InetAddress.buildLocalHost;

import java.io.IOException;

import org.kuali.common.jute.net.InetAddress;
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