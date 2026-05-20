/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.sistemafinca.dao;

import cr.ac.una.sistemafinca.model.AgriculturalWork;
import java.util.List;

/**
 *
 * @author User
 */
public interface AgriculturalWorkInterface {
    boolean insertWork(AgriculturalWork work);
    boolean updateWork(AgriculturalWork work);
    boolean deleteWork(AgriculturalWork work);
    List<AgriculturalWork> getAllWorks();
    AgriculturalWork findWorkByCode(String code); 
}
