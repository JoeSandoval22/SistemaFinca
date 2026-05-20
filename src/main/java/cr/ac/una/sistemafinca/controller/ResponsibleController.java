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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class ResponsibleController {

    @FXML
    private ComboBox<?> specialtyBox;
    @FXML
    private TextField idField;
    @FXML
    private TextField nameResField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField numberField;
    @FXML
    private TextField typeResField;
    @FXML
    private TextField asociationField;
    @FXML
    private Button responsibleButton;
    @FXML
    private TextField producerField;
    @FXML
    private TextField producerNameField;
    @FXML
    private Button producerbutton;
    @FXML
    private Button viewButton;
    @FXML
    private Button backButton;

    @FXML
    private void addResponsible(ActionEvent event) {
    }

    @FXML
    private void addProducer(ActionEvent event) {
    }

    @FXML
    private void swichtToViewResponsibles(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/sistemafinca/Views/responsibleView.fxml"));
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage currentWindow = (Stage) source.getScene().getWindow();
        currentWindow.setScene(new Scene(root));
        currentWindow.show();
    }

    @FXML
    private void switchToMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/sistemafinca/Views/agriculturalManager.fxml"));
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage currentWindow = (Stage) source.getScene().getWindow();
        currentWindow.setScene(new Scene(root));
        currentWindow.show();
    }
    
}
