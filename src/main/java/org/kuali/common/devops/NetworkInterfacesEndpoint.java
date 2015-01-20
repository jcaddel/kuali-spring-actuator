package org.kuali.common.devops;

import java.util.List;

import org.kuali.common.jute.net.NetworkInterface;
import org.kuali.common.jute.net.NetworkInterfacesProvider;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableList;

@Component
public class NetworkInterfacesEndpoint extends AbstractEndpoint<List<NetworkInterface>> {

    public NetworkInterfacesEndpoint() {
        super("nics");
    }

    private final ImmutableList<NetworkInterface> nics = ImmutableList.copyOf(new NetworkInterfacesProvider().get());

    @Override
    public List<NetworkInterface> invoke() {
        return nics;
    }

}