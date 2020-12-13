/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reviewfrontmp.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import token.GenerateToken;

/**
 *
 * @author mohit
 */
@RegisterRestClient(configKey = "productClient", baseUri = "http://localhost:8080/ReviewProductMP/rest")
@ApplicationScoped
@Path("/product")
public interface ProductClient {

    @GET
    @ClientHeaderParam(name = "authorization", value = "{generateJWTToken}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object[]> getAvailableProducts();

    default String generateJWTToken() {
        Config config = ConfigProvider.getConfig();
        String token = "Bearer " + GenerateToken.generateJWT();
        System.out.println("Product Token = " + token);
        return token;
    }
}
