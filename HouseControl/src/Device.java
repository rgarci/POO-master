/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author edgar.cambranes
 */
public class Device {
    
    private String IDDevice;
    private String name;
    private String brand;
    private String model;
    private boolean status;
    
    public Device(String IDDevice, String name, String brand, String model, boolean status){
        this.IDDevice = IDDevice;
        this.name = name;
        this.brand =  brand;
        this.model = model;
        this.status = status;
    }
    

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return this.model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the status
     */
    public boolean getStatus() {
        return this.status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }


    //Self encapsulate field


    public String toString(){
        return this.getName()+" "+this.getBrand()+" "+this.getModel() +" " +this.getStatus();
    }

    public boolean equals(Device device){
        Boolean eqName = this.getName() == device.getName();
        Boolean eqBrand = this.getBrand() == device.getBrand();
        Boolean eqModel =  this.getModel() == device.getModel();
        return eqName && eqBrand && eqModel;
    }

    public boolean toggleDevice(){
        this.status = !(this.status);
        return status;
    }

    public boolean switchOffDevice(){
        status = false;
        return status;
    }


    public boolean switchOnDevice(){
        status = true;
        return status;
    }
    
}
