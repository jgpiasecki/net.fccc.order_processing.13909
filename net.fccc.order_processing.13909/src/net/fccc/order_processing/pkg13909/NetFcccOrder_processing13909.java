/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fccc.order_processing.pkg13909;

import java.io.*;



/**
 *
 * @author jpiasecki
 */
public class NetFcccOrder_processing13909 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        System.out.println("The list of orders is being processed please wait.");
        
        OrderProcessor();
        
        System.out.println("The list of oreders has properly been processed and "
                + "printed out to the 'OrdesProcessed.txt file' ");
    }
    
   
    public static void OrderProcessor() throws IOException 
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
                    double tax = solveTax(subtotal);
                    
                    writeOrders.println("Order ID: " + orderID);     
                    writeOrders.println("Part Number: " + partNum);
                    writeOrders.println("Price: " + price);
                    writeOrders.println("Quantity: " + quantity);
                    //writeOrders.println("Tax: " + )
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
    
    public static double solveTax(double subtotal)
    {
        final double TAX_RATE = 0.02;
        
        return TAX_RATE;
    }
}
    
    

