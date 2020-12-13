/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reviewcategorymp.service;

import com.mycompany.reviewcategorymp.model.CategoryModel;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author mohit
 */
@Path("/category")
@RequestScoped
public class CategoryResource {

    @Inject
    CategoryModel category;

    @GET
    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Integer> getAvailableCategoryIds() {
        System.out.println(category.getAvailablIds());
        return category.getAvailablIds();
    }
}
