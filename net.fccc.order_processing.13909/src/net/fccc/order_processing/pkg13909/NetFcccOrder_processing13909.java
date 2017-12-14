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
        
        //Starts off by telling the user the order list is being processed
        System.out.println("The list of orders is being processed please wait.");
        
        //calls for the order processor
        OrderProcessor.ReadWrite();
        
        //Finishes off by telling the user the processor is finished
        System.out.println("The list of oreders has properly been processed and "
                + "printed out to the 'OrdesProcessed.txt file' ");
    }
    
   

}
    
    

