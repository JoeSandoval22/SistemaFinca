/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.controller;

import cr.ac.una.sistemafinca.dao.ProducerDAO;
import cr.ac.una.sistemafinca.model.Producer;
import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class ProducerViewController {

    @FXML
    private TableView<Producer> producersList;
    @FXML
    private TableColumn<Producer, String> codeColumn;
    @FXML
    private TableColumn<Producer, String> nameColumn;
    @FXML
    private Button backButton;
    @FXML
    private Button showButton;
    @FXML
    private Button findButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TextField codeField;
    @FXML
    private TextField nameField;

    @FXML
    private void switchToResponsibleWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/sistemafinca/Views/responsible.fxml"));
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage currentWindow = (Stage) source.getScene().getWindow();
        currentWindow.setScene(new Scene(root));
        currentWindow.show();
    }
    
    public void initialize(){
        codeColumn.setCellValueFactory(new PropertyValueFactory("producerId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory("producerLandName"));
        fillTable();
    }
    
    private void fillTable(){
        ProducerDAO proDao = new ProducerDAO();
        List<Producer> producers = proDao.getAllProducers();
        producersList.getItems().setAll(producers);
    }

    @FXML
    private void showProducers(ActionEvent event) {
        fillTable();
    }
    
    private void cleanFields(){
        codeField.clear();
        nameField.clear();
    }

    @FXML
    private void findProducers(ActionEvent event) {
        String code = codeField.getText().trim();
        if(code.isEmpty()){
            System.out.println("Error, digite un codigo de la tabla para eliminar.");
            return;
        }
        ProducerDAO proDao = new ProducerDAO();
        Producer foundProducer = proDao.findProducerByCode(code);
        if(foundProducer != null){
            producersList.getItems().add(foundProducer);
        }else{
            System.out.println("No existe un productor con ese codigo.");
        }
    }

    @FXML
    private void updateProducers(ActionEvent event) {
        String code = codeField.getText().trim();
        String name = nameField.getText().trim();
        if(code.isEmpty() || name.isEmpty()){
            System.out.println("Error, no deje espeacios en blanco.");
            return;
        }
        try{
            ProducerDAO proDao = new ProducerDAO();
            Producer producer = new Producer(code,name);
            if(proDao.updateProducer(producer)){
                System.out.println("Registro actualizado correctamente.");
                cleanFields();
                fillTable();
            }
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }

    @FXML
    private void deleteProducers(ActionEvent event) {
        Producer selectedProducer = producersList.getSelectionModel().getSelectedItem();
        if(selectedProducer==null){
            System.out.println("Por favor seleccione un registro de la tabla para eliminar.");
            return;
        }
        ProducerDAO proDao = new ProducerDAO();
        boolean success = proDao.deleteProducer(selectedProducer);
        if(success){
            producersList.getItems().remove(selectedProducer);
            System.out.println("Productor eliminado correctamente."); 
        }
    }
    
}
