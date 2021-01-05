/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testdepartment.model;

import com.mycompany.testdepartment.entity.DepartmentTB;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author mohit
 */
public class DepartmentModel {

    EntityManager em;
    Collection<Integer> collection;

    public DepartmentModel() {
        em = Persistence.createEntityManagerFactory("DepartmentPU").createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Collection<Integer> getCollection() {
        collection = new ArrayList<>();
        Collection<DepartmentTB> departmentTBs = em.createQuery("SELECT d FROM DepartmentTB d").getResultList();
        for (DepartmentTB departmentTB : departmentTBs) {
            collection.add(departmentTB.getId());
        }
        return collection;
    }

    public void setCollection(Collection<Integer> collection) {
        this.collection = collection;
    }

}
