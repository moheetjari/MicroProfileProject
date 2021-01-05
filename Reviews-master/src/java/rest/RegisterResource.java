/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.clientejbLocal;
import entity.Users;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author hi
 */
@Path("register")
public class RegisterResource {

    @Context
    private UriInfo context;
    @EJB
    clientejbLocal client;

    /**
     * Creates a new instance of RegisterResource
     */
    public RegisterResource() {
    }

    /**
     * Retrieves representation of an instance of rest.RegisterResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Users> getAllUser() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        return client.getAllUsers();
    }

    @POST
    @Path("RegisterUser/{name}/{phno}/{pass}/{interest}/{gender}/{email}/{city}/{bdate}")
    public void RegisterUser(@PathParam("name") String name, @PathParam("phno") String phno, @PathParam("interest") String interest, @PathParam("gender") String gender, @PathParam("email") String email, @PathParam("city") String city, @PathParam("bdate") String bdate, @PathParam("pass") String pass) {
        try {
            Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(bdate);
            client.addUser(name, email, phno, interest, gender, d1, city, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * PUT method for updating or creating an instance of RegisterResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
