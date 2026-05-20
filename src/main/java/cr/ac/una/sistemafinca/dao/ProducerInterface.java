/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.sistemafinca.dao;

import cr.ac.una.sistemafinca.model.Producer;
import java.util.List;

/**
 *
 * @author User
 */
public interface ProducerInterface {
    boolean insertProducer(Producer prod);
    boolean updateProducer(Producer prod);
    boolean deleteProducer(Producer prod);
    List<Producer> getAllProducers();
    Producer findProducerByCode(String code);
}
