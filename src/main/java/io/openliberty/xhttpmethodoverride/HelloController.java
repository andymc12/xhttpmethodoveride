package io.openliberty.xhttpmethodoverride;

import static io.openliberty.xhttpmethodoverride.XhttpmethodoverrideRestApplication.X_HTTP_METHOD_OVERRIDE;

import java.net.URI;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

@Path("/hello")
public class HelloController {

    @POST
    public String doSomethingWithXHttpMethodOverrideHeader(@HeaderParam(X_HTTP_METHOD_OVERRIDE) String override) {
        return "Hello " + override;
    }

    @GET
    public String runTest(@QueryParam("headerValue") @DefaultValue("world") String value) {
        OverrideClient client = RestClientBuilder.newBuilder()
                                                 .baseUri(URI.create("http://localhost:9080/xhttpmethodoverride"))
                                                 .build(OverrideClient.class);
        return client.getHelloFromServer(value);
    }
}
