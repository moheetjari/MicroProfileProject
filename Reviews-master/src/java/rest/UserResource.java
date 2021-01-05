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
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("user")
@DeclareRoles({"Admin","User"})
public class UserResource {

    @Context
    private UriInfo context;
    
    @EJB clientejbLocal clb;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    /**
     * Retrieves representation of an instance of rest.UserResource
     *
     * @return an instance of java.lang.String
     */
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Users> getAllUser() {
        return clb.getAllUsers();
    }

    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getUserById/{uid}")
    public Users getUserById(@PathParam("uid") int id) {
        return clb.getUserById(id);
    }

    @PermitAll
    @POST
    @Path("adduser/{name}/{phno}/{pass}/{interest}/{gender}/{email}/{city}/{bdate}")
    public void addUser(@PathParam("name") String name,@PathParam("phno") String phno,@PathParam("interest") String interest,@PathParam("gender") String gender,@PathParam("email") String email,@PathParam("city") String city,@PathParam("bdate") String bdate,@PathParam("pass") String pass)
    {
        try {
            Date d1=new SimpleDateFormat("yyyy-MM-dd").parse(bdate);
            clb.addUser(name, email, phno, interest, gender, d1, city, pass);
        } catch (Exception e) {
        }
        
    }
    
    @RolesAllowed({"Admin","User"})
    @POST
    @Path("updateuser/{uid}/{name}/{phno}/{interest}/{gender}/{email}/{city}/{bdate}")
    public void updateUser(@PathParam("uid")int uid,@PathParam("name") String name,@PathParam("phno") String phno,@PathParam("interest") String interest,@PathParam("gender") String gender,@PathParam("email") String email,@PathParam("city") String city,@PathParam("bdate") String bdate)
    {
        try {
            Date d1=new SimpleDateFormat("yyyy-MM-dd").parse(bdate);
            clb.updateUser(uid, name, email, phno, interest, gender, d1, city);
        } catch (Exception e) {
        }
    }
    
    
    @RolesAllowed("Admin")
    @DELETE
    @Path("deleteuser/{uid}")
    public void deleteUser(@PathParam("uid") int uid)
    {
        clb.removeUser(uid);
    }
    
    /**
     * PUT method for updating or creating an instance of UserResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
