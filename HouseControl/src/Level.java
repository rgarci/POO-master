
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
public Level(String IDLevel, String name, ArrayList<Room> rooms){
        this.IDLevel = IDLevel;
        this.name = name;
        this.rooms = rooms;
    }

//Constructor un parámetro
public Level(String name){
        this.name = name;
        this.rooms =  new ArrayList<Room>();
    }

public int getCounterRooms(ArrayList<Room> rooms){
    /*int roomCounter = 0;
    for(int i = 0;i < rooms.length; i++){
        if(rooms[i] != null){
            roomCounter++;
        }
        else{
            break;
        }
    }*/
    return rooms.size();
}

public void addRoom(Room room){
    /*boolean flag = false;
    if(roomCounter<MAXROOMS){
        rooms[roomCounter] = room;
        roomCounter++;
        flag = true;
    }
    return flag;*/
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

    //searchRoom
    /*********************************************************************/
    public int searchRom(Room otherRoom){
            int index = 0;
            boolean  flag = false;
            for(index=0; index<rooms.size() && flag == false; index++){
                if(rooms.get(index).equals(otherRoom)){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                index = -1;
            }
            return index;
        }

    public int searchRoom(Room otherRoom) throws ErrorFindingRoomException {

        for(int index=0; index<rooms.size(); index++){
            if(rooms.get(index).equals(otherRoom)){
                return index;
            }
        }

        throw new  ErrorFindingRoomException();

    }


    //removeRoom
    /*********************************************************************/
    public boolean RemoveRom(Room room){
            boolean flag= false;
            int pos= searchRoom(room);

            if(pos != -1){
                   rooms.remove(pos);
            }

            return flag;
    }

    public void RemoveRoom(Room room) {
        int pos = 0;
        try {
            pos = searchRoom(room);
            rooms.remove(pos);
        } catch (ErrorFindingRoomException e) {
            System.out.println("la habitación no se pudo remover");
        }
    }

    /*********************************************************************/
    public String toString(){
        String output = "";
        output=output+name +"\n";
        for(int i=0;i<rooms.size();i++){
            output = output+rooms.get(i).toString()+"\n";
        }
        return output;
    }


    /*********************************************************************/
    public boolean switchAllOffRoms(){
        for(int index=0; index<getRoomCounter(); index++){
            rooms.get(index).switchOffAllDevices();
        }
        return true;
    }

    public void switchAllOffRooms(){
        for(int index=0; index<getRoomCounter(); index++){
            rooms.get(index).switchOffAllDevices();
        }
    }


    /*********************************************************************/
    public boolean switchAllOnRoms(){
        for(int index=0; index<getRoomCounter(); index++){
            rooms.get(index).switchOnAllDevices();
        }
        return true;
    }

    public void switchAllOnRooms(){
        for(int index=0; index<getRoomCounter(); index++){
            rooms.get(index).switchOnAllDevices();
        }
    }


    /*********************************************************************/
    public boolean switchOnRom(Room room){
        boolean flag=false;
        int index;
        index=this.searchRoom(room);
        if(index>-1){
            rooms.get(index).switchOnAllDevices();
            flag=true;
        }
        return flag;
    }

    public void switchOnRoom(Room room){
        try {
            int index = this.searchRoom(room);
            rooms.get(index).switchOnAllDevices();
        } catch (ErrorFindingRoomException e) {
            System.out.println("no se pudo prender");;
        }
    }


    /*********************************************************************/
    public boolean switchOffRom(Room room){
        boolean flag=false;
        int index;
        index=this.searchRoom(room);
        if(index>-1){
            rooms.get(index).switchOffAllDevices();
            flag=true;
        }
        return flag;
    }

    public void switchOffRoom(Room room){
        try {
            int index = this.searchRoom(room);
            rooms.get(index).switchOffAllDevices();
        } catch (ErrorFindingRoomException e) {
            System.out.println("no se pudo apagar ");
        }
    }

    /*********************************************************************/
    public boolean levelSwitchOffDevice(Room room, Device device){
       boolean found = false;
       int lRoom = this.searchRoom(room);
       if(lRoom > -1){
           ArrayList<Device> d;
            d = rooms.get(lRoom).getDevices();
            int lDevice = rooms.get(lRoom).searchDevice(device);
            
            if(lDevice > -1)
                d.get(lDevice).switchOffDevice();
            else
                found = true;
       }
       return found;
    }

    public void levelSwitchOffDeviceRoom(Room room, Device device){
        try {
           int lRoom = this.searchRoom(room);
            ArrayList<Device> d;
            d = rooms.get(lRoom).getDevices();
            int lDevice = rooms.get(lRoom).searchDevice(device);
            d.get(lDevice).switchOffDevice();
        } catch (ErrorFindingRoomException | Room.ErrorFindingDeviceException e) {

        }

    }

    /*********************************************************************/

    public Device levelSearchDeviceOnRoom (Room room, Device device){
        try {
            int lRoom = this.searchRoom(room);
            ArrayList<Device> d;
            d = rooms.get(lRoom).getDevices();
            int lDevice = rooms.get(lRoom).searchDevice(device);
            device=d.get(lDevice);
        } catch (ErrorFindingRoomException | Room.ErrorFindingDeviceException e) {

        }

    }

    /*************************************************************/
    public boolean levelSwitchOnDevice(Room room, Device device){
        boolean found = false;
        int lRoom = this.searchRoom(room);
        if(lRoom > -1){
            ArrayList<Device> d;
            d = rooms.get(lRoom).getDevices();
            int lDevice = rooms.get(lRoom).searchDevice(device);

            if(lDevice > -1)
                d.get(lDevice).switchOnDevice();
            else
                found = true;
        }
        return found;
    }

    public void levelSwitchOnDeviceRoom(Room room, Device device){
        try {
            int lRoom = this.searchRoom(room);
            ArrayList<Device> d;
            d = rooms.get(lRoom).getDevices();
            int lDevice = rooms.get(lRoom).searchDevice(device);
            d.get(lDevice).switchOnDevice();
        } catch (ErrorFindingRoomException | Room.ErrorFindingDeviceException e) {

        }

    }

    /*********************************************************************/
    public void switchAllOffSameDevices(String nameDevices){//Nuevo
      for(int i=0; i<rooms.size(); i++){
          ArrayList<Device> devices = rooms.get(i).getDevices();
          for(int j=0; j<rooms.get(i).getDeviceCounter(); j++){
              if(devices.get(j).getName().equals(nameDevices)){
                  devices.get(j).switchOffDevice();
              }
          }
      }          
  }


    /*********************************************************************/
    public boolean equals(Object obj){
        boolean flag = false;
        if(obj instanceof Level && obj!= null){
            Level otherDevice =(Level)obj;
            if(this.name == otherDevice.name){
                flag = true;
            }
        }
        return flag;
    }

    public boolean equalsName(String nameLevel){
        return  this.getName() == nameLevel;
    }


    private class ErrorFindingRoomException extends Throwable {
        public ErrorFindingRoomException() {
            System.out.println("Habitación no encontrada");
        }
    }

}
