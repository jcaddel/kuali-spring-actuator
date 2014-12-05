package org.kuali.common.devops;

import static org.kuali.common.core.net.NetworkInterface.getCachedNetworkInterfaces;
import static org.kuali.common.util.base.Exceptions.illegalState;

import java.io.IOException;
import java.util.List;

import org.kuali.common.core.net.NetworkInterface;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.stereotype.Component;

@Component
public class NetworkInterfacesEndpoint extends AbstractEndpoint<List<NetworkInterface>> {

    public NetworkInterfacesEndpoint() {
        super("nics");
    }

    @Override
    public List<NetworkInterface> invoke() {
        try {
            return getCachedNetworkInterfaces();
        } catch (IOException e) {
            throw illegalState(e);
        }
    }

}