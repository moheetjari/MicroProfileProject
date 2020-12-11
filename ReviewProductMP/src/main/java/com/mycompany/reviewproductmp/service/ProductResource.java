/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reviewproductmp.service;

import com.mycompany.reviewproductmp.entity.Product;
import com.mycompany.reviewproductmp.model.ProductModel;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Path;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 * REST Web Service
 *
 * @author mohit
 */
@Path("/product")
public class ProductResource {

    @Inject
    ProductModel product;

    @Inject
    @RestClient
    CategoryClient categoryclient;

    @GET
//    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Product> getAvailableProducts() {
        System.out.println("Entered in product Resource..");
        Collection<Integer> allids = categoryclient.getAvailableProductIds();
        return product.getAvailableProducts(allids);
    }
}
