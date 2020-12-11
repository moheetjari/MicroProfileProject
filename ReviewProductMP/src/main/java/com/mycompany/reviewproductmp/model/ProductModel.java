/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reviewproductmp.model;

import com.mycompany.reviewproductmp.entity.Product;
import java.util.Collection;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author mohit
 */
@Named
@ApplicationScoped
public class ProductModel {

    EntityManager em;
    Collection<Product> products;
    Collection<Product> availableProducts;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Collection<Product> getAvailableProducts(Collection<Integer> ids) {

        String allids = convertIntCollectionToString(ids);

        availableProducts = em.createQuery("SELECT p from Product p WHERE p.ProductId IN (" + allids + ")").getResultList();
        return availableProducts;
    }

    private String convertIntCollectionToString(Collection<Integer> ids) {
        String intString = "";
        for (Integer i : ids) {
            intString += i.toString() + ",";
        }
        return intString.substring(0, intString.length() - 1);
    }

    public void setAvailableProducts(Collection<Product> availableProducts) {
        this.availableProducts = availableProducts;
    }

    public ProductModel() {
        em = Persistence.createEntityManagerFactory("ProductPU").createEntityManager();
    }

    public Collection<Product> getProducts() {

        return em.createNamedQuery("Product.findAll").getResultList();
    }

    public void setProducts(Collection<Product> products) {

        this.products = products;
    }
}
