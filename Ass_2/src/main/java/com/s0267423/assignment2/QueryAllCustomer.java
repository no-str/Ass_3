/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.s0267423.assignment2;

import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Scott Gibson
 * 
 */

// The QueryAllCustomer class is used to query the database for all the stored 
// customers and display the results in a formatted manner. The class uses the 
// entity manager to manage the connection.

public class QueryAllCustomer {
    
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPU");
        EntityManager em = emf.createEntityManager();

        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            // Initialising the query
            Query queryAll = em.createNamedQuery("allCustomer");
            
            // Retieving the query results
            List allCustomerList = queryAll.getResultList();
            Iterator allCustomerIterator = allCustomerList.iterator();
            
            // Printing the results to console
            System.out.println("All customer records below:");
            while (allCustomerIterator.hasNext()) {
                Customer c = (Customer)allCustomerIterator.next();
                System.out.println("\nID: " + c.getId() + "  " + c.getCustomerFirstName() + " " + c.getCustomerLastName());
                System.out.print("Lic No: " + c.getLicenceNumber() + ", Lic State: " + c.getLicenceState());
                System.out.print("\n" + c.getAddress());
                System.out.println("\nPh: " + c.getContactPhone() + ", E: " + c.getEmailAddress());
            }
        } finally {
            // Close the connection
            em.close();
        }
    }  
}
