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

// The purpose of the Sedan class is to hold the constructors, setters and 
// getters for the Sedan entity. The Sedan entity is a leaf (child) entity of 
// the Vehicle class, who it inherits attributes from.

@Entity
public class Sedan extends Vehicle implements Serializable {
    // Variable initialization
    private static final long serialVersionUID = 1L;
    private Boolean seatHeat;
    private Boolean cruiseControl;
    private Boolean autoPilot;
    private Boolean splitFoldSeat;
    private Double fuelConsumption;
    
    // Empty Sedan constructor
    public Sedan() {
    }
    
    // Sedan constructor
    public Sedan (Boolean seatHeat, Boolean cruiseControl, Boolean autoPilot, Boolean splitFoldSeat, Double fuelConsumption) {
        this.seatHeat = seatHeat;
        this.cruiseControl = cruiseControl;
        this.autoPilot = autoPilot;
        this.splitFoldSeat = splitFoldSeat;
        this.fuelConsumption = fuelConsumption;
    }
    
    // Sedan setters and getters
    public Boolean getSeatHeat() {
        return seatHeat;
    }
    
    public void setSeatHeat(Boolean seatHeat) {
        this.seatHeat = seatHeat;
    }
    
    public Boolean getCruiseControl() {
        return cruiseControl;
    }
    
    public void setCruiseControl(Boolean cruiseControl) {
        this.cruiseControl = cruiseControl;
    }
    
    public Boolean getAutoPilot() {
        return autoPilot;
    }
    
    public void setAutoPilot(Boolean autoPilot) {
        this.autoPilot = autoPilot;
    }
    
    public Boolean setSplitFoldSeat() {
        return splitFoldSeat;
    }
    
    public void setSplitFoldSeat(Boolean splitFoldSeat) {
       this.splitFoldSeat = splitFoldSeat;
    }
    
    public Double getFuelConsumption() {
        return fuelConsumption;
    }
    
    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    
}
