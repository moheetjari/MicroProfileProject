/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.service;

import java.util.Collection;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author mohit
 */
@RegisterRestClient(configKey = "departmentClient", baseUri = "http://localhost:8080/TestDepartment/rest")
@ApplicationScoped
@Path("/department")
public interface DepartmentClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Integer> getDepartment();
}
