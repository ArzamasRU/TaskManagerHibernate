package ru.lavrov.tm.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2020-03-20T15:00:29.198+03:00
 * Generated source version: 3.2.7
 *
 */
@WebServiceClient(name = "TestEndpointService",
                  wsdlLocation = "http://localhost:8090/TestEndpoint?wsdl",
                  targetNamespace = "http://endpoint.tm.lavrov.ru/")
public class TestEndpointService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.tm.lavrov.ru/", "TestEndpointService");
    public final static QName TestEndpointPort = new QName("http://endpoint.tm.lavrov.ru/", "TestEndpointPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8090/TestEndpoint?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(TestEndpointService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8090/TestEndpoint?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public TestEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TestEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TestEndpointService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public TestEndpointService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public TestEndpointService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public TestEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns TestEndpoint
     */
    @WebEndpoint(name = "TestEndpointPort")
    public TestEndpoint getTestEndpointPort() {
        return super.getPort(TestEndpointPort, TestEndpoint.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TestEndpoint
     */
    @WebEndpoint(name = "TestEndpointPort")
    public TestEndpoint getTestEndpointPort(WebServiceFeature... features) {
        return super.getPort(TestEndpointPort, TestEndpoint.class, features);
    }

}