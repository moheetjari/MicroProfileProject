/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.adminejbLocal;
import entity.Reviewxcriteria;
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
@Path("reviewxcriteria")
@RequestScoped
public class ReviewxcriteriaResource {

    @EJB
    adminejbLocal admin;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ReviewxcriteriaResource
     */
    public ReviewxcriteriaResource() {
    }

    @RolesAllowed({"Admin","User"})
    @GET
    public Collection<Reviewxcriteria> allReviewxcriteria() {
        return admin.getAllReviewxCriteria();
    }

    @RolesAllowed({"Admin","User"})
    @POST
    @Path("addReviewxcriteria/{rate}/{description}/{categoryratingcriteriaid}/{reviewid}")
    public void addReviewxcriteria(@PathParam("rate") int rate, @PathParam("description") String description, @PathParam("categoryratingcriteriaid") int categoryratingcriteriaid, @PathParam("reviewid") int reviewid) {
        admin.addReviewxCriteria(rate, description, categoryratingcriteriaid, reviewid);
    }

    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getReviewxcriteria/{reviewxcriteriaid}")
    public Reviewxcriteria getReviewxcriteria(@PathParam("reviewxcriteriaid") int reviewxcriteriaid) {
        return admin.getReviewxCriteriaById(reviewxcriteriaid);
    }

    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getReviewxcriteriaByRate/{rate}")
    public Reviewxcriteria getReviewxcriteriaByRate(@PathParam("rate") int rate) {
        return (Reviewxcriteria) admin.getReviewxCriteriaByRate(rate);
    }

    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getReviewxcriteriaByCategoryratingcriteria/{categoryratingcriteriaid}")
    public Reviewxcriteria getReviewxcriteriaByCategoryratingcriteria(@PathParam("categoryratingcriteriaid") int categoryratingcriteriaid) {
        return (Reviewxcriteria) admin.getReviewxCriteriaByCategoryRatingCriteriaId(categoryratingcriteriaid);
    }

    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getReviewxcriteriaByReview/{reviewid}")
    public Reviewxcriteria getReviewxcriteriaByReview(@PathParam("reviewid") int reviewid) {
        return (Reviewxcriteria) admin.getReviewxCriteriaByReviewId(reviewid);
    }

    @RolesAllowed({"Admin"})
    @POST
    @Path("updateReviewxcriteria/{reviewxcriteriaid}/{rate}/{description}/{categoryratingcriteriaid}/{reviewid}")
    public void updateAuthor(@PathParam("reviewxcriteriaid") int reviewxcriteriaid, @PathParam("rate") int rate, @PathParam("description") String description, @PathParam("categoryratingcriteriaid") int categoryratingcriteriaid, @PathParam("reviewid") int reviewid) {
        admin.updateReviewxCriteria(reviewxcriteriaid, rate, description, categoryratingcriteriaid, reviewid);
    }

    @RolesAllowed({"Admin"})
    @POST
    @Path("deleteReviewxcriteria/{reviewxcriteriaid}")
    public void deleteReviewxcriteria(@PathParam("reviewxcriteriaid") int reviewxcriteriaid) {
        admin.removeReviewxCriteria(reviewxcriteriaid);
    }
}
