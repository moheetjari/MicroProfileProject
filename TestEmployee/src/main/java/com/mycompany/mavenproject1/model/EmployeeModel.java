/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.model;

import com.mycompany.mavenproject1.entity.EmployeeTB;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author mohit
 */
public class EmployeeModel {

    EntityManager em;
    Collection<EmployeeTB> employeeTBs;

    public EmployeeModel() {
        em = Persistence.createEntityManagerFactory("EmployeePU").createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Object[]> getEmployeeTBs(Collection<Integer> ids) {
        String allids = convertIntCollectionToString(ids);
        return em.createNativeQuery("SELECT * FROM EmployeeTB e WHERE e.DepartmentId IN (" + allids + ")").getResultList();
    }

    private String convertIntCollectionToString(Collection<Integer> ids) {
        String intString = "";
        for (Integer i : ids) {
            intString += i.toString() + ",";
        }
        return intString.substring(0, intString.length() - 1);
    }

    public void AddEmployee(String name, Integer departmentid, Integer salary) {
        EmployeeTB employeeTB = new EmployeeTB();
        employeeTB.setName(name);
        employeeTB.setDepartmentId(departmentid);
        employeeTB.setSalary(salary);
        em.getTransaction().begin();
        em.persist(employeeTB);
        em.getTransaction().commit();
    }
}
