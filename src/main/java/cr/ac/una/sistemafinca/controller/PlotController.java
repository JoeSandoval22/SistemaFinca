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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class PlotController {

    @FXML
    private ComboBox<SoilState> soilStateBox;
    @FXML
    private TextField codeField;
    @FXML
    private TextField plotField;
    @FXML
    private TextField locationField;
    @FXML
    private TextField soilField;
    @FXML
    private TextField areaField;
    @FXML
    private Button plotButton;
    @FXML
    private Button backButton;
    @FXML
    private Button viewButton;
    
    public void initialize(){
        soilStateBox.getItems().setAll(SoilState.values());
         
    }

    @FXML
    private void addPlot(ActionEvent event) {
        String code = codeField.getText().trim();
        String plotName = plotField.getText().trim();
        String location = locationField.getText().trim();
        String areaText = areaField.getText().trim();
        String type = soilField.getText().trim();
        SoilState change = soilStateBox.getSelectionModel().getSelectedItem();
        if(code.isEmpty() || plotName.isEmpty() ||location.isEmpty() || areaText.isEmpty() || type.isEmpty() || change == null){
            System.out.println("Error, no deje espacios en blancos ni opciones sin seleccionar. ");
        }
        try{
            BigDecimal area = new BigDecimal(areaText.replace(',', '.')); 
            Plot plot = new Plot(code,plotName,location,area,type,change);
            PlotDAO plotDao = new PlotDAO();
            if(plotDao.insertPlot(plot)){
                System.out.println("Parcela agregada correctamente.");
            }
        } catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }

    @FXML
    private void switchToMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/sistemafinca/Views/agriculturalManager.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Styles/style.css").toExternalForm());
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage currentWindow = (Stage) source.getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }

    @FXML
    private void switchToPlotView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/sistemafinca/Views/plotView.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Styles/style.css").toExternalForm());
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage currentWindow = (Stage) source.getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }
    
}
