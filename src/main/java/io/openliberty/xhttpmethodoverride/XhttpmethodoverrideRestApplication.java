package io.openliberty.xhttpmethodoverride;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class XhttpmethodoverrideRestApplication extends Application {
    public static final String X_HTTP_METHOD_OVERRIDE = "X-HTTP-Method-Override";
}
