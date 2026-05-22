/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.controller;

import cr.ac.una.sistemafinca.dao.ProducerDAO;
import cr.ac.una.sistemafinca.dao.ResponsibleDAO;
import cr.ac.una.sistemafinca.model.AgriculturalTechnician;
import cr.ac.una.sistemafinca.model.Producer;
import cr.ac.una.sistemafinca.model.Responsible;
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
    private ComboBox<AgriculturalTechnician> specialtyBox;
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
    private Button prodButton;
    
    public void initialize(){
        specialtyBox.getItems().setAll(AgriculturalTechnician.values());
    }
    
    private void cleanFields(){
        idField.clear();
        nameResField.clear();
        emailField.clear();
        numberField.clear();
        typeResField.clear();
        asociationField.clear();
        producerField.clear();
        producerNameField.clear();
    }

    @FXML
    private void addResponsible(ActionEvent event) {
        String id = idField.getText().trim();
        String name = nameResField.getText().trim();
        String email = emailField.getText().trim();
        String number = numberField.getText().trim();
        String type = typeResField.getText().trim();
        String asociation = asociationField.getText().trim();
        AgriculturalTechnician tech = specialtyBox.getSelectionModel().getSelectedItem();
        if(id.isEmpty() || name.isEmpty() || email.isEmpty() || number.isEmpty() || type.isEmpty() || asociation.isEmpty() || tech==null){
            System.out.println("Error, no deje espacios en blanco ni opciones sin seleccionar.");
            return;
        }
        try{
            ProducerDAO proDao = new ProducerDAO();
            Producer producer = proDao.findProducerByCode(asociation);
            Responsible responsible = new Responsible(id,name,email,number,type,producer,tech);
            ResponsibleDAO resDao = new ResponsibleDAO();
            if(resDao.insertResponsible(responsible)){
                System.out.println("Responsable agregado correctamente.");
                cleanFields();
            }
            
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }      
    }

    @FXML
    private void addProducer(ActionEvent event) {
        String producerCode = producerField.getText().trim();
        String producerName = producerNameField.getText().trim();
        if(producerCode.isEmpty() || producerName.isEmpty()){
            System.out.println("Error, no deje espacios en blanco.");
            return;
        }
        try{
            Producer producer = new Producer(producerCode,producerName);
            ProducerDAO proDao = new ProducerDAO();
            if(proDao.insertProducer(producer)){
                System.out.println("Productor agregado correctamente.");
                cleanFields();
            }
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }

    @FXML
    private void swichtToViewResponsibles(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/sistemafinca/Views/responsibleView.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Styles/style.css").toExternalForm());
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage currentWindow = (Stage) source.getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
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
    private void switchToProducersView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/sistemafinca/Views/producerView.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Styles/style.css").toExternalForm());
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage currentWindow = (Stage) source.getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }
    
}
