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
        new BankUI("./BankProyect/Bank.txt");
   }
}
