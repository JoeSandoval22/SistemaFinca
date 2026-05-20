/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.sistemafinca.dao;

import cr.ac.una.sistemafinca.model.PerennialCrop;
import java.util.List;

/**
 *
 * @author User
 */
public interface PerennialCropInterface {
    boolean insertPerennialCrop(PerennialCrop perennial);
    boolean updatePerennialCrop(PerennialCrop perennial);
    boolean deletePerennialCrop(PerennialCrop perennial);
    List<PerennialCrop> getAllPerennialCrops();
    PerennialCrop findPerennialCropByCode(String code);
}
