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
public class PerennialController {

    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField daysField;
    @FXML
    private TableView<?> annualCropsList;
    @FXML
    private TableColumn<?, ?> idColumn;
    @FXML
    private TableColumn<?, ?> nameColumn;
    @FXML
    private TableColumn<?, ?> varietyColumn;
    @FXML
    private TableColumn<?, ?> dateColumn;
    @FXML
    private TableColumn<?, ?> typeColumn;
    @FXML
    private TableColumn<?, ?> daysColumn;
    @FXML
    private TableColumn<?, ?> descriptionColumn;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button showButton;
    @FXML
    private Button findButton;
    @FXML
    private Button backButton;

    @FXML
    private void addAnnualCrop(ActionEvent event) {
    }

    @FXML
    private void deleteCrops(ActionEvent event) {
    }

    @FXML
    private void updateCrops(ActionEvent event) {
    }

    @FXML
    private void showAnnualCrops(ActionEvent event) {
    }

    @FXML
    private void findAnnualCrop(ActionEvent event) {
    }

    @FXML
    private void swichtToCropsWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/sistemafinca/Views/cropView.fxml"));
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage currentWindow = (Stage) source.getScene().getWindow();
        currentWindow.setScene(new Scene(root));
        currentWindow.show();
    }
    
}
