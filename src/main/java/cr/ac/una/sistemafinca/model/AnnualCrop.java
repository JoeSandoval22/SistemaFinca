/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.model;

/**
 *
 * @author User
 */
public class AnnualCrop extends Crop {
    private int daysDuration;
    
    public AnnualCrop(String code, String name, String variety, String plantationDate,String cropType,int daysDuration) {
        super(code, name, variety, plantationDate,cropType);
        this.daysDuration=daysDuration;
    }

    @Override
    public String getDescription() {
        return "Cultivo anual con ciclo aproximado de "+daysDuration+ " dias.";
    }
    //Setters
    public void setDaysDuration(int duration){
        this.daysDuration=duration;
    }
    //Getters
    public int getDaysDuration(){
        return this.daysDuration;
    }
}
