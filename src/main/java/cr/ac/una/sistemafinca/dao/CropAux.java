/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.dao;

import cr.ac.una.sistemafinca.model.Crop;

/**
 *
 * @author User
 */
public class CropAux {
    AnnualCropDAO annual = new AnnualCropDAO();
    PerennialCropDAO perennial = new PerennialCropDAO();
    
    public CropAux(){
        
    }
    
    public Crop findCropByCode(String code){
        Crop crop = annual.findAnnualCropByCode(code);
        if(crop==null){
            crop = perennial.findPerennialCropByCode(code);
        }
        return crop;
    }
}
