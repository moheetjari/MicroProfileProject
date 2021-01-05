/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.commanejbLocal;
import entity.Genre;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("genre")
@RequestScoped
public class GenreResource {
    
    @EJB
    commanejbLocal comman;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenreResource
     */
    public GenreResource() {
    }

    @RolesAllowed({"Admin","User"})
    @GET
    public Collection<Genre> allGenre() {
        return comman.getAllGenre();
    }
    
    @RolesAllowed({"Admin"})
    @POST
    @Path("addGenre/{genrename}")
    public void addGenre(@PathParam("genrename") String genrename) {
        comman.addGenre(genrename);
    }
    
    @RolesAllowed({"Admin"})
    @GET
    @Path("getGenre/{genreid}")
    public Genre getGenre(@PathParam("genreid") int genreid) {
        return comman.getGenreById(genreid);
    }
    
    @RolesAllowed({"Admin"})
    @POST
    @Path("updateGenre/{genreid}/{genrename}")
    public void updateGenre(@PathParam("genreid") int genreid, @PathParam("genrename") String genrename) {
        comman.updateGenre(genreid, genrename);
    }
    
    @RolesAllowed({"Admin"})
    @POST
    @Path("deleteGenre/{genreid}")
    public void deleteGenre(@PathParam("genreid") int genreid) {
        comman.removeGenre(genreid);
    }
}
