
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author edgar.cambranes
 */
public class FileReader {

    private Scanner file;

    public FileReader(String path){
        try {
            file = new Scanner(new File(path));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        
    }

    public String getContentFile() throws stringNulException {
        String content = "";
        while (file.hasNextLine()) {
            content+=file.nextLine()+",";
        }
        closeFile();
        if(!content.equals("")){ return content;}
        throw new stringNulException();
    }

    public void closeFile(){
        file.close();
    }

    public static void main(String ar[]){
        try {
            System.out.println(new FileReader("\\HouseControl\\Devices.txt").getContentFile());
        } catch (stringNulException e) {
            System.out.println("no existen elementos");
        }

    }

    public class stringNulException extends Throwable {
        public stringNulException(){
            System.out.println("La cadena esta vacia, no se encontraron elementos");
        }
    }
}
