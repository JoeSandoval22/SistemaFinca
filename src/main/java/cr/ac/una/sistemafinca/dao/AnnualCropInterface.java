/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.sistemafinca.dao;

import cr.ac.una.sistemafinca.model.AnnualCrop;
import java.util.List;

/**
 *
 * @author User
 */
public interface AnnualCropInterface {
    boolean insertAnnualCrop(AnnualCrop annual);
    boolean updateAnnualCrop(AnnualCrop annual);
    boolean deleteAnnualCrop(AnnualCrop annual);
    List<AnnualCrop> getAllAnnualCrops();
    AnnualCrop findAnnualCropByCode(String code);
}
