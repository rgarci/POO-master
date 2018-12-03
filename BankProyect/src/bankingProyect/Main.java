/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingProyect;

import bank.UI.BankUI;
import bank.controller.BankTextController;

/**
 *
 * @author edgar.cambranes
 */
public class Main {
    
   public static void main(String[] args) {
        //new BankUI();
       BankTextController bankTextController = new BankTextController();
       String[][] table = bankTextController.getHashTable("MariaMagdalena");
       for (int i = 0; i < 1; i++) {
           for (int j = 0; j < 4; j++) {
               System.out.print(table[i][j]);
           }
           System.out.println("\n");
       }
   }
    
}
