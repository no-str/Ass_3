/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.s0267423.assignment2;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Scott Gibson
 * 
 */

// The purpose of the Suv class is to hold the constructors, setters and 
// getters for the Suv entity. Much like the Sedan entity, the Suv entity is a 
// leaf (child) entity of the Vehicle class, who it inherits attributes from.

@Entity
public class Suv extends Vehicle implements Serializable {
    // Variable initialization
    private static final long serialVersionUID = 1L;
    private Integer wadingDepth;
    private Boolean offroadTyres;
    private Integer spotlightNumber;
    private Boolean bullbar;
    private Boolean snorkel;

    // Empty Suv constructor
    public Suv() {
    }
    
    // Suv constructor
    public Suv (Integer wadingDepth, Boolean offroadTyres, Integer spotlightNumber, Boolean bullbar, Boolean snorkel) {
        this.wadingDepth = wadingDepth;
        this.offroadTyres = offroadTyres;
        this.spotlightNumber = spotlightNumber;
        this.bullbar = bullbar;
        this.snorkel = snorkel;
    }
    
    // Suv setters and getters
    public Integer getWadingDepth() {
        return wadingDepth;
    }
    
    public void setWadingDepth(Integer wadingDepth) {
        this.wadingDepth = wadingDepth;
    }
    
    public Boolean getOffroadTyres() {
        return offroadTyres;
    }
    
    public void setOffroadTyres(Boolean offroadTyres) {
        this.offroadTyres = offroadTyres;
    }

    public Integer getSpotlightNumber() {
        return spotlightNumber;
    }
    
    public void setSpotlightNumber(Integer spotlightNumber) {
        this.spotlightNumber = spotlightNumber;
    }
    
    public Boolean getBullbar() {
        return bullbar;
    }
    
    public void setBullbar(Boolean bullbar) {
        this.bullbar = bullbar;
    }
    
    public Boolean getSnorkel() {
        return snorkel;
    }
    
    public void setSnorkel(Boolean snorkel) {
        this.snorkel = snorkel;
    }
}
