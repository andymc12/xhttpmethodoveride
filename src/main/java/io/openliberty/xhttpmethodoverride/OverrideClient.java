package io.openliberty.xhttpmethodoverride;

import static io.openliberty.xhttpmethodoverride.XhttpmethodoverrideRestApplication.X_HTTP_METHOD_OVERRIDE;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/hello")
public interface OverrideClient {

    @POST
    String getHelloFromServer(@HeaderParam(X_HTTP_METHOD_OVERRIDE) String override);
}