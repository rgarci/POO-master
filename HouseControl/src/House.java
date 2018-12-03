
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
public class House {
    /*private final int MAXLEVELS = 5;
    private int levelCounter;
    private Level levels[];*/
    private ArrayList<Level> levels;
    private String name;
    


    public House (ArrayList<Level> levels, String name){
        this.levels = levels;
        this.name = name;
       
    }
    
    public House ( String name){
        this.levels = new ArrayList<Level>();
        this.name = name;
        
        
    }
    
    public void addLevel (Level level){
        levels.add(level);
    }
    
    public int getLevelCounter(ArrayList<Level> levels){
        return levels.size();
    }

    public int searchLevel(String name){
        for(int index=0; index<levels.size(); index++){
            if(levels.get(index).equals(new Level(name))){
                return index;
            }
        }
        throw new FindingLevelException();
    }

    public int countDevicesOn(){
        int devicesOn=0;
        for(int i=0;i<levels.size(); i++){
            devicesOn+=levels.get(i).levelCountDevicesOn();
        }
        return devicesOn;
    }

    public int countSpecificDevice(String name){
        int counter=0;
        for(int i=0;i<levels.size(); i++){
            counter += levels.get(i).levelCountSpecificDevice(name);
        }
        return counter;
    }

    public void toogleSpecificDeviceLevel(String level,String device){
        for(int i=0;i<levels.size(); i++){
            if(levels.get(i).equalsName(level)){
                levels.get(i).tooogleSpecificDevice(device);
            }
        }
    }
    public String toString(){
            String output = "";
            output=output+name +"\n";
            for(int i=0;i<levels.size();i++){
                output = output+levels.get(i).toString()+"\n";
            }
            return output;
    }

    private class FindingLevelException extends RuntimeException {
        public FindingLevelException() {
            System.out.println("Nivel no encontrado");
        }
    }
}

