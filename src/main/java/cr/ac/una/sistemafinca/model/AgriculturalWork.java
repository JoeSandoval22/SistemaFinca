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
public class AgriculturalWork {
    private String workCode;
    private Plot plotCode;
    private Crop cropCode;
    private Responsible responsibleId;
    private String dateCompletion;
    private String laborType;
    private String description;
    private BigDecimal estimatedCost;
    
    public AgriculturalWork(String code,Plot plotCode,Crop cropCode,Responsible responsibleId,String dateCompletion,String laborType,String description,BigDecimal cost){
        this.workCode=code;
        this.plotCode=plotCode;
        this.cropCode=cropCode;
        this.responsibleId=responsibleId;
        this.dateCompletion=dateCompletion;
        this.laborType=laborType;
        this.description=description;
        this.estimatedCost=cost;
    }
    
    //Setters
    public void setWorkCode(String code){
        this.workCode=code;
    }
    public void setPlotCode(Plot code){
        this.plotCode=code;
    }
    public void setCropCode(Crop code){
        this.cropCode=code;
    }
    public void setResponsibleId(Responsible id){
        this.responsibleId=id;
    }
    public void setDateCompletion(String date){
        this.dateCompletion=date;
    }
    public void setLaborType(String type){
        this.laborType=type;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setEstimatedCost(BigDecimal cost){
        this.estimatedCost=cost;
    }
    //Getters
    public String getWorkCode(){
        return this.workCode;
    }
    public Plot getPlotCode(){
        return this.plotCode;
    }
    public Crop getCropCode(){
        return this.cropCode;
    }
    public Responsible getResponsibleId(){
        return this.responsibleId;
    }
    public String getDateCompletion(){
        return this.dateCompletion;
    }
    public String getLaborType(){
        return this.laborType;
    }
    public String getDescription(){
        return this.description;
    }
    public BigDecimal getEstimatedCost(){
        return this.estimatedCost;
    }
}
