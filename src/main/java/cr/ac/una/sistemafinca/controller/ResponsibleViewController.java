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
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
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
public class ResponsibleViewController {

    @FXML
    private TableView<Responsible> responsiblesList;
    @FXML
    private TableColumn<Responsible, String> idColumn;
    @FXML
    private TableColumn<Responsible, String> nameColumn;
    @FXML
    private TableColumn<Responsible, String> emailColumn;
    @FXML
    private TableColumn<Responsible, String> phoneColumn;
    @FXML
    private TableColumn<Responsible, String> typeColumn;
    @FXML
    private TableColumn<Responsible, Producer> landColumn;
    @FXML
    private TableColumn<Responsible, AgriculturalTechnician> specialtyColumn;
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
    private ComboBox<AgriculturalTechnician> newSpecialty;
    @FXML
    private Button updateButton;
    @FXML
    private Button backButton;
    
    public void initialize(){
        newSpecialty.getItems().setAll(AgriculturalTechnician.values());
        idColumn.setCellValueFactory(new PropertyValueFactory<>("identification"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("responsibleName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("responsibleType"));
        landColumn.setCellValueFactory(new PropertyValueFactory<>("landNameAsociation"));
        specialtyColumn.setCellValueFactory(new PropertyValueFactory<>("technicalSpeciality"));
        fillTable();
    }
    
    private void cleanFields(){
        newId.clear();
        newName.clear();
        newEmail.clear();
        newNumber.clear();
        newType.clear();
        newAsociation.clear();
        newSpecialty.getSelectionModel().clearSelection();
    }
    
    private void fillTable(){
        ResponsibleDAO resDao = new ResponsibleDAO();
        List<Responsible> responsibles = resDao.getAllResponsibles();
        responsiblesList.getItems().setAll(responsibles);
    }

    @FXML
    private void showResponsibles(ActionEvent event) {
        fillTable();
    }

    @FXML
    private void findResponsiblesById(ActionEvent event) {
        String id = newId.getText().trim();
        if(id.isEmpty()){
            System.out.println("Error, digite un ID para realizar la busqueda.");
            return;
        }
        ResponsibleDAO resDao = new ResponsibleDAO();
        Responsible foundRes = resDao.findResponsibleById(id);
        responsiblesList.getItems().clear();
        if(foundRes != null){
            responsiblesList.getItems().add(foundRes);
        }else{
            System.out.println("No existe un responsable con ese ID");
        }
    }

    @FXML
    private void deleteResponsibles(ActionEvent event) {
        Responsible resSelected = responsiblesList.getSelectionModel().getSelectedItem();
        if(resSelected==null){
            System.out.println("Por favor seleccione un responsable de la tabla para eliminar.");
            return;
        }
        ResponsibleDAO resDao = new ResponsibleDAO();
        boolean success = resDao.deleteResponsible(resSelected);
        if(success){
            responsiblesList.getItems().remove(resSelected);
            System.out.println("Responsable eliminado correctamente");
            cleanFields();
        }
    }

    @FXML
    private void updateResponsibles(ActionEvent event) {
        String id = newId.getText().trim();
        String name = newName.getText().trim();
        String email = newEmail.getText().trim();
        String number = newNumber.getText().trim();
        String type = newType.getText().trim();
        String asociation = newAsociation.getText().trim();
        AgriculturalTechnician tech = newSpecialty.getSelectionModel().getSelectedItem();
        if(id.isEmpty() || name.isEmpty() || email.isEmpty() || number.isEmpty() || type.isEmpty() || asociation.isEmpty() || tech==null){
            System.out.println("Error, no deje espacios en blanco ni opciones sin seleccionar.");
            return;
        }
        try{
            ProducerDAO prodDao = new ProducerDAO();
            Producer producer = prodDao.findProducerByCode(asociation);
            Responsible responsible = new Responsible(id,name,email,number,type,producer,tech);
            ResponsibleDAO resDao = new ResponsibleDAO();
            if(resDao.updateResponsible(responsible)){
                System.out.println("Responsable actualizado correctamente.");
                cleanFields();
                fillTable();
            }
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }

    @FXML
    private void switchToResponsibleWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/sistemafinca/Views/responsible.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Styles/style.css").toExternalForm());
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage currentWindow = (Stage) source.getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }
    
}
