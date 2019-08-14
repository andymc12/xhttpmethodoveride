package io.openliberty.xhttpmethodoverride;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

@PreMatching
@Provider
public class MyPreMatchContainerFilter implements ContainerRequestFilter {

    private final static List<String> ALLOWED_HTTP_METHODS = Arrays.asList("GET", "POST", "PUT", "DELETE"); //...
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if (!ALLOWED_HTTP_METHODS.contains(requestContext.getMethod())) {
            requestContext.setMethod("POST");
        }
        
    }

}