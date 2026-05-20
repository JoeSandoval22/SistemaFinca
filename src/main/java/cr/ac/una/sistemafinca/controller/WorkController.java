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
public class WorkController {

    @FXML
    private TextField workCodeField;
    @FXML
    private TextField plotCodeField;
    @FXML
    private TextField cropCodeField;
    @FXML
    private TextField resIdField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField costField;
    @FXML
    private TableView<?> worksList;
    @FXML
    private TableColumn<?, ?> workCodeColumn;
    @FXML
    private TableColumn<?, ?> plotCodeColumn;
    @FXML
    private TableColumn<?, ?> cropCodeColumn;
    @FXML
    private TableColumn<?, ?> responsibleColumn;
    @FXML
    private TableColumn<?, ?> dateColumn;
    @FXML
    private TableColumn<?, ?> typeColumn;
    @FXML
    private TableColumn<?, ?> descriptionColumn;
    @FXML
    private TableColumn<?, ?> costColumn;
    @FXML
    private Button addButton;
    @FXML
    private Button updateWork;
    @FXML
    private Button deleteButton;
    @FXML
    private Button findButton;
    @FXML
    private TextField idField;
    @FXML
    private Button showButton;
    @FXML
    private Button backButton;

    @FXML
    private void addWorks(ActionEvent event) {
    }

    @FXML
    private void updateWorks(ActionEvent event) {
    }

    @FXML
    private void deleteWorks(ActionEvent event) {
    }

    @FXML
    private void findWorks(ActionEvent event) {
    }

    @FXML
    private void showWorks(ActionEvent event) {
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
