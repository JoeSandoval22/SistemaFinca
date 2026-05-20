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
public class ResponsibleViewController {

    @FXML
    private TableView<?> responsiblesList;
    @FXML
    private TableColumn<?, ?> idColumn;
    @FXML
    private TableColumn<?, ?> nameColumn;
    @FXML
    private TableColumn<?, ?> emailColumn;
    @FXML
    private TableColumn<?, ?> phoneColumn;
    @FXML
    private TableColumn<?, ?> typeColumn;
    @FXML
    private TableColumn<?, ?> landColumn;
    @FXML
    private TableColumn<?, ?> specialtyColumn;
    @FXML
    private Button showButton;
    @FXML
    private Button findButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TextField newId;
    @FXML
    private TextField newName;
    @FXML
    private TextField newEmail;
    @FXML
    private TextField newNumber;
    @FXML
    private TextField newType;
    @FXML
    private TextField newAsociation;
    @FXML
    private ComboBox<?> newSpecialty;
    @FXML
    private Button updateButton;
    @FXML
    private Button backButton;

    @FXML
    private void showResponsibles(ActionEvent event) {
    }

    @FXML
    private void findResponsiblesById(ActionEvent event) {
    }

    @FXML
    private void deleteResponsibles(ActionEvent event) {
    }

    @FXML
    private void updateResponsibles(ActionEvent event) {
    }

    @FXML
    private void switchToResponsibleWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/sistemafinca/Views/responsible.fxml"));
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage currentWindow = (Stage) source.getScene().getWindow();
        currentWindow.setScene(new Scene(root));
        currentWindow.show();
    }
    
}
