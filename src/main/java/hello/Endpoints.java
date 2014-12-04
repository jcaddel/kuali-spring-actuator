package hello;

import static com.google.common.collect.Ordering.from;

import org.springframework.boot.actuate.endpoint.Endpoint;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

public final class Endpoints {

    private Endpoints() {
    }

    private static final Ordering<Endpoint<?>> ORDER_BY_ID = from((e1, e2) -> e1.getId().compareTo(e2.getId()));

    public static ImmutableList<Endpoint<?>> sortedEndpoints(Iterable<Endpoint<?>> endpoints) {
        return ORDER_BY_ID.immutableSortedCopy(endpoints);
    }

}
