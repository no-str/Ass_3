/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.s0267423.assignment2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Scott Gibson
 * 
 */

// The purpose of the Sale class is to hold the constructors, setters and 
// getters for the Sale entity. The Sale object is in a one-to-many 
// unidirectional relationship with the Sales entity, whereby many Sales can 
// belong to one Customer. An assumption is made, that a vehicle can only be 
// sold once. Therefore the relationship between the Sale and Vehicle entities 
// is a one-to-one-relationship.

@Entity
@Table (name = "sale")
public class Sale implements Serializable {
    // Variable initialization
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer saleID;
    @Temporal(TemporalType.DATE)
    private Date saleDate;
    private BigDecimal salePrice;
    
    // Empty Sale constructor
    public Sale() {
    }
    
    // Sale constructor
    public Sale(Integer saleID, Date saleDate, BigDecimal salePrice) {
        this.saleID = saleID;
        this.saleDate = saleDate;
        this.salePrice = salePrice;
    }
    
    // Sale setters and getters
    public Integer getSaleID() {
        return saleID;
    }

    public void setSaleID(Integer saleID) {
        this.saleID = saleID;
    }
    
    public Date getSaleDate() {
        return saleDate;
    }
    
    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }
    
    public BigDecimal getSalePrice() {
        return salePrice;
    }
    
    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (saleID != null ? saleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sale)) {
            return false;
        }
        Sale other = (Sale) object;
        if ((this.saleID == null && other.saleID != null) || (this.saleID != null && !this.saleID.equals(other.saleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.s0267423.assignment2.Sale[ id=" + saleID + " ]";
    }
    
}
