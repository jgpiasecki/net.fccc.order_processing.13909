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
        
        OrderProcessor.ReadWrite();
        
        System.out.println("The list of oreders has properly been processed and "
                + "printed out to the 'OrdesProcessed.txt file' ");
    }
    
   

}
    
    

