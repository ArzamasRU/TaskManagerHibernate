package ru.lavrov.tm.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.5
 * 2020-04-06T17:00:09.363+03:00
 * Generated source version: 3.3.5
 *
 */
@WebServiceClient(name = "TokenEndpointService",
                  wsdlLocation = "http://localhost:8090/TokenEndpoint?wsdl",
                  targetNamespace = "http://endpoint.tm.lavrov.ru/")
public class TokenEndpointService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.tm.lavrov.ru/", "TokenEndpointService");
    public final static QName TokenEndpointPort = new QName("http://endpoint.tm.lavrov.ru/", "TokenEndpointPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8090/TokenEndpoint?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(TokenEndpointService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8090/TokenEndpoint?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public TokenEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TokenEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TokenEndpointService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public TokenEndpointService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public TokenEndpointService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public TokenEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns TokenEndpoint
     */
    @WebEndpoint(name = "TokenEndpointPort")
    public TokenEndpoint getTokenEndpointPort() {
        return super.getPort(TokenEndpointPort, TokenEndpoint.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TokenEndpoint
     */
    @WebEndpoint(name = "TokenEndpointPort")
    public TokenEndpoint getTokenEndpointPort(WebServiceFeature... features) {
        return super.getPort(TokenEndpointPort, TokenEndpoint.class, features);
    }

}
