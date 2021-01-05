/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.service;

import com.mycompany.mavenproject1.model.EmployeeModel;
import java.util.Collection;
import java.util.List;
import javax.ws.rs.Path;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 * REST Web Service
 *
 * @author mohit
 */
@Path("employee")
public class EmployeeResource {

    @Inject
    EmployeeModel employeeModel;

    @Inject
    @RestClient
    DepartmentClient departmentClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object[]> getEmployees() {
        Collection<Integer> allids = departmentClient.getDepartment();
        System.out.println("allids = " + allids);
        return employeeModel.getEmployeeTBs(allids);
    }

    @POST
        @Produces(MediaType.APPLICATION_JSON)
        @Path("addemployee/{name}/{departmentid}/{salary}")
    public void AddEmployee(@PathParam("name") String name, @PathParam("departmentid") Integer departmentid, @PathParam("salary") Integer salary) {
        System.out.println("In res=" + name + "" + departmentid + "" + salary);
        employeeModel.AddEmployee(name, departmentid, salary);
    }
}
