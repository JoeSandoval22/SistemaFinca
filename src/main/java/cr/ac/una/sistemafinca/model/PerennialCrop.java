/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.model;

/**
 *
 * @author User
 */
public class PerennialCrop extends Crop {
    private int estimatedYears;
    
    public PerennialCrop(String code, String name, String variety, String plantationDate,String cropType, int estimatedYears) {
        super(code, name, variety, plantationDate,cropType);
        this.estimatedYears=estimatedYears;
    }

    @Override
    public String getDescription() {
        return "Cultivo perenne con produccion estimada de "+estimatedYears+" años";
    }
    //Setters
    public void setEstimatedYears(int years){
        this.estimatedYears=years;
    }
    //Getters
    public int getEstimatedYears(){
        return this.estimatedYears;
    }
}
