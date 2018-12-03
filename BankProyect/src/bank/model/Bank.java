/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.model;

import bank.Exceptions.CustomerNotExistentException;
import bank.Exceptions.FullCustomersCapacityException;

/**
 *
 * @author edgar.cambranes
 */
public class Bank{
    private Customer[] clients;
    private int numberOfCustomers;
    
    public Bank(int maxClients){
        clients = new Customer[maxClients];
        numberOfCustomers = 0;
    }
    
    public void addCustomer(Customer client){
        if(numberOfCustomers < clients.length ){
            clients[numberOfCustomers++] = client;
        }else{
            throw new FullCustomersCapacityException();
        }
    }
    /* ANTES
       public boolean addCustomer(Customer client){
       boolean flag = false;
       if(numberOfCustomers < clients.length ){
           clients[numberOfCustomers] = client;
           numberOfCustomers++;
           flag = true;
       }
       return flag;
    }
     */

    public void removeCustomerByID(int IDcustomer){
        clients[findCustomerIndex(IDcustomer)] = clients[numberOfCustomers-1];
        clients[numberOfCustomers-1] = null;
        numberOfCustomers--;
    }

    private int findCustomerIndex(int IDCustomer){
        for (int i = 0; i < numberOfCustomers; i++) {
            if (clients[i].getIDCustomer() == IDCustomer){
                return i;
            }
        }
        throw new CustomerNotExistentException();
    }
    /* ANTES
    public boolean removeCustomer(int IDcustomer){
        boolean flag = false;
            for(int i = 0; i < numberOfCustomers; i++){
                if(clients[i].getIDCustomer() == IDcustomer){
                    clients[i] = clients[numberOfCustomers-1];
                    clients[numberOfCustomers-1] = null;
                    numberOfCustomers--;
                    flag = true;
                }
            }

        return flag;
    }
     */
    
    public Customer searchClientByID(int IDClient){
        for(Customer client: clients){
            if(client.getIDCustomer() == IDClient){
                return client;
            }
        }
        throw new CustomerNotExistentException();
    }

    /*
    ANTES
    public Customer searchClient(int IDClient){
        Customer temp = null;
        for(Customer client: clients){
            if(client.getIDCustomer() == IDClient){
                temp = client;
            }
        }
        return temp;
    }
     */
    
    public String toString(){
      String output= "";
      for(int i = 0; i < numberOfCustomers; i++){
          output += clients[i].toString() +"\n";
      }
      return output;
    }
    
    
    
}
