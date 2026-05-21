/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.model;

/**
 *
 * @author User
 */
public enum AgriculturalTechnician {
    FITOTECNIA("FITOTECNIA"),
    FERTILIZACION("FERTILIZACION"),
    RIEGO("RIEGO"),
    LIMPIEZA("LIMPIEZA"),
    CONTROL_PLAGAS("CONTROL_PLAGAS"),
    NOAPLICA("NO_APLICA");
    
    private String specialty;
    
    private AgriculturalTechnician(String specialty){
        this.specialty=specialty;
    }
    
    public String getSpecialty(){
        return this.specialty;
    }
    
    @Override
    public String toString(){
        return specialty;
    }
}
