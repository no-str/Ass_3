/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.s0267423.assignment2;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Scott Gibson
 * 
 */

// The purpose of the Vehicle class is to hold the constructors, setters and 
// getters for the Vehicle entity. The Vehicle class is the root class for the 
// Sedan and Suv leaf classes, whereby shared attributes are inherited. The 
// strategy used to form the inheritance is the joined-subclass strategy. The 
// Vehicle entity is in a one-to-one relationship with the Sale entity.

@Entity
//Establish the joined-subclass inheritance strategy
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle implements Serializable {
    // Variable initialization
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String vinNumber;
    private String make;
    private String model;
    private Integer yearMade;
    private String fuelType;
    private Integer cylinders;
    private String transmission;
    private String colour;
    private Integer doors;
    private Integer seats;

    // Empty Vehicle constructor
    public Vehicle() {
    }
    
    // Vehicle constructor
    public Vehicle(String vinNumber, String make, String model, Integer yearMade,
            String fuelType, Integer cylinders, String transmission, String colour, Integer doors, Integer seats) {
        this.vinNumber = vinNumber;
        this.make = make;
        this.model = model;
        this.yearMade = yearMade;
        this.fuelType = fuelType;
        this.cylinders = cylinders;
        this.transmission = transmission;
        this.colour = colour;
        this.doors = doors;
        this.seats = seats;
    }
    
    // Vehicle setters and getters
    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }
    
    public String getMake() {
        return make;
    }
    
    public void setMake(String make) {
        this.make = make;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public Integer getYearMade() {
        return yearMade;
    }
    
    public void setYearMade(Integer yearMade) {
        this.yearMade = yearMade;
    }
    
    public String getFuelType() {
        return fuelType;
    }
    
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getCylinders() {
        return cylinders;
    }
    
    public void setCylinders(Integer cylinders) {
        this.cylinders = cylinders;
    }
    
    public String getTransmission() {
        return transmission;
    }
    
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
    
    public String getColour() {
        return colour;
    }
    
    public void setColour(String colour) {
        this.colour = colour;
    }

    public Integer getDoors() {
        return doors;
    }
    
    public void setDoors(Integer doors) {
        this.doors = doors;
    }
    
    public Integer getSeats() {
        return seats;
    }
    
    public void setSeats(Integer seats) {
        this.seats = seats;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vinNumber != null ? vinNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.vinNumber == null && other.vinNumber != null) || (this.vinNumber != null && !this.vinNumber.equals(other.vinNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.s0267423.assignment2.Vehicle[ id=" + vinNumber + " ]";
    }
    
}
