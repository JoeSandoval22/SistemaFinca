/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.controller;

import java.io.IOException;
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
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class PlotViewController {

    @FXML
    private TableView<?> plotsList;
    @FXML
    private TableColumn<?, ?> codeColumn;
    @FXML
    private TableColumn<?, ?> nameColumn;
    @FXML
    private TableColumn<?, ?> locationColumn;
    @FXML
    private TableColumn<?, ?> areaColumn;
    @FXML
    private TableColumn<?, ?> soilColum;
    @FXML
    private TableColumn<?, ?> stateColumn;
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
    private ComboBox<?> newStateCombo;
    @FXML
    private Button backButton;

    @FXML
    private void showPlots(ActionEvent event) {
    }

    @FXML
    private void showPlotById(ActionEvent event) {
    }

    @FXML
    private void deletePlots(ActionEvent event) {
    }

    @FXML
    private void updatePlots(ActionEvent event) {
    }

    @FXML
    private void switchToPlot(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/sistemafinca/Views/plot.fxml"));
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage currentWindow = (Stage) source.getScene().getWindow();
        currentWindow.setScene(new Scene(root));
        currentWindow.show();
    }
    
}
