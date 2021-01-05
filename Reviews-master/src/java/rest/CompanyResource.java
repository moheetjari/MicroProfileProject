/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.commanejbLocal;
import entity.Company;
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
@Path("company")
@RequestScoped
public class CompanyResource {

    @EJB
    commanejbLocal comman;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CompanyResource
     */
    public CompanyResource() {
    }

    @RolesAllowed({"Admin","User"})
    @GET
    public Collection<Company> allCompany() {
        return comman.getAllCompany();
    }

    @RolesAllowed({"Admin"})
    @POST
    @Path("addCompany/{companyname}")
    public void addCompany(@PathParam("companyname") String companyname) {
        comman.addCompany(companyname);
    }

    @RolesAllowed({"Admin"})
    @GET
    @Path("getCompany/{companyid}")
    public Company getCompany(@PathParam("companyid") int companyid) {
        return comman.getCompanuById(companyid);
    }

    @RolesAllowed({"Admin"})
    @POST
    @Path("updateCompany/{companyid}/{companyname}")
    public void updateCompany(@PathParam("companyid") int companyid, @PathParam("companyname") String companyname) {
        comman.updateComapany(companyid, companyname);
    }

    @RolesAllowed({"Admin"})
    @POST
    @Path("deleteCompany/{companyid}")
    public void deleteCompany(@PathParam("companyid") int companyid) {
        comman.removeCompany(companyid);
    }
}
