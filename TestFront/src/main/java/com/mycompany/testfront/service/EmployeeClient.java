/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testfront.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author mohit
 */
@RegisterRestClient(configKey = "employeeClient", baseUri = "http://localhost:8080/TestEmployee/rest")
@ApplicationScoped
@Path("employee")
public interface EmployeeClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Object[]> getEmployees();

    @POST
    @Path("addemployee/{name}/{departmentid}/{salary}")
    void AddEmployee(@PathParam("name") String name, @PathParam("departmentid") Integer departmentid, @PathParam("salary") Integer salary);
}
