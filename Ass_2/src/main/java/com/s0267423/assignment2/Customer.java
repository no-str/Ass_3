/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.s0267423.assignment2;

import com.s0267423.assignment2.Sale;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Scott Gibson
 * 
 */

// The purpose of the Customer class is to hold the constructors, setters and 
// getters for the Customer entity and the JPQL named queries used by the entity 
// manager to search the database. The Customer entity is in a one-to-many 
// unidirectional relationship with the Sales entity, whereby one Customer can 
// have many Sales. The Customer entity is also in a one-to-many relationship 
// with the Vehicle entity, where a customer can have many vehicles but a 
// vehicle can only have one customer.

@Entity
// Customer named query searches
@NamedQueries ({
    @NamedQuery(name = "allCustomer", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "lastNameCustomer", query = "SELECT c FROM Customer c WHERE c.customerLastName = ?1")
})

public class Customer implements Serializable {
    // Variable declaration
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String customerFirstName;
    private String customerLastName;
    private String licenceNumber;
    private String licenceState;
    private String address;
    private String contactPhone;
    private String emailAddress;
    // One-to-many relationship establishment
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
//    @JoinTable (name = "jnd_sale",
//            joinColumns = @JoinColumn (name = "customer_fk"),
//            inverseJoinColumns = @JoinColumn (name = "sale_fk"))
    private List<Sale> sales;
    
    // Empty Customer constructor
    public Customer() {
    }
    
    // Customer constructor
    public Customer (Integer id, String customerFirstName, String customerLastName, String licenceNumber, String licenceState, String address, String contactPhone, String emailAddress) {
        this.id = id;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.licenceNumber = licenceNumber;
        this.licenceState = licenceState;
        this.address = address;
        this.contactPhone = contactPhone;
        this.emailAddress = emailAddress;
    }
    
    // Customer getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getCustomerFirstName() {
        return customerFirstName;
    }
    
    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }
    
    public String getCustomerLastName() {
        return customerLastName;
    }
    
    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }
    
    public String getLicenceNumber() {
        return licenceNumber;
    }
    
    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }
    
    public String getLicenceState() {
        return licenceState;
    }
    
    public void setLicenceState(String licenceState) {
        this.licenceState = licenceState;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getContactPhone() {
        return contactPhone;
    }
    
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public List<Sale> getSales() {
        return sales;
    }
    
    public void setSales(List<Sale> sales) {
        this.sales = sales;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.s0267423.assignment2.Customer[ id=" + id + " ]";
    }    
}
