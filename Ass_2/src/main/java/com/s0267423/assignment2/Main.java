/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.s0267423.assignment2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;
import com.s0267423.assignment2.Customer;
import com.s0267423.assignment2.Sale;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

/**
 *
 * @author Scott Gibson
 * 
 */

// The purpose of the Main class is to provide a means for the user to enter 
// and retrieve data from the database. Uses are able to select various options 
// from a menu including adding a vehicle, customer or sale as well as 
// displaying all or searching for a specific customer. The Main class invokes 
// and uses the entity manager, ensuring any data entered is persisted into the 
// database.

public class Main {
    public static void main(String[] args) {
        // Menu option integer declaration
        int option = 0;
        char exit = 'n';
        
        // Initialise new scanenr object to recieve menu option
        Scanner scan = new Scanner(System.in);
        
        while (exit != 'y') {

            // Print out the menu options
            System.out.println("\nPlease choose an option below:" + 
                "\n[1] Add a new customer" + 
                "\n[2] Enter a new sale" +
                "\n[3] Add a Sedan vehicle" +
                "\n[4] Add a SUV vehicle" +
                "\n\n[8] Show all customers" + 
                "\n[9] Search for a customer by last name" +
                "\n[0] Exit");
            
            // Save the users menu option
            option = scan.nextInt();
            
            // Menu option actions
            switch (option) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    addSale();
                    break;
                case 3:
                    addSedan();
                    break;
                case 4:
                    addSUV();
                    break;
                case 8:
                    QueryAllCustomer.main(args);
                    break;
                case 9:
                    QueryLastNameCustomer.main(args);
                    break;
                case 0:
                    System.out.println("Stop Dave. Stop Dave. I am afraid. I am afraid Dave."); //2001: A Space Odyssey quote
                    System.exit(0);
                default:
                    System.out.println("Please choose a valid option!");
            }
        }
    }
    
    // This method adds a new customer to the database and persists the data.
    // The class functions by asking the user a series of questions and saves
    // the responses.
    public static void addCustomer() {
        // Creates a new Customer object
        Customer aCustomer = new Customer();
        
        // Prompt for the customer's first name
        Scanner inCustomerFirstName = new Scanner(System.in);
        System.out.println("Enter the customer's first name:");
        aCustomer.setCustomerFirstName(inCustomerFirstName.nextLine());
        
        // Prompt for the customer's last name
        Scanner inCustomerLastName = new Scanner(System.in);
        System.out.println("Enter the customer's last name:");
        aCustomer.setCustomerLastName(inCustomerLastName.nextLine());
        
        // Prompt for the customer's licence number
        Scanner inLicenceNumber = new Scanner(System.in);
        System.out.println("Enter the customer's licence number:");
        aCustomer.setLicenceNumber(inLicenceNumber.nextLine());
        
        // Prompt for the customer's licence state of issue
        Scanner inLicenceState = new Scanner(System.in);
        System.out.println("Enter the customer's licence state of issue:");
        aCustomer.setLicenceState(inLicenceState.nextLine());
        
        // Prompt for the customer's residential address
        Scanner inAddress = new Scanner(System.in);
        System.out.println("Enter the customer's address:");
        aCustomer.setAddress(inAddress.nextLine());
        
        // Prompt for the customer's contact phone number
        Scanner inContactPhone = new Scanner(System.in);
        System.out.println("Enter the customer's contact phone number:");
        aCustomer.setContactPhone(inContactPhone.nextLine());
        
        // Prompt for the customer's email address
        Scanner inEmailAddress = new Scanner(System.in);
        System.out.println("Enter the customer's email address:");
        aCustomer.setEmailAddress(inEmailAddress.nextLine());
        
        // Setup and create entity manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPU");
        EntityManager em = emf.createEntityManager();        

        // Persists aPerson in database
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(aCustomer);
        tx.commit();
        
        // Feedback to user showing that entered name has been persisted
        System.out.println("\nCustomer " + aCustomer.getCustomerFirstName()+ " " + aCustomer.getCustomerLastName() + " has been saved.");
                
        // Close entity manager connections
        em.close();
        emf.close();
    }
    
    // This method adds a new sale transaction to the database and persists the 
    // data. The class functions by asking the user a series of questions and 
    // saves the responses.
    public static void addSale() {
        // Creates a new Sale object
        Sale aSale = new Sale();
        
        // Prompt for the date of the sale
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date saleDate = null;
        Scanner inSaleDate = new Scanner(System.in);
        System.out.println("Enter the date of the sale (dd/MM/yyyy):");
        String date = inSaleDate.nextLine();
        try {
            saleDate = df.parse(date);
        } catch (ParseException e){
            e.printStackTrace();
        }
        aSale.setSaleDate(saleDate);
        
        // Prompt for the sale price of the vehicle
        String price;
        Scanner inSalePrice = new Scanner(System.in);
        System.out.println("Enter the sale price of the vehicle:");
        price = inSalePrice.nextLine();
        aSale.setSalePrice(new BigDecimal(price));
        
        // Setup and create entity manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPU");
        EntityManager em = emf.createEntityManager();
        
        // Persists aPerson in database
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(aSale);
        tx.commit();
        
        // Feedback to user showing that entered name has been persisted
        System.out.println("Sales information has been saved.");
        
        // Close entity manager connections
        em.close();
        emf.close();
    }
    
    // This method adds a new Sedan vehicle to the database and persists the data.
    // The class functions by asking the user a series of questions and saves
    // the responses.
    public static void addSedan() {
        // Create a new Sedan object
        Sedan aSedan = new Sedan();
        
        // Prompt for the vehicles VIN number
        Scanner inVin = new Scanner(System.in);
        System.out.println("Enter the vehicles VIN number:");
        aSedan.setVinNumber(inVin.nextLine());
        
        // Prompt for the vehicles make
        Scanner inMake = new Scanner(System.in);
        System.out.println("Enter the vehicles make:");
        aSedan.setMake(inMake.nextLine());
        
        // Prompt for the vehicles model
        Scanner inModel = new Scanner(System.in);
        System.out.println("Enter the vehicles model:");
        aSedan.setModel(inModel.nextLine());
        
        // Prompt for the year the vehicle was made
        Scanner inYear = new Scanner(System.in);
        System.out.println("What year was the vehicle made:");
        aSedan.setYearMade(Integer.parseInt(inYear.nextLine()));
        
        // Prompt for the type of fuel used
        Scanner inFuel = new Scanner(System.in);
        System.out.println("What fuel does the vehicle use:");
        aSedan.setFuelType(inFuel.nextLine());
        
        // Prompt for the number of engine cylinders
        Scanner inCylinders = new Scanner(System.in);
        System.out.println("How many cylinders does the engine have:");
        aSedan.setCylinders(Integer.parseInt(inCylinders.nextLine()));
        
        // Prompt for the type transmission
        Scanner inTransmission = new Scanner(System.in);
        System.out.println("Is the transmission Manual or Automatic");
        aSedan.setTransmission(inTransmission.nextLine());
        
        // Prompt for vehicles colour
        Scanner inColour = new Scanner(System.in);
        System.out.println("What colour is the vehicle:");
        aSedan.setColour(inColour.nextLine());
        
        // Prompt for the number of doors
        Scanner inDoors = new Scanner(System.in);
        System.out.println("How many doors does the car have:");
        aSedan.setDoors(Integer.parseInt(inDoors.nextLine()));
        
        // Prompt for the number of seats
        Scanner inSeats = new Scanner(System.in);
        System.out.println("How many seats does the car have:");
        aSedan.setSeats(Integer.parseInt(inSeats.nextLine()));
        
        // Prompt for heated seats
        Boolean a = false;
        Boolean b = false;
        String prompt = null;
        do {
            try {
                Scanner inHeatSeat = new Scanner(System.in);
                System.out.println("Are the car seats heated? Y/N:");
                prompt = inHeatSeat.nextLine();
                if (prompt.equals("Y")) {
                    a = true;
                    b = true;
                    aSedan.setSeatHeat(b);
                } else if (prompt.equals("N")) {
                    a = true;
                    b = false;
                    aSedan.setSeatHeat(b);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Only Y or N are accepted.");
            }
        } while (!a);
        
        // Prompt for cruise control available
        a = false;
        b = false;
        prompt = null;
        do {
            try {
                Scanner inCruiseControl = new Scanner(System.in);
                System.out.println("Does the car have cruise control? Y/N:");
                prompt = inCruiseControl.nextLine();
                if (prompt.equals("Y")) {
                    a = true;
                    b = true;
                    aSedan.setCruiseControl(b);
                } else if (prompt.equals("N")) {
                    a = true;
                    b = false;
                    aSedan.setCruiseControl(b);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Only Y or N are accepted.");
            }
        } while (!a);
        
        // Prompt for autopilot installed
        a = false;
        b = false;
        prompt = null;
        do {
            try {
                Scanner inAutoPilot = new Scanner(System.in);
                System.out.println("Does the car have Autopilot? Y/N:");
                prompt = inAutoPilot.nextLine();
                if (prompt.equals("Y")) {
                    a = true;
                    b = true;
                    aSedan.setAutoPilot(b);
                } else if (prompt.equals("N")) {
                    a = true;
                    b = false;
                    aSedan.setAutoPilot(b);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Only Y or N are accepted.");
            }
        } while (!a);
        
        // Prompt for split fold rear seat option
        a = false;
        b = false;
        prompt = null;
        do {
            try {
                Scanner inSplitFoldSeat = new Scanner(System.in);
                System.out.println("Does the car have split folding rear seats? Y/N:");
                prompt = inSplitFoldSeat.nextLine();
                if (prompt.equals("Y")) {
                    a = true;
                    b = true;
                    aSedan.setSplitFoldSeat(b);
                } else if (prompt.equals("N")) {
                    a = true;
                    b = false;
                    aSedan.setSplitFoldSeat(b);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Only Y or N are accepted.");
            }
        } while (!a);
        
        // Prompt for fuel economy
        Scanner inFuelConsumption = new Scanner(System.in);
        System.out.println("How many litres of fuel per 100km:");
        aSedan.setFuelConsumption(inFuelConsumption.nextDouble());
        
        // Setup and create entity manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPU");
        EntityManager em = emf.createEntityManager();
        
        // Persists aSedan in database
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(aSedan);
        tx.commit();
        
        // Feedback to user showing that entered name has been persisted
        System.out.println("Sedan information has been saved.");
        
        // Close entity manager connections
        em.close();
        emf.close();
    }
    
    // This method adds a SUV vehicle to the database and persists the data.
    // The class functions by asking the user a series of questions and saves
    // the responses.
    public static void addSUV() {
        // Create a new 4WD object
        Suv aSUV = new Suv();
        
        // Prompt for the vehicles VIN number
        Scanner inVin = new Scanner(System.in);
        System.out.println("Enter the vehicles VIN number:");
        aSUV.setVinNumber(inVin.nextLine());
        
        // Prompt for the vehicles make
        Scanner inMake = new Scanner(System.in);
        System.out.println("Enter the vehicles make:");
        aSUV.setMake(inMake.nextLine());
        
        // Prompt for the vehicles model
        Scanner inModel = new Scanner(System.in);
        System.out.println("Enter the vehicles model:");
        aSUV.setModel(inModel.nextLine());
        
        // Prompt for the year the vehicle was made
        Scanner inYear = new Scanner(System.in);
        System.out.println("What year was the vehicle made:");
        aSUV.setYearMade(Integer.parseInt(inYear.nextLine()));
        
        // Prompt for the type of fuel used
        Scanner inFuel = new Scanner(System.in);
        System.out.println("What fuel does the vehicle use:");
        aSUV.setFuelType(inFuel.nextLine());
        
        // Prompt for the number of engine cylinders
        Scanner inCylinders = new Scanner(System.in);
        System.out.println("How many cylinders does the engine have:");
        aSUV.setCylinders(Integer.parseInt(inCylinders.nextLine()));
        
        // Prompt for the type transmission
        Scanner inTransmission = new Scanner(System.in);
        System.out.println("Is the transmission Manual or Automatic");
        aSUV.setTransmission(inTransmission.nextLine());
        
        // Prompt for vehicles colour
        Scanner inColour = new Scanner(System.in);
        System.out.println("What colour is the vehicle:");
        aSUV.setColour(inColour.nextLine());
        
        // Prompt for the number of doors
        Scanner inDoors = new Scanner(System.in);
        System.out.println("How many doors does the car have:");
        aSUV.setDoors(Integer.parseInt(inDoors.nextLine()));
        
        // Prompt for the number of seats
        Scanner inSeats = new Scanner(System.in);
        System.out.println("How many seats does the car have:");
        aSUV.setSeats(Integer.parseInt(inSeats.nextLine()));
        
        // Prompt for maximum wading depth of vehicle
        Scanner inWading = new Scanner(System.in);
        System.out.println("Is the maximum wading depth in mm:");
        aSUV.setWadingDepth(inWading.nextInt());
        
        // Ask if the SUV has offroad tyres
        Boolean a = false;
        Boolean b = false;
        String prompt = null;
        do {
            try {
                Scanner inOffRoadTyres = new Scanner(System.in);
                System.out.println("Is the vehicle fitted with offroad tyres? Y/N:");
                prompt = inOffRoadTyres.nextLine();
                if (prompt.equals("Y")) {
                    a = true;
                    b = true;
                    aSUV.setOffroadTyres(b);
                } else if (prompt.equals("N")) {
                    a = true;
                    b = false;
                    aSUV.setOffroadTyres(b);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Only Y or N are accepted.");
            }
        } while (!a);
        
        // Prompt for number of spotlights fitted
        Scanner inSpotlight = new Scanner(System.in);
        System.out.println("How many spotights are fitted to the vehicle:");
        aSUV.setSpotlightNumber(inSpotlight.nextInt());
        
        // Ask if the SUV has a bullbar
        a = false;
        b = false;
        prompt = null;
        do {
            try {
                Scanner inBullbar = new Scanner(System.in);
                System.out.println("Does the vehicle have a bullbar? Y/N:");
                prompt = inBullbar.nextLine();
                if (prompt.equals("Y")) {
                    a = true;
                    b = true;
                    aSUV.setBullbar(b);
                } else if (prompt.equals("N")) {
                    a = true;
                    b = false;
                    aSUV.setBullbar(b);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Only Y or N are accepted.");
            }
        } while (!a);
        
        // Ask if the SUV has a snorkel
        a = false;
        b = false;
        prompt = null;
        do {
            try {
                Scanner inSnorkel = new Scanner(System.in);
                System.out.println("Is the car fitted with a snorkel? Y/N:");
                prompt = inSnorkel.nextLine();
                if (prompt.equals("Y")) {
                    a = true;
                    b = true;
                    aSUV.setSnorkel(b);
                } else if (prompt.equals("N")) {
                    a = true;
                    b = false;
                    aSUV.setSnorkel(b);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Only Y or N are accepted.");
            }
        } while (!a);
        
        // Setup and create entity manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPU");
        EntityManager em = emf.createEntityManager();
        
        // Persists aPerson in database
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(aSUV);
        tx.commit();
        
        // Feedback to user showing that entered name has been persisted
        System.out.println("SUV information has been saved.");
        
        // Close entity manager connections
        em.close();
        emf.close();
    }
}