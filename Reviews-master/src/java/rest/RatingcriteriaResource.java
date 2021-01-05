/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.adminejb;
import ejb.adminejbLocal;
import entity.Ratingcriterias;
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
@Path("ratingcriteria")
@RequestScoped
public class RatingcriteriaResource {

    @EJB
    adminejbLocal admin;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RatingcriteriaResource
     */
    public RatingcriteriaResource() {
    }

    @RolesAllowed({"Admin","User"})
    @GET
    public Collection<Ratingcriterias> allRatingCriteria() {
        return admin.getAllRatingCriteria();
    }

    @RolesAllowed({"Admin"})
    @POST
    @Path("addRatingCriteria/{ratingcriterianame}")
    public void addRatingCriteria(@PathParam("ratingcriterianame") String ratingcriterianame) {
        admin.addRatingCriteria(ratingcriterianame);
    }

    @RolesAllowed({"Admin"})
    @GET
    @Path("getRatingCriteria/{ratingcriteriaid}")
    public Ratingcriterias getRatingCriteria(@PathParam("ratingcriteriaid") int ratingcriteriaid) {
        return admin.getRatingCriteriaById(ratingcriteriaid);
    }

    @RolesAllowed({"Admin"})
    @POST
    @Path("updateRatingCriteria/{ratingcriteriaid}/{ratingcriterianame}")
    public void updateRatingCriteria(@PathParam("ratingcriteriaid") int ratingcriteriaid, @PathParam("ratingcriterianame") String ratingcriterianame) {
        admin.updateRatingCriteria(ratingcriteriaid, ratingcriterianame);
    }

    @RolesAllowed({"Admin"})
    @POST
    @Path("deleteRatingCriteria/{ratingcriteriaid}")
    public void deleteRatingCriteria(@PathParam("ratingcriteriaid") int ratingcriteriaid) {
        admin.removeRatingCriteria(ratingcriteriaid);
    }
}
