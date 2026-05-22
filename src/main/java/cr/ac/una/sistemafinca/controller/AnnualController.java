/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.controller;

import cr.ac.una.sistemafinca.dao.AnnualCropDAO;
import cr.ac.una.sistemafinca.model.AnnualCrop;
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
public class AnnualController {

    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField daysField;
    @FXML
    private TableView<AnnualCrop> annualCropsList;
    @FXML
    private TableColumn<AnnualCrop, String> idColumn;
    @FXML
    private TableColumn<AnnualCrop, String> nameColumn;
    @FXML
    private TableColumn<AnnualCrop, String> varietyColumn;
    @FXML
    private TableColumn<AnnualCrop, String> dateColumn;
    @FXML
    private TableColumn<AnnualCrop, String> typeColumn;
    @FXML
    private TableColumn<AnnualCrop, Integer> daysColumn;
    @FXML
    private TableColumn<AnnualCrop, String> descriptionColumn;
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
    private TextField dateField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField varietyField;
    
    public void initialize(){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("cropCode"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("cropName"));
        varietyColumn.setCellValueFactory(new PropertyValueFactory<>("cropVariety"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("plantationDate"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("cropType"));
        daysColumn.setCellValueFactory(new PropertyValueFactory<>("daysDuration"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        fillTable();
    }
    
    private void cleanFields() {
        idField.clear();
        nameField.clear();
        daysField.clear();
        dateField.clear();
        typeField.clear();
        varietyField.clear();
    }
    
    private void fillTable(){
        AnnualCropDAO annual = new AnnualCropDAO();
        List<AnnualCrop> crops = annual.getAllAnnualCrops();
        annualCropsList.getItems().setAll(crops);
    }
   
    @FXML
    private void deleteCrops(ActionEvent event) {
        AnnualCrop selectedCrop = annualCropsList.getSelectionModel().getSelectedItem();
        if(selectedCrop == null){
            System.out.println("Por favor selecciones un cultivo de la tabla para eliminar.");
            return;
        }
        AnnualCropDAO annual = new AnnualCropDAO();
        boolean success = annual.deleteAnnualCrop(selectedCrop);
        if(success){
            annualCropsList.getItems().remove(selectedCrop);
            cleanFields();
        }
    }

    @FXML
    private void updateCrops(ActionEvent event) {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String variety = varietyField.getText().trim();
        String days = daysField.getText().trim();
        String date = dateField.getText().trim();
        String type = typeField.getText().trim();
        if(id.isEmpty() || name.isEmpty() || variety.isEmpty() ||date.isEmpty() || type.isEmpty() || days.isEmpty()){
            System.out.println("Error, no deje espacios en blanco.");
            return;
        }
        try{
            int day = Integer.valueOf(days);
            if(type.equalsIgnoreCase("PERENNE")){
                System.out.println("Error, este tipo de cultivo no pertenece a esta tabla.");
            }else{
                AnnualCrop aCrop = new AnnualCrop(id,name,variety,date,type,day);
                AnnualCropDAO cropDao = new AnnualCropDAO();
                cropDao.updateAnnualCrop(aCrop);
                System.out.println("Registro actualizado correctamente.");
                cleanFields();
                fillTable();
            } 
        } catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }

    @FXML
    private void showAnnualCrops(ActionEvent event) {
        fillTable();
    }

    @FXML
    private void findAnnualCrop(ActionEvent event) {
        String code = idField.getText().trim();
        if(code.isEmpty()){
            System.out.println("Error, digite un codigo para realizar la busqueda.");
            return;
        }
        AnnualCropDAO annual = new AnnualCropDAO();
        AnnualCrop foundCrop = annual.findAnnualCropByCode(code);
        annualCropsList.getItems().clear();
        if(foundCrop != null){
            annualCropsList.getItems().add(foundCrop);
        }else{
            System.out.println("No existe un cultivo anual con ese codigo.");
        }
    }

    @FXML
    private void swichtToCropsWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/sistemafinca/Views/crop.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Styles/style.css").toExternalForm());
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage currentWindow = (Stage) source.getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }  
}
