/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.adminejbLocal;
import entity.Userrole;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
@Path("generic")
public class UserroleResource {

    @EJB adminejbLocal admin ;
    
    @Context
    private UriInfo context;
    
    
    /**
     * Creates a new instance of GenericResource
     */
    public UserroleResource() {
    }

    /**
     * Retrieves representation of an instance of rest.GenericResource
     * @return an instance of java.lang.String
     */
    @RolesAllowed("Admin")
    @GET
    @Path("getAllUserrole")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Userrole> getAllUserrole() {
        //TODO return proper representation object
        return admin.getAllUserRole();
    }

    @RolesAllowed("Admin")
    @GET
    @Path("getUserroleById/{id}")
    public Userrole getUserroleById(@PathParam("id") int id) 
    {
        return admin.getUserRoleById(id);
    }
    
    @RolesAllowed("Admin")
    @POST
    @Path("addUserRole/{uid}/{rid}")
    public void addUserRole(@PathParam("uid") int uid,@PathParam("rid") int rid)
    {
        admin.addUserRole(uid, rid);
    }
    
    @RolesAllowed("Admin")
    @POST
    @Path("updateUserRole/{id}/{uid}/{rid}")
    public void updateUserRole(@PathParam("id") int id,@PathParam("uid") int uid,@PathParam("rid") int rid)
    {
        admin.updateUserRole(uid, rid, id);
    }
    
    @RolesAllowed("Admin")
    @DELETE
    @Path("deleteUserrole/{id}")
    public void deleteUserrole(@PathParam("id") int id)
    {
        admin.removeUserRole(id);
    }
    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

  
}
