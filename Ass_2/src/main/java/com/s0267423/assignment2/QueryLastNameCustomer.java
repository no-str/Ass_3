/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.s0267423.assignment2;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
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

// The QueryLastNameCustomer class is used to query the database for a specific 
// Customer and displays the results in a formatted manner. The user is prompted
// for the search term (last name), then by using the named query stored in the 
// Customer entity, uses the entity manager to manage the connection and return
// the results.

public class QueryLastNameCustomer {
    
    public static void main(String[] args) {

        String lastName = null;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPU");
        EntityManager em = emf.createEntityManager();

        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            // Prompt for the customer's last name
            Scanner inCustomerLastName = new Scanner(System.in);
            System.out.println("Enter the customer's last name:");
            lastName = inCustomerLastName.nextLine();
            
            // Initialising the query
            Query queryLastName = em.createNamedQuery("lastNameCustomer");
            queryLastName.setParameter(1, lastName);
            
            // Retieving the query results
            List selectCustomerList = queryLastName.getResultList();
            Iterator selectCustomerIterator = selectCustomerList.iterator();

            // Printing the results to console
            System.out.println("\nThe following Customer's match the last name " + lastName + ":");
            while (selectCustomerIterator.hasNext()) {
                Customer c = (Customer)selectCustomerIterator.next();
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