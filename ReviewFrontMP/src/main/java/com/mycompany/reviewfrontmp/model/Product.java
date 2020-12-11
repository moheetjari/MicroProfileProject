/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reviewfrontmp.model;

/**
 *
 * @author mohit
 */
public class Product {

    private Integer productid;

    private String productname;

    private String ReferenceLink;

    public Product() {
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getReferenceLink() {
        return ReferenceLink;
    }

    public void setReferenceLink(String ReferenceLink) {
        this.ReferenceLink = ReferenceLink;
    }
}
