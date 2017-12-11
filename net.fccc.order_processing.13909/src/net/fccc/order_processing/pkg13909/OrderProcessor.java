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
import java.util.ArrayList;

/**
 *
 * @author jpiasecki
 */
public class OrderProcessor {
    public static void ReadOrders() throws IOException 
    {
        
        String[] splitLine= new String[4];
        PrintWriter writeOrders = new PrintWriter(new BufferedWriter(new FileWriter("OrdersProcessed.txt",true)));

        try(BufferedReader br = new BufferedReader (new FileReader("Orders.txt")))
        {
            String line = br.readLine();
            
            while( !line.isEmpty() )
            {
                line.split(line);
                
                splitLine.equals(line);

                writeOrders.println("Order ID: " +splitLine);                                 
                
            }
          
        }
        
        catch(IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        
        writeOrders.close(); 
        
    }
}
