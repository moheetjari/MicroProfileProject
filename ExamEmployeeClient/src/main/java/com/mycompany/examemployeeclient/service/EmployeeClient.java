/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examemployeeclient.service;

import com.mycompany.examemployee.entity.EmployeeTB;
import java.util.Collection;
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
@RegisterRestClient(baseUri = "http://localhost:8080/ExamEmployee/rest/example")
public interface EmployeeClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getemployees/{departmentname}")
    public Collection<EmployeeTB> GetEmployees(@PathParam("departmentname") String departmentName);
}
