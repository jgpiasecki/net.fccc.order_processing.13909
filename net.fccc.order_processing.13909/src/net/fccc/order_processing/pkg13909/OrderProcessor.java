/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fccc.order_processing.pkg13909;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author jpiasecki
 */
public class OrderProcessor {
        public static void ReadWrite() throws IOException 
    {
        //trys to create a buffered reader to read the Oders file
        try(BufferedReader br = new BufferedReader (new FileReader("Orders.txt")))
        {   
            //calls the reader to rea the jirst line
           br.readLine();
            
           //reads the second line in orders and sets it equal to a string named line
            String line = br.readLine();
            
            /*trys to create a buffered writer named write order to create a file
             * if the file has not been created yet. if it has it will 
             * write to the file
             */
            try(PrintWriter writeOrders = new PrintWriter(new BufferedWriter(new FileWriter("OrdersProcessed.txt",true))))
            {
                //as long as line is not empty it will run this loop
                while( line !=null )
                {
                    //Creates a string array named items and splits line up at the |
                    String[] items = line.split("\\|");
                
                    //assigns the proper variables to their values
                    String orderID = items[0];
                    String partNum = items[1];
                    double price = Double.valueOf(items[2]);
                    int quantity = Integer.valueOf(items[3]);
                    double subtotal = price * quantity;
                    double tax = solveTax();
                    double shipping = solveShipping();
                    
                    //prints out the proper variables and their values to the file
                    writeOrders.println("Order ID: " + orderID);     
                    writeOrders.println("Part Number: " + partNum);
                    writeOrders.println("Price: " + price);
                    writeOrders.println("Quantity: " + quantity);
                    writeOrders.println("Tax: " + subtotal * tax);
                    writeOrders.println("Shipping: " + subtotal * shipping);
                    writeOrders.println("Toatal: " + subtotal + tax + shipping);
                    
                    //tells the reader to read the next line
                    line = br.readLine();
                }
            
            //closes the writer
            writeOrders.close(); 
            }
            
            //if an error is caught while writing then this error exception will be thrown
            catch(IOException e)
            {
                System.out.println("Error: " +e.getMessage());
            }
            
            //closes the reader
            br.close();
        }
       
        // if an error is caught while reading the file then this error exception is thown
        catch(IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        
        
        
    }
    
    //a method that sets a final taxrate
    public static double solveTax()
    {
        final double TAX_RATE = 0.02;
        
        return TAX_RATE;
    }
    
    //a method that sets a final shipping rate
    public static double solveShipping()
    {
        final double SHIPPING_RATE = 0.05;
        
        return SHIPPING_RATE;
    }
    
}
