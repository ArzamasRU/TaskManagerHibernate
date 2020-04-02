package ru.lavrov.tm.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.5
 * 2020-04-02T23:31:30.031+03:00
 * Generated source version: 3.3.5
 *
 */
@WebService(targetNamespace = "http://endpoint.tm.lavrov.ru/", name = "TokenEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface TokenEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.tm.lavrov.ru/TokenEndpoint/loginRequest", output = "http://endpoint.tm.lavrov.ru/TokenEndpoint/loginResponse")
    @RequestWrapper(localName = "login", targetNamespace = "http://endpoint.tm.lavrov.ru/", className = "ru.lavrov.tm.endpoint.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://endpoint.tm.lavrov.ru/", className = "ru.lavrov.tm.endpoint.LoginResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String login(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );
}