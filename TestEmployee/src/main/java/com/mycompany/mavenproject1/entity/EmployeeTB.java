/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mohit
 */
@Entity
@Table(name = "EmployeeTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeTB.findAll", query = "SELECT e FROM EmployeeTB e"),
    @NamedQuery(name = "EmployeeTB.findById", query = "SELECT e FROM EmployeeTB e WHERE e.id = :id"),
    @NamedQuery(name = "EmployeeTB.findByName", query = "SELECT e FROM EmployeeTB e WHERE e.name = :name"),
    @NamedQuery(name = "EmployeeTB.findBySalary", query = "SELECT e FROM EmployeeTB e WHERE e.salary = :salary")})
public class EmployeeTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DepartmentId")
    private Integer departmentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Salary")
    private int salary;

    public EmployeeTB() {
    }

    public EmployeeTB(Integer id) {
        this.id = id;
    }

    public EmployeeTB(Integer id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeTB)) {
            return false;
        }
        EmployeeTB other = (EmployeeTB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.entity.EmployeeTB[ id=" + id + " ]";
    }

}
