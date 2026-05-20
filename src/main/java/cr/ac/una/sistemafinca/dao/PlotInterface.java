/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.sistemafinca.dao;

import cr.ac.una.sistemafinca.model.Plot;
import java.util.List;

/**
 *
 * @author User
 */
public interface PlotInterface {
    boolean insertPlot(Plot plot);
    boolean updatePlot(Plot plot);
    boolean deletePlot(Plot plot);
    List<Plot> getAllPlots();
    Plot findPlotByCode(String code);
}
