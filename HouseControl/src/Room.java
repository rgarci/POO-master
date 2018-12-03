
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
public class Room {
    /*private final int MAXDEVICES = 20;
    private int deviceCounter;
    private Device devices[];*/
    private ArrayList<Device> devices;
    private String IDRoom;
    private String name;
    
    
    
    public Room(String IDRoom, String name, ArrayList<Device> devices){
        this.IDRoom = IDRoom;
        this.name = name;
        this.devices = devices;
        }
    
    public Room(String name){
        this.devices = new ArrayList<Device>();
        this.name = name;
        
    }
    
    public void addDevice(Device device){

        devices.add(device);
    }

    /**
     * @return the devices
     */
    public ArrayList<Device> getDevices() {
        return devices;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        String output = "";
        output=output+name +"\n";
        for(int i=0;i<this.devices.size();i++){
            output = output+devices.get(i).toString()+"\n";
        }
        return output;
    }
/**
     * @return the deviceCounter
     */
    public int getDeviceCounter() {
        return devices.size();
    }



    public int searchDevice(Device otherDevice) throws FindingDeviceException {

        for(int index=0; index<getDeviceCounter(); index++){
            if(devices.get(index).equals(otherDevice)){
                return index;
            }
        }
       throw new  FindingDeviceException();
    }

    public void removeDevice(Device device){
        try {
            int pos = searchDevice(device);
            devices.remove(pos);
        } catch (FindingDeviceException e) {
            System.out.println("el dispositivo no se pudo remover");
        }
    }


    public void switchOffAllDevices(){
        for(int index=0; index<getDeviceCounter(); index++){
            devices.get(index).switchOffDevice();
        }
    }

    
    public void switchOnAllDevices(){
        for(int index=0; index<getDeviceCounter(); index++){
            devices.get(index).switchOnDevice();
        }
    }


    public boolean equalsName(String nameRoom){
        return this.getName() == nameRoom;
    }

    public class FindingDeviceException extends Throwable {
        public FindingDeviceException() {
            System.out.println("Dispositivo no encontrado en la habitanción");
        }
    }
}

