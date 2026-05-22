/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.controller;

import cr.ac.una.sistemafinca.dao.AgriculturalWorkDAO;
import cr.ac.una.sistemafinca.dao.CropAux;
import cr.ac.una.sistemafinca.dao.PlotDAO;
import cr.ac.una.sistemafinca.dao.ResponsibleDAO;
import cr.ac.una.sistemafinca.model.AgriculturalWork;
import cr.ac.una.sistemafinca.model.Crop;
import cr.ac.una.sistemafinca.model.Plot;
import cr.ac.una.sistemafinca.model.Responsible;
import java.io.IOException;
import java.math.BigDecimal;
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
    private TableView<AgriculturalWork> worksList;
    @FXML
    private TableColumn<AgriculturalWork, String> workCodeColumn;
    @FXML
    private TableColumn<AgriculturalWork, Plot> plotCodeColumn;
    @FXML
    private TableColumn<AgriculturalWork, Crop> cropCodeColumn;
    @FXML
    private TableColumn<AgriculturalWork, Responsible> responsibleColumn;
    @FXML
    private TableColumn<AgriculturalWork, String> dateColumn;
    @FXML
    private TableColumn<AgriculturalWork, String> typeColumn;
    @FXML
    private TableColumn<AgriculturalWork, String> descriptionColumn;
    @FXML
    private TableColumn<AgriculturalWork, String> costColumn;
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
    
    public void initialize(){
        workCodeColumn.setCellValueFactory(new PropertyValueFactory<>("workCode"));
        plotCodeColumn.setCellValueFactory(new PropertyValueFactory<>("plotCode"));
        cropCodeColumn.setCellValueFactory(new PropertyValueFactory<>("cropCode"));
        responsibleColumn.setCellValueFactory(new PropertyValueFactory<>("responsibleId"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateCompletion"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("laborType"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("estimatedCost"));
        fillTable();
    }
    
    private void fillTable(){
        AgriculturalWorkDAO workDao = new AgriculturalWorkDAO();
        List<AgriculturalWork> work = workDao.getAllWorks();
        worksList.getItems().setAll(work);
    }
    
    private void cleanFields(){
        workCodeField.clear();
        plotCodeField.clear();
        cropCodeField.clear();
        resIdField.clear();
        dateField.clear();
        typeField.clear();
        descriptionField.clear();
        costField.clear();
        idField.clear();
    }

    @FXML
    private void addWorks(ActionEvent event) {
        String workCode = workCodeField.getText().trim();
        String plotCode = plotCodeField.getText().trim();
        String cropCode = cropCodeField.getText().trim();
        String idCode = resIdField.getText().trim();
        String date = dateField.getText().trim();
        String type = typeField.getText().trim();
        String description = descriptionField.getText().trim();
        String cost = costField.getText().trim();
        if(workCode.isEmpty() || plotCode.isEmpty() || cropCode.isEmpty() || idCode.isEmpty() || date.isEmpty() ||type.isEmpty() || description.isEmpty() || cost.isEmpty()){
            System.out.println("Error, no deje espacios en blanco.");
            return;
        }
        try{
            BigDecimal costs = new BigDecimal(cost.replace(',', '.'));
            PlotDAO plotDao = new PlotDAO();
            Plot plot = plotDao.findPlotByCode(plotCode);
            
            ResponsibleDAO responsibleDao = new ResponsibleDAO();
            Responsible responsible = responsibleDao.findResponsibleById(idCode);
            
            CropAux crop = new CropAux();
            
            AgriculturalWork work = new AgriculturalWork(workCode,plot,crop.findCropByCode(cropCode),responsible,date,type,description,costs);
            AgriculturalWorkDAO workDao = new AgriculturalWorkDAO();
            if(workDao.insertWork(work)){
                System.out.println("Labor agregada correctamente.");
                cleanFields();
            } 
        }catch(Exception ex){System.out.println("Error: "+ex.getMessage());}   
    }

    @FXML
    private void updateWorks(ActionEvent event) {
        String workCode = workCodeField.getText().trim();
        String plotCode = plotCodeField.getText().trim();
        String cropCode = cropCodeField.getText().trim();
        String idCode = resIdField.getText().trim();
        String date = dateField.getText().trim();
        String type = typeField.getText().trim();
        String description = descriptionField.getText().trim();
        String cost = costField.getText().trim();
        if(workCode.isEmpty() || plotCode.isEmpty() || cropCode.isEmpty() || idCode.isEmpty() || date.isEmpty() ||type.isEmpty() || description.isEmpty() || cost.isEmpty()){
            System.out.println("Error, no deje espacios en blanco.");
            return;
        }
        try{
            BigDecimal costs = new BigDecimal(cost.replace(',', '.'));
            PlotDAO plotDao = new PlotDAO();
            Plot plot = plotDao.findPlotByCode(plotCode);
            
            ResponsibleDAO responsibleDao = new ResponsibleDAO();
            Responsible responsible = responsibleDao.findResponsibleById(idCode);
            
            CropAux crop = new CropAux();
            
            AgriculturalWork work = new AgriculturalWork(workCode,plot,crop.findCropByCode(cropCode),responsible,date,type,description,costs);
            AgriculturalWorkDAO workDao = new AgriculturalWorkDAO();
            if(workDao.updateWork(work)){
                System.out.println("Labor actualizada correctamente.");
                cleanFields();
                fillTable();
            } 
        }catch(Exception ex){System.out.println("Error: "+ex.getMessage());}   
    }

    @FXML
    private void deleteWorks(ActionEvent event) {
        AgriculturalWork selectedWork = worksList.getSelectionModel().getSelectedItem();
        if(selectedWork==null){
            System.out.println("Por favor selecciones un registro de la tabla para eliminar.");
            return;
        }
        AgriculturalWorkDAO workDao = new AgriculturalWorkDAO();
        boolean success = workDao.deleteWork(selectedWork);
        if(success){
            worksList.getItems().remove(selectedWork);
            System.out.println("Labor eliminada correctamente");
            cleanFields();
        } 
    }

    @FXML
    private void findWorks(ActionEvent event) {
        String code = idField.getText().trim();
        if(code.isEmpty()){
            System.out.println("Error, digite un codigo para realizar la busqueda");
            return;
        }
        AgriculturalWorkDAO workDao = new AgriculturalWorkDAO();
        AgriculturalWork foundWork = workDao.findWorkByCode(code);
        worksList.getItems().clear();
        if(foundWork != null){
            worksList.getItems().add(foundWork);
        }else{
            System.out.println("No existe una labor con ese codigo.");
        }
    }

    @FXML
    private void showWorks(ActionEvent event) {
        fillTable();
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
    
}
