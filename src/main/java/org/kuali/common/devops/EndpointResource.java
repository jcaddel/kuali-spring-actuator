package org.kuali.common.devops;

import static org.kuali.common.util.base.Precondition.checkNotBlank;
import static org.kuali.common.util.base.Precondition.checkNotNull;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentServletMapping;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

public final class EndpointResource extends ResourceSupport {

    private final String contextPath;
    private final Endpoint<?> endpoint;

    public EndpointResource(String contextPath, Endpoint<?> endpoint) {
        this.contextPath = checkNotBlank(contextPath, "contextPath");
        this.endpoint = checkNotNull(endpoint, "endpoint");
        if (endpoint.isEnabled()) {
            UriComponentsBuilder path = fromCurrentServletMapping().path(contextPath).pathSegment(endpoint.getId());
            this.add(new Link(path.build().toUriString(), endpoint.getId()));
        }
    }

    public Endpoint<?> getEndpoint() {
        return endpoint;
    }

    @JsonIgnore
    public String getContextPath() {
        return contextPath;
    }

}