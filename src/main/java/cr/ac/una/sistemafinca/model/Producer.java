/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.model;

/**
 *
 * @author User
 */
public class Producer {
    private String producerId;
    private String producerLandName;
    
    public Producer(String producerId,String producerLandName){
        this.producerId=producerId;
        this.producerLandName=producerLandName;
    }
    
    public Producer(){
        
    }
    
    //Setters
    public void setProducerId(String id){
        this.producerId=id;
    }
    public void setProducerLandName(String land){
        this.producerLandName=land;
    }
    //Getters
    public String getProducerId(){
        return this.producerId;
    }
    public String getProducerLandName(){
        return this.producerLandName;
    }
    @Override
    public String toString(){
        return producerId;
    }
}
