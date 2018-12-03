
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
public class Level {
    /*private int MAXROOMS = 5;
    private int roomCounter;
    private Room rooms[];*/
    private String name;
    private String IDLevel;
    private ArrayList<Room> rooms;

    //Contructor dos parametros
    public Level(String IDLevel, String name, ArrayList<Room> rooms) {
        this.IDLevel = IDLevel;
        this.name = name;
        this.rooms = rooms;
    }

    //Constructor un parámetro
    public Level(String name) {
        this.name = name;
        this.rooms = new ArrayList<Room>();
    }

    public int getCounterRooms(ArrayList<Room> rooms) {
        return rooms.size();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }


    /**
     * @return the roomCounter
     */
    public int getRoomCounter() {
        return rooms.size();
    }


    /**
     * @return the rooms
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     * @param rooms the rooms to set
     */
    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
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

    public int searchRoom(Room otherRoom){
        for (int index = 0; index < rooms.size(); index++) {
            if (rooms.get(index).equals(otherRoom)) {
                return index;
            }
        }
        throw new FindingRoomException();
    }

    public void RemoveRoom(Room room) {
        try {
            int pos = searchRoom(room);
            rooms.remove(pos);
        } catch (FindingRoomException e) {
            System.out.println("la habitación no se pudo remover");
        }
    }

    public String toString() {
        String output = "";
        output = output + name + "\n";
        for (int i = 0; i < rooms.size(); i++) {
            output = output + rooms.get(i).toString() + "\n";
        }
        return output;
    }

    public void switchAllOffRooms() {
        for (int index = 0; index < getRoomCounter(); index++) {
            rooms.get(index).switchOffAllDevices();
        }
    }

    public void switchAllOnRooms() {
        for (int index = 0; index < getRoomCounter(); index++) {
            rooms.get(index).switchOnAllDevices();
        }
    }

    public void switchOnRoom(Room room) {
        try {
            int index = this.searchRoom(room);
            rooms.get(index).switchOnAllDevices();
        } catch (FindingRoomException e) {
            System.out.println("no se pudo prender");
        }
    }

    public void switchOffRoom(Room room){
        try {
            int index = this.searchRoom(room);
            rooms.get(index).switchOffAllDevices();
        } catch (FindingRoomException e) {
            System.out.println("no se pudo apagar ");
        }
    }

    public void levelSwitchOffDeviceRoom(Room room, Device device){
        try {
            Device d = levelSearchDeviceOnRoom(room,device);
            d.switchOffDevice();
        } catch (FindingRoomException | Room.FindingDeviceException e) {
            System.out.println("dispositivos no apagados");
        }
    }

    public Device levelSearchDeviceOnRoom (Room room, Device device){
        int lRoom = this.searchRoom(room);
        ArrayList<Device> d;
        d = rooms.get(lRoom).getDevices();
        int lDevice = rooms.get(lRoom).searchDevice(device);
        return d.get(lDevice);
    }

    public void levelSwitchOnDeviceRoom(Room room, Device device){
        try {
            Device d = levelSearchDeviceOnRoom(room,device);
            d.switchOnDevice();
        } catch (FindingRoomException | Room.FindingDeviceException e) {
            System.out.println("dispositivos no encendidos");
        }
    }

    public void switchAllOffSameDevices(String nameDevices){//Nuevo
        for(int i=0; i<rooms.size(); i++){
            ArrayList<Device> devices = rooms.get(i).getDevices();
            for(int j=0; j<devices.size(); j++){
                String name =devices.get(j).getName();
                if(name.equals(nameDevices)){
                    devices.get(j).switchOffDevice();
                }
            }
        }
    }

    public void tooogleSpecificDevice(String nameDevices){
        for(int i=0; i<rooms.size(); i++){
            ArrayList<Device> devices = rooms.get(i).getDevices();
            for(int j=0; j<devices.size(); j++){
                String name =devices.get(j).getName();
                if(name.equals(nameDevices)){
                    devices.get(j).toggleDevice();
                }
            }
        }
    }

    public int levelCountSpecificDevice(String nameDevices){
        int counter = 0;
        for(int i=0; i<rooms.size(); i++){
            ArrayList<Device> devices = rooms.get(i).getDevices();
            for(int j=0; j<devices.size(); j++){
                String name =devices.get(j).getName();
                if(name.equals(nameDevices)){
                    counter++;
                }
            }
        }
        return counter;
    }

    public int levelCountDevicesOn(){
        int count = 0;
        for(int i=0; i<rooms.size(); i++){
            ArrayList<Device> devices = rooms.get(i).getDevices();
            for(int j=0; j<devices.size(); j++){
                if(devices.get(j).getStatus()){
                    count++;
                }
            }
        }
        return count;
    }


    public boolean equalsName(String nameLevel){
        return  this.getName() == nameLevel;
    }

    private class FindingRoomException extends RuntimeException{
        public FindingRoomException() {
            System.out.println("Habitación no encontrada");
        }
    }

}
