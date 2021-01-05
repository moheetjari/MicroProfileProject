/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.adminejbLocal;
import entity.Category;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("category")
@RequestScoped
public class CategoryResource {

    @EJB
    adminejbLocal admin;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CategoryResource
     */
    public CategoryResource() {
    }

    @RolesAllowed({"Admin","User"})
    @GET
    public Collection<Category> allCategory() {
        return admin.getAllCategory();
    }

    @RolesAllowed({"Admin"})
    @POST
    @Path("addCategory/{categoryname}")
    public void addCategory(@PathParam("categoryname") String categoryname) {
        admin.AddCategory(categoryname);
    }

    @RolesAllowed({"Admin"})
    @GET
    @Path("getCategory/{categoryid}")
    public Category getCategory(@PathParam("categoryid") int categoryid) {
        return admin.getCategoryById(categoryid);
    }

    @RolesAllowed({"Admin"})
    @POST
    @Path("updateCategory/{categoryid}/{categoryname}")
    public void updateCategory(@PathParam("categoryid") int categoryid, @PathParam("categoryname") String categoryname) {
        admin.updateCategory(categoryid, categoryname);
    }

    @RolesAllowed({"Admin"})
    @POST
    @Path("deleteCategory/{categoryid}")
    public void deleteCategory(@PathParam("categoryid") int categoryid) {
        admin.removeCategory(categoryid);
    }
}
