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
    EN_PRODUCCION("EN_PRODUCCION"),
    EN_DESCANSO("EN_DESCANSO");
    
    private final String soilState;
    
    private SoilState(String state){
        this.soilState=state;
    }
    public String getSoilState(){
        return this.soilState;
    }
}
