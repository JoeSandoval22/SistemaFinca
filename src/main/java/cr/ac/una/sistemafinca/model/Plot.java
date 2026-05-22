/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.model;

import java.math.BigDecimal;

/**
 *
 * @author User
 */
public class Plot {
    private String plotCode;
    private String plotName;
    private String plotLocation;
    private BigDecimal plotArea;
    private String soilType;
    private SoilState soilState;
    
    public Plot(String plotCode,String plotName,String plotLocation,BigDecimal plotArea,String soilType,SoilState soilState){
        this.plotCode=plotCode;
        this.plotName=plotName;
        this.plotLocation=plotLocation;
        this.plotArea=plotArea;
        this.soilType=soilType;
        this.soilState=soilState;
    }
    
    public Plot(){
        
    }
    
    //Setters
    public void setPlotCode(String code){
        this.plotCode=code;
    }
    public void setPlotName(String name){
        this.plotName=name;
    }
    public void setPlotLocation(String location){
        this.plotLocation=location;
    }
    public void setPlotArea(BigDecimal area){
        this.plotArea=area;
    }
    public void setSoilType(String type){
        this.soilType=type;
    }
    public void setSoilState(SoilState state){
        this.soilState=state;
    }
    //Getters
    public String getPlotCode(){
        return this.plotCode;
    }
    public String getPlotName(){
        return this.plotName;
    }
    public String getLocation(){
        return this.plotLocation;
    }
    public BigDecimal getPlotArea(){
        return this.plotArea;
    }
    public String getSoilType(){
        return this.soilType;
    }
    public SoilState getSoilState(){
        return this.soilState;
    }
    @Override
    public String toString(){
        return plotCode;
    }
}
