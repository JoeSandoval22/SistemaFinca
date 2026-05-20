/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package cr.ac.una.sistemafinca.model;

/**
 *
 * @author User
 */
public enum SoilState {
    DISPONIBLE("DISPONIBLE"),
    ENPRODUCCION("EN PRODUCCION"),
    ENDESCANSO("EN DESCANSO");
    
    private final String soilState;
    
    private SoilState(String state){
        this.soilState=state;
    }
    public String getSoilState(){
        return this.soilState;
    }
}
