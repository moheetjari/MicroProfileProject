/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.adminejbLocal;
import entity.Categoryratingcriteria;
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
@Path("categoryratingcriteria")
@RequestScoped
public class CategoryratingcriteriaResource {

    @EJB
    adminejbLocal admin;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CategoryratingcriteriaResource
     */
    public CategoryratingcriteriaResource() {
    }

    @RolesAllowed({"Admin","User"})
    @GET
    public Collection<Categoryratingcriteria> allCategoryratingcriteria() {
        return admin.getAllCategoryRatingCriteria();
    }

    @RolesAllowed({"Admin"})
    @POST
    @Path("addCategoryratingcriteria/{categoryid}/{ratingcriteriaid}")
    public void addCategoryratingcriteria(@PathParam("categoryid") int categoryid, @PathParam("ratingcriteriaid") int ratingcriteriaid) {
        admin.addCategoryRatingCriteria(categoryid, ratingcriteriaid);
    }

    @RolesAllowed({"Admin"})
    @GET
    @Path("getCategoryratingcriteria/{categoryratingcriteriaid}")
    public Categoryratingcriteria getCategoryratingcriteria(@PathParam("categoryratingcriteriaid") int categoryratingcriteriaid) {
        return admin.getCategoryRatingCriteriaById(categoryratingcriteriaid);
    }

    @RolesAllowed({"Admin"})
    @POST
    @Path("updateCategoryratingcriteria/{categoryratingcriteriaid}/{categoryid}/{ratingcriteriaid}")
    public void updateCategoryratingcriteria(@PathParam("categoryratingcriteriaid") int categoryratingcriteriaid, @PathParam("categoryid") int categoryid, @PathParam("ratingcriteriaid") int ratingcriteriaid) {
        admin.updateCategoryRatingCriteria(categoryratingcriteriaid, categoryid, ratingcriteriaid);
    }

    @RolesAllowed({"Admin"})
    @POST
    @Path("deleteCategoryratingcriteria/{categoryratingcriteriaid}")
    public void deleteCategoryratingcriteria(@PathParam("categoryratingcriteriaid") int categoryratingcriteriaid) {
        admin.removeCategoryRatingCriteria(categoryratingcriteriaid);
    }

    @RolesAllowed({"Admin"})
    @GET
    @Path("getCategoryratingcriteriaByCategoryId/{categoryid}")
    public Categoryratingcriteria getCategoryratingcriteriaByCategoryId(@PathParam("categoryid") int categoryid) {
        return (Categoryratingcriteria) admin.getCategoryRatingCriteriaByCategoryId(categoryid);
    }

    @RolesAllowed({"Admin"})
    @GET
    @Path("getCategoryRatingCriteriaByRatingCriteriaId/{ratingcriteriaid}")
    public Categoryratingcriteria getCategoryRatingCriteriaByRatingCriteriaId(@PathParam("ratingcriteriaid") int ratingcriteriaid) {
        return (Categoryratingcriteria) admin.getCategoryRatingCriteriaByRatingCriteriaId(ratingcriteriaid);
    }

}
