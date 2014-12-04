package hello;

import static hello.Endpoints.sortedEndpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableList;

@Component
public final class EndpointsEndpoint extends AbstractEndpoint<List<Endpoint<?>>> {

    private final ImmutableList<Endpoint<?>> endpoints;

    @Autowired
    public EndpointsEndpoint(List<Endpoint<?>> endpoints) {
        super("endpoints");
        this.endpoints = sortedEndpoints(endpoints);
    }

    @Override
    public List<Endpoint<?>> invoke() {
        return endpoints;
    }
}