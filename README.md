# xhttpmethodoveride
Simple demo showing how you could override the use of the X-HTTP-Method-Override header

To run, clone this repo, and then run `mvn clean install liberty:run-server`.  Next browse to: http://localhost:9080/xhttpmethodoverride/hello?headerValue=bob

This will invoke the MicroProfile Rest Client to invoke a POST method using a custom `X-HTTP-Method-Override` header (bob). 
Normally, this would try to find a JAX-RS resource method that could handle a "bob" HTTP method - and, after not finding a valid
method, would return a 405 to the client.  However, due to the PreMatching container filter, it will change the method back to
POST but leave the header alone to be used in the JAX-RS resource method.

In general, this is not a good practice, but might be a baby step when migrating apps that use `X-HTTP-Method-Override` in a 
non-standard manner from servers that do not support that header to servers that do.
