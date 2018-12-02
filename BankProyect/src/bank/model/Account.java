/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.model;

/**
 *
 * @author edgar.cambranes
 */

import bank.Exceptions.NotEnoughBalanceException;

/**
 * @AUTHORS: POO FMAT 
 */
public class Account{
    public static final String  CREDIT= "CREDIT";
    public static final String DEBIT = "DEBIT";

    private int IDaccount;
    private double balance;
    private String typeAccount;
    
    public Account (int IDaccount, String typeAccount, double balance) {
        this.IDaccount =IDaccount;
        this.typeAccount = typeAccount;
        this.balance = balance;
    }

   /*  ANTES
    public Account (int IDKey, String typeAccount, double balance) {
        this.IDaccount =IDkey;
        IDkey++;
        this.typeAccount = typeAccount;
        this.balance = balance;
    }
     */
    
    /*public Account (double balance) {               
        this.IDaccount =IDkey;
        IDkey++;
        this.balance = balance;
    }
    */
    public double withdraw(double ammount){
        if(balance>=ammount){
            return balance-=ammount;
        }
        throw new NotEnoughBalanceException();
    }

    /* ANTES
    public double withdraw(double ammount){
        if(balance>=ammount){
            balance = balance - ammount;
        }
        return balance;
    }
     */
    
    /* ANTES
    public double deposit(double ammount){
        return balance;

    }*/
    public double deposit(double ammount){
        return balance+=ammount;
    }
    
    public void setBalance (double balance){
        this.balance = balance;
    }
    
    public double getBalance (){
        return balance;
    }
    
    public int getIDAccount(){
        return this.IDaccount;
    }
    
    public String toString(){
        return "ID Account: " +IDaccount +
               ", Type: " + typeAccount+
               " ,Balance: " + balance;
    }
}
