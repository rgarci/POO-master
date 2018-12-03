/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.model;

import bank.Exceptions.AccountNotExistentException;
import bank.Exceptions.FullAccountsCapacityException;

/**
 *
 * @author edgar.cambranes
 */
public class Customer{
    private int IDCustomer;
    private String firstName;
    private String lastName;
    private Account accounts[];
    private int numberOfAccounts;
    
       

    /* ANTES
    public Customer (int IDCustomer, String firstName, String lastName) {
        this.IDCustomer =IDkey;
        IDkey++;
        this.firstName = firstName;
        this.lastName = lastName;
    }
     */
    
    public Customer (int IDCustomer,String firstName, String lastName, int maxAccounts) {
        this.IDCustomer =IDCustomer;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new Account[maxAccounts];
    }

    /*  ANTES
    public Customer (String firstName, String lastName, int maxAccounts) {
        this.IDCustomer =IDkey;
        IDkey++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new Account[maxAccounts];
    }
     */

    public int getIDCustomer(){
        return IDCustomer;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    public void addAccount(Account account){
        if(numberOfAccounts < accounts.length ){
            accounts[numberOfAccounts++] = account;
        }else{
            throw new FullAccountsCapacityException();
        }
    }
    /* ANTES
    public boolean addAccount(Account account){
        boolean flag = false;
        if(numberOfAccounts < accounts.length ){
            accounts[numberOfAccounts] = account;
            numberOfAccounts++;
            flag = true;
        }
        return flag;
    }
     */
    public void removeAccount(int IDAccount){
        accounts[getAccountIndex(IDAccount)] = accounts[numberOfAccounts-1];
        accounts[numberOfAccounts-1] = null;
        numberOfAccounts--;
    }

    private int getAccountIndex(int IDAccount){
        for (int i = 0; i < numberOfAccounts; i++) {
            if (accounts[i].getIDAccount() == IDAccount){
                return i;
            }
        }
        throw new AccountNotExistentException();
    }
    /* ANTES
    public boolean removeAccount(int IDAccount){
        boolean flag = false;
            for(int i = 0; i < numberOfAccounts; i++){
                if(accounts[i].getIDAccount() == IDAccount){
                    accounts[i] = accounts[numberOfAccounts-1];
                    accounts[numberOfAccounts-1] = null;
                    numberOfAccounts--;
                    flag = true;
                }
            }

        return flag;
    }

     */
    public Account getAccountByID(int IDAccount){
        for(Account account: accounts){
            if(account.getIDAccount() == IDAccount){
                return account;
            }
        }
        throw new AccountNotExistentException();
    }

    
    public boolean hasSameID(int IDOtherCustomer){
        return (this.IDCustomer == IDOtherCustomer);
    }
    
    public String toString(){
        String output = "ID Customer: " + this.IDCustomer+
               " ,Fist Name: " + this.firstName+
               " ,Last Name: " + this.lastName + "\n" +
               "Accounts:" + "\n";
        
        for(int i = 0; i < numberOfAccounts; i++){
        output += accounts[i].toString() +"\n";
        }
        return output;
    }

}                               

