/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.controller;

import cr.ac.una.sistemafinca.dao.PerennialCropDAO;
import cr.ac.una.sistemafinca.model.PerennialCrop;
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
public class PerennialController {

    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField daysField;
    @FXML
    private TableColumn<PerennialCrop, String> idColumn;
    @FXML
    private TableColumn<PerennialCrop, String> nameColumn;
    @FXML
    private TableColumn<PerennialCrop, String> varietyColumn;
    @FXML
    private TableColumn<PerennialCrop, String> dateColumn;
    @FXML
    private TableColumn<PerennialCrop, String> typeColumn;
    @FXML
    private TableColumn<PerennialCrop, String> descriptionColumn;
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
    private TableColumn<PerennialCrop, Integer> yearsColumn;
    @FXML
    private TextField varietyField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField typeField;
    @FXML
    private TableView<PerennialCrop> perennialCropsList;
    
    public void initialize(){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("cropCode"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("cropName"));
        varietyColumn.setCellValueFactory(new PropertyValueFactory<>("cropVariety"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("plantationDate"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("cropType"));
        yearsColumn.setCellValueFactory(new PropertyValueFactory<>("estimatedYears"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        fillTable();
    }
    
    private void cleanFields(){
        idField.clear();
        nameField.clear();
        daysField.clear();
        varietyField.clear();
        dateField.clear();
        typeField.clear();
    }
    
    private void fillTable() {
        PerennialCropDAO perennial = new PerennialCropDAO();
        List<PerennialCrop> crops = perennial.getAllPerennialCrops();
        perennialCropsList.getItems().setAll(crops);
    }

    @FXML
    private void deleteCrops(ActionEvent event) {
        PerennialCrop selectedCrop = perennialCropsList.getSelectionModel().getSelectedItem();
        if(selectedCrop == null){
            System.out.println("Por favor seleccione un cultivo de la tabla para eliminar.");
            return;
        }
        PerennialCropDAO perennial = new PerennialCropDAO();
        boolean success = perennial.deletePerennialCrop(selectedCrop);
        if(success){
            perennialCropsList.getItems().remove(selectedCrop);
            cleanFields();
        }
    }

    @FXML
    private void updateCrops(ActionEvent event) {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String variety = varietyField.getText().trim();
        String date = dateField.getText().trim();
        String type = typeField.getText().trim();
        String years = daysField.getText().trim();
        if(id.isEmpty() || name.isEmpty() || variety.isEmpty() || date.isEmpty() || type.isEmpty() || years.isEmpty()){
            System.out.println("Error, no deje espacios en blanco.");
            return;
        }
        try{
            int year = Integer.valueOf(years);
            if(type.equalsIgnoreCase("ANUAL")){
                System.out.println("Error, este tipo de cultivo no pertenece a esta tabla.");
            }else{
                PerennialCrop pCrop = new PerennialCrop(id,name,variety,date,type,year);
                PerennialCropDAO cropDao = new PerennialCropDAO();
                cropDao.updatePerennialCrop(pCrop);
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
        PerennialCropDAO perennial = new PerennialCropDAO();
        PerennialCrop foundCrop = perennial.findPerennialCropByCode(code);
        perennialCropsList.getItems().clear();
        if(foundCrop != null){
            perennialCropsList.getItems().add(foundCrop);
        }else{
            System.out.println("No existe un cultivo perenne con ese codigo.");
        }
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
