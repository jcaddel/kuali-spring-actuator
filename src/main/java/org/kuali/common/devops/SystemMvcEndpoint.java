package org.kuali.common.devops;

import static org.kuali.common.util.base.Precondition.checkNotNull;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Properties;

import org.kuali.common.core.system.Java;
import org.kuali.common.core.system.OperatingSystem;
import org.kuali.common.core.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@ResponseBody
public class SystemMvcEndpoint extends EndpointMvcAdapter {

    private final SystemEndpoint delegate;

    @Autowired
    public SystemMvcEndpoint(SystemEndpoint delegate) {
        super(delegate);
        this.delegate = checkNotNull(delegate, "delegate");
    }

    @RequestMapping(value = "/java", method = GET)
    public Java java() {
        return delegate.invoke().getJava();
    }

    @RequestMapping(value = "/os", method = GET)
    public OperatingSystem operatingSystem() {
        return delegate.invoke().getOs();
    }

    @RequestMapping(value = "/user", method = GET)
    public User systemUser() {
        return delegate.invoke().getUser();
    }

    @RequestMapping(value = "/environment", method = GET)
    public Properties systemEnvironment() {
        return delegate.invoke().getEnvironment();
    }

    @RequestMapping(value = "/properties", method = GET)
    public Properties systemProperties() {
        return delegate.invoke().getProperties();
    }

}