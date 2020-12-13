/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reviewcategorymp.model;

import com.mycompany.reviewcategorymp.entity.Category;
import java.util.ArrayList;
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
public class CategoryModel {

    EntityManager em;
    Collection<Integer> availablIds;

    public CategoryModel() {
        em = Persistence.createEntityManagerFactory("CategoryPU").createEntityManager();

    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Collection<Integer> getAvailablIds() {
        availablIds = new ArrayList<>();
        Collection<Category> categories = em.createQuery("SELECT s from Category s").getResultList();
        for (Category c : categories) {
            availablIds.add(c.getCategoryId());
        }
        return availablIds;
    }

    public void setAvailablIds(Collection<Integer> availablIds) {
        this.availablIds = availablIds;
    }
}
