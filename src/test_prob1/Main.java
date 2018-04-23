/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_prob1;

/**
 *
 * @author vicol
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Profit1 p1 = new Profit1();
        Profit p = new Profit();
        Profit2 p2 = new Profit2();
        
        p.readFile();
        p1.readFile1();
        p2.readFile1();
    }
    
}
