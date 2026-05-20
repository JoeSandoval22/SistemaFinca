/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.sistemafinca.dao;

import cr.ac.una.sistemafinca.model.Responsible;
import java.util.List;

/**
 *
 * @author User
 */
public interface ResponsibleInterface {
    boolean insertResponsible(Responsible responsible);
    boolean updateResponsible(Responsible responsible);
    boolean deleteResponsible(Responsible responsible);
    List<Responsible> getAllResponsibles();
    Responsible findResponsibleById(String id);
}
