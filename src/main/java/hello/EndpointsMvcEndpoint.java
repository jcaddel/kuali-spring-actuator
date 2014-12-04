package hello;

import static com.google.common.base.Optional.fromNullable;
import static com.google.common.base.Predicates.and;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.transform;
import static hello.Endpoints.sortedEndpoints;
import static org.kuali.common.util.base.Precondition.checkNotNull;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;

@Component
public class EndpointsMvcEndpoint extends EndpointMvcAdapter {

    @Value("${management.context-path:/}")
    private String managementContextPath;
    private final EndpointsEndpoint delegate;
    private final Function<Endpoint<?>, EndpointResource> transformer = (endpoint) -> new EndpointResource(managementContextPath, endpoint);

    @Autowired
    public EndpointsMvcEndpoint(EndpointsEndpoint delegate) {
        super(delegate);
        this.delegate = checkNotNull(delegate, "delegate");
    }

    @RequestMapping(value = "/filter", method = GET)
    @ResponseBody
    public List<EndpointResource> filterEndpoints(@RequestParam(required = false) Boolean enabled, @RequestParam(required = false) Boolean sensitive) {
        Predicate<Endpoint<?>> p1 = endpoint -> matches(fromNullable(enabled), endpoint::isEnabled);
        Predicate<Endpoint<?>> p2 = endpoint -> matches(fromNullable(sensitive), endpoint::isSensitive);
        Predicate<Endpoint<?>> predicate = and(p1, p2);
        Iterable<Endpoint<?>> filtered = filter(delegate.invoke(), predicate);
        List<Endpoint<?>> sorted = sortedEndpoints(filtered);
        List<EndpointResource> transformed = transform(sorted, transformer);
        return ImmutableList.copyOf(transformed);
    }

    /**
     * Return true if optional is absent OR optional is present and supplier.get() equals optional.get()
     */
    private <T> boolean matches(Optional<T> optional, Supplier<T> supplier) {
        return !optional.isPresent() || supplier.get().equals(optional.get());
    }

}