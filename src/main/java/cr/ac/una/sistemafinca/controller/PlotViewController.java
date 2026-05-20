/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.controller;

import cr.ac.una.sistemafinca.dao.PlotDAO;
import cr.ac.una.sistemafinca.model.Plot;
import cr.ac.una.sistemafinca.model.SoilState;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class PlotViewController {

    @FXML
    private TableView<Plot> plotsList;
    @FXML
    private TableColumn<Plot, String> codeColumn;
    @FXML
    private TableColumn<Plot, String> nameColumn;
    @FXML
    private TableColumn<Plot, String> locationColumn;
    @FXML
    private TableColumn<Plot, BigDecimal> areaColumn;
    @FXML
    private TableColumn<Plot, String> soilColum;
    @FXML
    private TableColumn<Plot, SoilState> stateColumn;
    @FXML
    private Button showButton;
    @FXML
    private Button findbutton;
    @FXML
    private Button deleteButton;
    @FXML
    private TextField newCode;
    @FXML
    private TextField newName;
    @FXML
    private TextField newLocation;
    @FXML
    private TextField newArea;
    @FXML
    private TextField newSoilType;
    @FXML
    private Button updateButton;
    @FXML
    private ComboBox<SoilState> newStateCombo;
    @FXML
    private Button backButton;
    
    public void initialize(){
        newStateCombo.getItems().setAll(SoilState.values());
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("plotCode"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("plotName"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        areaColumn.setCellValueFactory(new PropertyValueFactory<>("plotArea"));
        soilColum.setCellValueFactory(new PropertyValueFactory<>("soilType"));
        stateColumn.setCellValueFactory(new PropertyValueFactory<>("soilState"));
        fillTable();
        
    }
    
    private void fillTable(){
        PlotDAO plotDao = new PlotDAO();
        List<Plot> plots = plotDao.getAllPlots();
        plotsList.getItems().setAll(plots);
    }

    @FXML
    private void showPlots(ActionEvent event) {
        fillTable();
    }

    @FXML
    private void showPlotById(ActionEvent event) {
        String code = newCode.getText().trim();
        if(code.isEmpty()){
            System.out.println("Error, digite un codigo para poder realizar la busqueda.");
            return;
        }
        PlotDAO plotDao = new PlotDAO();
        Plot foundPlot = plotDao.findPlotByCode(code);
        plotsList.getItems().clear();
        if(foundPlot != null){
            plotsList.getItems().add(foundPlot);
        } else{
            System.out.println("No existe una parcela con ese codigo.");
        }
    }

    @FXML
    private void deletePlots(ActionEvent event) {
        Plot selectedPlot = plotsList.getSelectionModel().getSelectedItem();
        if(selectedPlot==null){
            System.out.println("Por favor seleccione una parcela de la tabla para eliminar.");
            return;
        }
        PlotDAO plotDao = new PlotDAO();
        boolean success = plotDao.deletePlot(selectedPlot);
        if(success){
            plotsList.getItems().remove(selectedPlot);
            System.out.println("Parcela eliminada correctamente");
            cleanFields();
        }
    }

    @FXML
    private void updatePlots(ActionEvent event) {
        String code = newCode.getText().trim();
        String name = newName.getText().trim();
        String location = newLocation.getText().trim();
        String area = newArea.getText().trim();
        String type = newSoilType.getText().trim();
        SoilState change = newStateCombo.getSelectionModel().getSelectedItem();
        if(code.isEmpty() || name.isEmpty() || location.isEmpty() || area.isEmpty() || type.isEmpty() || change == null){
            System.out.println("Error, no deje espacios en blanco ni opciones sin seleccionar.");
        }
        try{
            BigDecimal bigArea = new BigDecimal(area.replace(',', '.'));
            Plot plot = new Plot(code,name,location,bigArea,type,change);
            PlotDAO plotDao = new PlotDAO();
            if(plotDao.updatePlot(plot)){
                System.out.println("Registro actualizado correctamente.");
                cleanFields();
                fillTable();
            }
        } catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }

    @FXML
    private void switchToPlot(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/sistemafinca/Views/plot.fxml"));
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage currentWindow = (Stage) source.getScene().getWindow();
        currentWindow.setScene(new Scene(root));
        currentWindow.show();
    }
    
    private void cleanFields(){
        newCode.clear();
        newName.clear();
        newLocation.clear();
        newArea.clear();
        newSoilType.clear();
        newStateCombo.getSelectionModel().clearSelection();
    }
    
}
