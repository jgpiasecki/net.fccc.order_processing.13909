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
        
        
        

        try(BufferedReader br = new BufferedReader (new FileReader("Orders.txt")))
        {   
           br.readLine();
            
            String line = br.readLine();
            
            
            try(PrintWriter writeOrders = new PrintWriter(new BufferedWriter(new FileWriter("OrdersProcessed.txt",true))))
            {
                while( line !=null )
                {
                
                
                
                    String[] items = line.split("\\|");
                
                
                    String orderID = items[0];
                    String partNum = items[1];
                    double price = Double.valueOf(items[2]);
                    int quantity = Integer.valueOf(items[3]);
                    double subtotal = price * quantity;
                    double tax = solveTax();
                    double shipping = solveShipping();
                    
                    writeOrders.println("Order ID: " + orderID);     
                    writeOrders.println("Part Number: " + partNum);
                    writeOrders.println("Price: " + price);
                    writeOrders.println("Quantity: " + quantity);
                    writeOrders.println("Tax: " + subtotal + tax);
                    writeOrders.println("Shipping: " + subtotal + shipping);
                    writeOrders.println("Toatal: " + subtotal + tax + shipping);
                    br.readLine();
                }
            
            
            writeOrders.close(); 
            }
            
            catch(IOException e)
            {
                System.out.println("Error: " +e.getLocalizedMessage());
            }
            
            
        }
       
        catch(IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        
        
        
    }
    
    public static double solveTax()
    {
        final double TAX_RATE = 0.02;
        
        return TAX_RATE;
    }
    
    public static double solveShipping()
    {
        final double SHIPPING = 0.05;
        
        return SHIPPING;
    }
    
}
