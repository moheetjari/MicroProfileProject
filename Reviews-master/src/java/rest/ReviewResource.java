/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.adminejbLocal;
import entity.Reviews;
import java.util.Collection;
import java.util.Date;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author hi
 */
@Path("review")
@RequestScoped
public class ReviewResource {

    @Context
    private UriInfo context;
    @EJB
    adminejbLocal admin;

    /**
     * Creates a new instance of ReviewResource
     */
    public ReviewResource() {
    }

    /**
     * Retrieves representation of an instance of restService.ReviewResource
     * @return an instance of java.lang.String
     */
    @RolesAllowed({"Admin","User"})
    @GET
    public Collection<Reviews> allReview() {
        return admin.getAllReviews();
    }

    @RolesAllowed({"Admin","User"})
    @POST
    @Path("addReview/{productid}/{date}/{userid}")
    public void addReview(@PathParam("productid") int productid, @PathParam("date") Date date, @PathParam("userid") int userid) {
        admin.addReview(productid, date, userid);
    }

    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getReview/{reviewid}")
    public Reviews getReviews(@PathParam("reviewid") int reviewid) {
        return admin.getReviewById(reviewid);
    }

    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getReviewByUserId/{userid}")
    public Reviews getReviewByUserId(@PathParam("userid") int userid) {
        return (Reviews) admin.getReviewsByUserId(userid);
    }

    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getReviewByProductId/{productid}")
    public Reviews getReviewByProductId(@PathParam("productid") int productid) {
        return (Reviews) admin.getReviewByProductID(productid);
    }

    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getReviewByDate/{date}")
    public Reviews getReviewByDate(@PathParam("date") Date date) {
        return (Reviews) admin.getReviewByDate(date);
    }

    @RolesAllowed({"Admin"})
    @POST
    @Path("updateReview/{reviewid}/{productid}/{date}/{userid}")
    public void updateReview(@PathParam("reviewid") int reviewid, @PathParam("productid") int productid, @PathParam("date") Date date, @PathParam("userid") int userid) {
        admin.updateReview(reviewid, productid, date, userid);
    }

    @RolesAllowed({"Admin"})
    @POST
    @Path("deleteReview/{reviewid}")
    public void deleteReview(@PathParam("reviewid") int reviewid) {
        admin.removeReview(reviewid);
    }

    /**
     * PUT method for updating or creating an instance of ReviewResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
