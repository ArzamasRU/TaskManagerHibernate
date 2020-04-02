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
 * 2020-04-02T23:31:30.739+03:00
 * Generated source version: 3.3.5
 *
 */
@WebService(targetNamespace = "http://endpoint.tm.lavrov.ru/", name = "UserEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface UserEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.tm.lavrov.ru/UserEndpoint/getUserTasksRequest", output = "http://endpoint.tm.lavrov.ru/UserEndpoint/getUserTasksResponse")
    @RequestWrapper(localName = "getUserTasks", targetNamespace = "http://endpoint.tm.lavrov.ru/", className = "ru.lavrov.tm.endpoint.GetUserTasks")
    @ResponseWrapper(localName = "getUserTasksResponse", targetNamespace = "http://endpoint.tm.lavrov.ru/", className = "ru.lavrov.tm.endpoint.GetUserTasksResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.lavrov.tm.endpoint.Task> getUserTasks(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.lavrov.ru/UserEndpoint/registerUserRequest", output = "http://endpoint.tm.lavrov.ru/UserEndpoint/registerUserResponse")
    @RequestWrapper(localName = "registerUser", targetNamespace = "http://endpoint.tm.lavrov.ru/", className = "ru.lavrov.tm.endpoint.RegisterUser")
    @ResponseWrapper(localName = "registerUserResponse", targetNamespace = "http://endpoint.tm.lavrov.ru/", className = "ru.lavrov.tm.endpoint.RegisterUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean registerUser(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        java.lang.String arg3
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.lavrov.ru/UserEndpoint/deleteUserRequest", output = "http://endpoint.tm.lavrov.ru/UserEndpoint/deleteUserResponse")
    @RequestWrapper(localName = "deleteUser", targetNamespace = "http://endpoint.tm.lavrov.ru/", className = "ru.lavrov.tm.endpoint.DeleteUser")
    @ResponseWrapper(localName = "deleteUserResponse", targetNamespace = "http://endpoint.tm.lavrov.ru/", className = "ru.lavrov.tm.endpoint.DeleteUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean deleteUser(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.lavrov.ru/UserEndpoint/getUserProjectsRequest", output = "http://endpoint.tm.lavrov.ru/UserEndpoint/getUserProjectsResponse")
    @RequestWrapper(localName = "getUserProjects", targetNamespace = "http://endpoint.tm.lavrov.ru/", className = "ru.lavrov.tm.endpoint.GetUserProjects")
    @ResponseWrapper(localName = "getUserProjectsResponse", targetNamespace = "http://endpoint.tm.lavrov.ru/", className = "ru.lavrov.tm.endpoint.GetUserProjectsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.lavrov.tm.endpoint.Project> getUserProjects(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.lavrov.ru/UserEndpoint/getUserRequest", output = "http://endpoint.tm.lavrov.ru/UserEndpoint/getUserResponse")
    @RequestWrapper(localName = "getUser", targetNamespace = "http://endpoint.tm.lavrov.ru/", className = "ru.lavrov.tm.endpoint.GetUser")
    @ResponseWrapper(localName = "getUserResponse", targetNamespace = "http://endpoint.tm.lavrov.ru/", className = "ru.lavrov.tm.endpoint.GetUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.lavrov.tm.endpoint.User getUser(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}
