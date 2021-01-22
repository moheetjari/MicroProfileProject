/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examemployee.model;

import com.mycompany.examemployee.entity.EmployeeTB;
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

    public EmployeeModel() {
        em = Persistence.createEntityManagerFactory("MyPU").createEntityManager();
    }

    public List<EmployeeTB> getEmployee(String deptName) {
        if (deptName.equals("IT")) {
            return em.createNativeQuery("Select * from EmployeeTB e where e.departmentName = '" + deptName + "'", EmployeeTB.class).getResultList();
        } else if (deptName.equals("Sales")) {
            return em.createNativeQuery("Select * from EmployeeTB e where e.departmentName = '" + deptName + "'", EmployeeTB.class).getResultList();
        }
        return em.createNamedQuery("EmployeeTB.findAll").getResultList();
    }
}
