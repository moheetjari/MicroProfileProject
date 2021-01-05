/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author hi
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(client.RestFilter.class);
        resources.add(rest.AuthorResource.class);
        resources.add(rest.CategoryResource.class);
        resources.add(rest.CategoryratingcriteriaResource.class);
        resources.add(rest.CompanyResource.class);
        resources.add(rest.GenreResource.class);
        resources.add(rest.ProductResource.class);
        resources.add(rest.PublisherResource.class);
        resources.add(rest.RatingcriteriaResource.class);
        resources.add(rest.RegisterResource.class);
        resources.add(rest.ReviewResource.class);
        resources.add(rest.ReviewxcriteriaResource.class);
        resources.add(rest.RoleResource.class);
        resources.add(rest.UserResource.class);
        resources.add(rest.UserroleResource.class);
    }
    
}
