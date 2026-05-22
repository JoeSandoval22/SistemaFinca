/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.controller;

import cr.ac.una.sistemafinca.dao.AnnualCropDAO;
import cr.ac.una.sistemafinca.dao.PerennialCropDAO;
import cr.ac.una.sistemafinca.model.AnnualCrop;
import cr.ac.una.sistemafinca.model.PerennialCrop;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class CropController {

    @FXML
    private TextField cropField;
    @FXML
    private TextField varietyField;
    @FXML
    private TextField plantationDateField;
    @FXML
    private TextField cropTypeField;
    @FXML
    private Button addCropButton;
    @FXML
    private Button viewCropButton;
    @FXML
    private Button backButton;
    @FXML
    private TextField cropNameField;
    @FXML
    private TextField durationField;
    @FXML
    private Button annualWindow;
    
    public void initialize(){  
        clearFields();
    }
    
    private void clearFields() {
        cropField.clear();
        cropNameField.clear();
        varietyField.clear();
        plantationDateField.clear();
        cropTypeField.clear();
        durationField.clear();
    }

    @FXML
    private void addCrop(ActionEvent event) {
        String code = cropField.getText().trim();
        String name = cropNameField.getText().trim();
        String variety = varietyField.getText().trim();
        String date = plantationDateField.getText().trim();
        String type = cropTypeField.getText().trim();
        String duration = durationField.getText().trim();
        if(code.isEmpty() || name.isEmpty() || variety.isEmpty() || date.isEmpty() || type.isEmpty() || duration.isEmpty()){
            System.out.println("Error, no deje espacios sin completar.");
        }
        try{
            int days = Integer.valueOf(duration);
            if(type.equalsIgnoreCase("ANUAL")){
                AnnualCrop aCrop = new AnnualCrop(code,name,variety,date,type,days);
                AnnualCropDAO cropDao = new AnnualCropDAO();
                cropDao.insertAnnualCrop(aCrop);
                System.out.println("Cultivo anual agregado correctamente.");
                clearFields();
            }else{
                PerennialCrop pCrop = new PerennialCrop(code,name,variety,date,type,days);
                PerennialCropDAO pDao = new PerennialCropDAO();
                pDao.insertPerennialCrop(pCrop);
                System.out.println("Cultivo perenne agregado correctamente.");
                clearFields();
            }   
        } catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }         
    }

    @FXML
    private void swichtToViewCrop(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/sistemafinca/Views/perennialView.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Styles/style.css").toExternalForm());
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage currentWindow = (Stage) source.getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }

    @FXML
    private void switchtoMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/sistemafinca/Views/agriculturalManager.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Styles/style.css").toExternalForm());
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage currentWindow = (Stage) source.getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }

    @FXML
    private void switchToAnnualView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/sistemafinca/Views/annualView.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Styles/style.css").toExternalForm());
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage currentWindow = (Stage) source.getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }  
}
