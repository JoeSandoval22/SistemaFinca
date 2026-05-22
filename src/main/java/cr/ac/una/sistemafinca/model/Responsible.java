/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.model;

/**
 *
 * @author User
 */
public class Responsible {
    private String identification;
    private String responsibleName;
    private String email;
    private String phoneNumber;
    private String responsibleType;
    private Producer landNameAsociation;
    private AgriculturalTechnician technicalSpeciality;
    
    public Responsible(String identification,String responsibleName,String email,String phoneNumber,String responsibleType,Producer landNameAsociation,AgriculturalTechnician technicalSpeciality){
        this.identification=identification;
        this.responsibleName=responsibleName;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.responsibleType=responsibleType;
        this.landNameAsociation=landNameAsociation;
        this.technicalSpeciality=technicalSpeciality;
    }
    
    public Responsible(){
        
    }
    
    //Setters
    public void setIdentification(String id){
        this.identification=id;
    }
    public void setResponsibleName(String name){
        this.responsibleName=name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPhoneNumber(String number){
        this.phoneNumber=number;
    }
    public void setResponsibleType(String type){
        this.responsibleType=type;
    }
    public void setLandNameAsociation(Producer asociation){
        this.landNameAsociation=asociation;
    }
    public void setTechnicalSpeciality(AgriculturalTechnician speciality){
        this.technicalSpeciality=speciality;
    }
    //Getters
    public String getIdentification(){
        return this.identification;
    }
    public String getResponsibleName(){
        return this.responsibleName;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getResponsibleType(){
        return this.responsibleType;
    }
    public Producer getLandNameAsociation(){
        return this.landNameAsociation;
    }
    public AgriculturalTechnician getTechnicalSpeciality(){
        return this.technicalSpeciality;
    }
    @Override 
    public String toString(){
        return identification;
    }
}
