package bank.model;

import bank.Exceptions.CouldNotReadBankTextException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class BankTextReader {

   
   public ArrayList<String> getLinesFromBankText(String fileName){
       try
          {
           Scanner sc = new Scanner(new FileReader(fileName));
           ArrayList<String> list = new ArrayList<>();
           while (sc.hasNext()){
               list.add(sc.next());
           }
           sc.close();
           return list;
       } catch(FileNotFoundException exc){
           System.err.print(exc);
       }
        throw new CouldNotReadBankTextException();
   }
   /*
   ANTES
   public ArrayList<String> bankReader(String fileName){
   try
      {
       Scanner sc = new Scanner(new FileReader(fileName));
       ArrayList<String> list = new ArrayList<>();
       while (sc.hasNext()){
           list.add(sc.next());
       }
       sc.close();
       bankCustomer = list;
   } catch(Exception exc){
       System.err.print(exc);
   }
          return bankCustomer;
}

    */
   //Funcion que recibe el nombre de un archivo, lo pasa a bankReader para
   //convertir el ArrayList a un HashTable
   public Hashtable<String, String> getTableOfNamesFromFile(String filename){
       //Recibe el ArrayList usando bankReader
       ArrayList<String> array = getLinesFromBankText(filename);
       Hashtable<String, String> table = new Hashtable<>();
       //Coloca el contenido del ArrayList
       for(int i=0;i<array.size();i++){
           String line = array.get(i);
           String name = extractNameFromLine(line);
           table.put(name, line);
       }
       return table;
   }

    private String extractNameFromLine(String line){
        String[] split = line.split(",", 4);
        return (split[1] + split[2]);
    }
   /*
   ANTES
   public Hashtable<String, String> bankHashReader(String filename){
       int i;
       //Recibe el ArrayList usando bankReader
       ArrayList<String> array = getLinesFromBankText(filename);
       Hashtable<String, String> table = new Hashtable<>();
       String[] split;
       String line;
       String key;
       //Coloca el contenido del ArrayList
       for(i=0;i<array.size();i++){
           line = array.get(i);
           split = line.split(",", 4);
           //Key es el FirstName + LastName
           key = split[1] + split[2];
           table.put(key, line);
       }
       return table;
   }*/
}
