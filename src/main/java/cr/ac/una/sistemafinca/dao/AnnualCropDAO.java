/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.dao;

import cr.ac.una.sistemafinca.conexion.Conexion;
import cr.ac.una.sistemafinca.model.AnnualCrop;
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
public class AnnualCropDAO implements AnnualCropInterface {
    
    private Connection connection;
    
    public AnnualCropDAO(){
        this.connection=Conexion.getConnection();
    }
    
    @Override
    public boolean insertAnnualCrop(AnnualCrop annual) {
        String sqlCrop = "INSERT INTO CROPS (crop_code,crop_variety,planting_date,crop_type) VALUES (?,?,?,?)";
        String sqlAnnual = "INSERT INTO ANNUALCROP (annual_code,annual_name,duration_days) VALUES (?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sqlCrop);
            ps.setString(1, annual.getCropCode());
            ps.setString(2, annual.getCropVariety());
            ps.setString(3, annual.getPlantationDate());
            ps.setString(4, annual.getCropType());
            ps.executeUpdate();   
            PreparedStatement psAnnual = connection.prepareStatement(sqlAnnual);
            psAnnual.setString(1, annual.getCropCode());
            psAnnual.setString(2, annual.getCropName());
            psAnnual.setInt(3, annual.getDaysDuration());
            psAnnual.executeUpdate();
            return true;  
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateAnnualCrop(AnnualCrop annual) {
        String sqlAnnual = "UPDATE ANNUALCROP SET annual_name=?,duration_days=? WHERE annual_code = ?";
        String sqlCrop = "UPDATE CROPS SET crop_variety = ?, planting_date = ?, crop_type = ? WHERE crop_code = ?";
        try{
            PreparedStatement psAnnual = connection.prepareStatement(sqlAnnual);
            psAnnual.setString(1, annual.getCropName());
            psAnnual.setInt(2, annual.getDaysDuration());
            psAnnual.setString(3, annual.getCropCode());
            psAnnual.executeUpdate();
            PreparedStatement psCrop = connection.prepareStatement(sqlCrop);
            psCrop.setString(1, annual.getCropVariety());
            psCrop.setString(2, annual.getPlantationDate());
            psCrop.setString(3, annual.getCropType());
            psCrop.setString(4, annual.getCropCode());
            psCrop.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteAnnualCrop(AnnualCrop annual) {
        String sqlAnnual = "DELETE FROM ANNUALCROP WHERE annual_code = ?";
        String sqlCrop = "DELETE FROM CROPS WHERE crop_code = ?";
        try{
            PreparedStatement psAnnual = connection.prepareStatement(sqlAnnual);
            psAnnual.setString(1, annual.getCropCode());
            psAnnual.executeUpdate();
            PreparedStatement psCrop = connection.prepareStatement(sqlCrop);
            psCrop.setString(1, annual.getCropCode());
            psCrop.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public List<AnnualCrop> getAllAnnualCrops() {
        List<AnnualCrop> annuals = new ArrayList<>();
        String sqlAnnual = "SELECT an.annual_code, an.annual_name, c.crop_variety, c.planting_date, c.crop_type, an.duration_days "+
                           "FROM ANNUALCROP an JOIN CROPS c ON an.annual_code = c.crop_code ";
        try{
            PreparedStatement ps = connection.prepareStatement(sqlAnnual);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                AnnualCrop annual = new AnnualCrop(rs.getString("annual_code"),rs.getString("annual_name"),rs.getString("crop_variety"),rs.getString("planting_date"),
                                                   rs.getString("crop_type"),rs.getInt("duration_days"));
                annuals.add(annual);
            }
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        }
        return annuals;
    }

    @Override
    public AnnualCrop findAnnualCropByCode(String code) {
        String sqlAnnual = "SELECT an.annual_code, an.annual_name, c.crop_variety, c.planting_date, c.crop_type, an.duration_days "+
                           "FROM ANNUALCROP an JOIN CROPS c ON an.annual_code = c.crop_code WHERE an.annual_code = ? ";
        try{
            PreparedStatement ps = connection.prepareStatement(sqlAnnual);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new AnnualCrop(rs.getString("annual_code"),rs.getString("annual_name"),rs.getString("crop_variety"),rs.getString("planting_date"),
                                      rs.getString("crop_type"),rs.getInt("duration_days"));
            }
        }  catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        }
        return null;
    }  
}