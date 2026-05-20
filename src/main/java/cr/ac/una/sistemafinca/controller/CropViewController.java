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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class CropViewController {

    @FXML
    private TableView<?> cropsList;
    @FXML
    private TableColumn<?, ?> codeColumn;
    @FXML
    private TableColumn<?, ?> varietyColumn;
    @FXML
    private TableColumn<?, ?> dateColumn;
    @FXML
    private TableColumn<?, ?> typeColumns;
    @FXML
    private Button showButton;
    @FXML
    private Button showIdButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button updateButton;
    @FXML
    private TextField newCode;
    @FXML
    private TextField newVariety;
    @FXML
    private TextField newDate;
    @FXML
    private TextField newType;
    @FXML
    private Button annualButton;
    @FXML
    private Button perennialButton;
    @FXML
    private Button backButton;

    @FXML
    private void showAllCrops(ActionEvent event) {
    }

    @FXML
    private void showCropByCode(ActionEvent event) {
    }

    @FXML
    private void deleteAnCrop(ActionEvent event) {
    }

    @FXML
    private void updateRegister(ActionEvent event) {
    }

    @FXML
    private void switchToAnnualWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/sistemafinca/Views/annualView.fxml"));
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage currentWindow = (Stage) source.getScene().getWindow();
        currentWindow.setScene(new Scene(root));
        currentWindow.show();
    }

    @FXML
    private void swichtToPerennialWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/sistemafinca/Views/perennialView.fxml"));
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage currentWindow = (Stage) source.getScene().getWindow();
        currentWindow.setScene(new Scene(root));
        currentWindow.show();
    }

    @FXML
    private void swichtToCropsWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/sistemafinca/Views/crop.fxml"));
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage currentWindow = (Stage) source.getScene().getWindow();
        currentWindow.setScene(new Scene(root));
        currentWindow.show();
    }
    
}
