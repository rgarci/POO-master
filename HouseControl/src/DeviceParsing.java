
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author edgar.cambranes
 */
public class DeviceParsing {

    static final int POS_NAME = 1;
    static final int POS_BRAND = 2;
    static final int POS_MODEL = 3;
    static final int POS= 4;

    private ArrayList<Device> devices;
    private String content;

    public String getContent() {
        return content;
    }

    public DeviceParsing(){
        this.devices = new ArrayList<Device>();

    }

    public void readContent() throws FileReader.stringNulException {
        FileReader fr =new FileReader("HouseControl/Devices.txt");
        content = fr.getContentFile();
    }


    public String[] parsingContent(){
        String[] parsing= getContent().split(",");
        return parsing;
    }


    public void addDevices(){
        String[] parsing = parsingContent();
        for(int i = 0; i<parsing.length; i=i+POS){
            String id =parsing[i];
            String name =parsing[i+POS_NAME];
            String brand =parsing[i+POS_BRAND];
            String model =parsing[i+POS_MODEL];
            Device device =new Device(id,name ,brand ,model , true);
            devices.add(device);
        }
    }
    public static void main(String ar[]){
        DeviceParsing dp = new DeviceParsing();
        try {
            dp.readContent();
            dp.addDevices();
        } catch (FileReader.stringNulException e) {
            System.out.println("no se pudo leer");
        }
    
    }
    
}
