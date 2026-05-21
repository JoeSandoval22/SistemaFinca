/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.dao;

import cr.ac.una.sistemafinca.conexion.Conexion;
import cr.ac.una.sistemafinca.model.PerennialCrop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class PerennialCropDAO implements PerennialCropInterface {

    private Connection connection;
    
    public PerennialCropDAO(){
        this.connection=Conexion.getConnection();
    }
    @Override
    public boolean insertPerennialCrop(PerennialCrop perennial) {
        String sqlCrop = "INSERT INTO CROPS (crop_code,crop_variety,planting_date,crop_type) VALUES (?,?,?,?)";
        String sqlPerennial = "INSERT INTO PERENNIALCROP (perennial_code,perennial_name,years_production) VALUES (?,?,?)";
        try{
            PreparedStatement psCrop = connection.prepareStatement(sqlCrop);
            psCrop.setString(1, perennial.getCropCode());
            psCrop.setString(2, perennial.getCropVariety());
            psCrop.setString(3, perennial.getPlantationDate());
            psCrop.setString(4, perennial.getCropType());
            psCrop.executeUpdate();
            PreparedStatement psPerennial = connection.prepareStatement(sqlPerennial);
            psPerennial.setString(1, perennial.getCropCode());
            psPerennial.setString(2, perennial.getCropName());
            psPerennial.setInt(3, perennial.getEstimatedYears());
            psPerennial.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updatePerennialCrop(PerennialCrop perennial) {
        String sqlPerennial = "UPDATE PERENNIALCROP SET perennial_name = ?,years_production = ? WHERE perennial_code = ?";
        String sqlCrop = "UPDATE CROPS SET crop_variety = ?, planting_date = ?, crop_type = ? WHERE crop_code = ?";
        try{
            PreparedStatement psPerennial = connection.prepareStatement(sqlPerennial);
            psPerennial.setString(1, perennial.getCropName());
            psPerennial.setInt(2, perennial.getEstimatedYears());
            psPerennial.setString(3, perennial.getCropCode());
            psPerennial.executeUpdate();
            PreparedStatement psCrop = connection.prepareStatement(sqlCrop);
            psCrop.setString(1, perennial.getCropVariety());
            psCrop.setString(2, perennial.getPlantationDate());
            psCrop.setString(3, perennial.getCropType());
            psCrop.setString(4, perennial.getCropCode());
            psCrop.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletePerennialCrop(PerennialCrop perennial) {
        String sqlPerennial = "DELETE FROM PERENNIALCROP WHERE perennial_code = ?";
        String sqlCrop = "DELETE FROM CROPS WHERE crop_code = ?";
        try{
            PreparedStatement psPerennial = connection.prepareStatement(sqlPerennial);
            psPerennial.setString(1, perennial.getCropCode());
            psPerennial.executeUpdate();
            PreparedStatement psCrop = connection.prepareStatement(sqlCrop);
            psCrop.setString(1, perennial.getCropCode());
            psCrop.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public List<PerennialCrop> getAllPerennialCrops() {
        List<PerennialCrop> perennials = new ArrayList<>();
        String sqlPerennial = "SELECT pc.perennial_code, pc.perennial_name, c.crop_variety, c.planting_date, c.crop_type, pc.years_production "+
                              "FROM PERENNIALCROP pc JOIN CROPS c pc.perennial_code = c.crop_code";
        try{
            PreparedStatement ps = connection.prepareStatement(sqlPerennial);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PerennialCrop perennial = new PerennialCrop(rs.getString("perennial_code"),rs.getString("perennial_name"),rs.getString("crop_variety"),
                                                            rs.getString("planting_date"),rs.getString("crop_type"),rs.getInt("years_production"));
                perennials.add(perennial);
            }
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        }
        return perennials;
    }

    @Override
    public PerennialCrop findPerennialCropByCode(String code) {
        String sqlPerennial = "SELECT pc.perennial_code, pc.perennial_name, c.crop_variety, c.planting_date, c.crop_type, pc.years_production "+
                              "FROM PERENNIALCROP pc JOIN CROPS c pc.perennial_code = c.crop_code WHERE pc.perennial_code = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sqlPerennial);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new PerennialCrop(rs.getString("perennial_code"),rs.getString("perennial_name"),rs.getString("crop_variety"),
                                         rs.getString("planting_date"),rs.getString("crop_type"),rs.getInt("years_production"));
            }
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        }
        return null;
    }   
}