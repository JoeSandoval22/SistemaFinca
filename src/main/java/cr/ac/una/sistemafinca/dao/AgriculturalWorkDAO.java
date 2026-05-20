/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.dao;

import cr.ac.una.sistemafinca.conexion.Conexion;
import cr.ac.una.sistemafinca.model.AgriculturalWork;
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
public class AgriculturalWorkDAO implements AgriculturalWorkInterface {
    
    private Connection connection;
    
    public AgriculturalWorkDAO(){
        this.connection=Conexion.getConnection();
    }

    @Override
    public boolean insertWork(AgriculturalWork work) {
        String sql = "INSERT INTO AGRICULTURAL_WORK (code,plot_code,crop_code,responsible_id,date_completion,labor_type,work_description,estimated_cost) "+
                     "VALUES (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, work.getWorkCode());
            ps.setString(2, work.getPlotCode().getPlotCode());
            ps.setString(3, work.getCropCode().getCropCode());
            ps.setString(4, work.getResponsibleId().getIdentification());
            ps.setString(5, work.getDateCompletion());
            ps.setString(6, work.getLaborType());
            ps.setString(7, work.getDescription());
            ps.setBigDecimal(8, work.getEstimatedCost());
            ps.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateWork(AgriculturalWork work) {
        String sql = "UPDATE AGRICULTURAL_WORK SET plot_code = ?,crop_code = ?,responsible_id = ?,date_completion = ?,labor_type = ?,work_description = ?,estimated_cost = ? "+
                     "WHERE code = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, work.getPlotCode().getPlotCode());
            ps.setString(2, work.getCropCode().getCropCode());
            ps.setString(3, work.getResponsibleId().getIdentification());
            ps.setString(4, work.getDateCompletion());
            ps.setString(5, work.getLaborType());
            ps.setString(6, work.getDescription());
            ps.setBigDecimal(7, work.getEstimatedCost());
            ps.setString(8, work.getWorkCode());
            ps.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteWork(AgriculturalWork work) {
        String sql = "DELETE FROM AGRICULTURAL_WORK WHERE code = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, work.getWorkCode());
            ps.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public List<AgriculturalWork> getAllWorks() {
        List<AgriculturalWork> works = new ArrayList<>();
        PlotDAO plot = new PlotDAO();
        CropAux crop = new CropAux();
        ResponsibleDAO responsible = new ResponsibleDAO();
        String sql = "SELECT * FROM AGRICULTURAL_WORK";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                AgriculturalWork work = new AgriculturalWork(rs.getString("code"),plot.findPlotByCode(rs.getString("plot_code")),crop.findCropByCode("crop_code"),
                                                             responsible.findResponsibleById("responsible_id"),rs.getString("date_completion"),rs.getString("labor_type"),
                                                             rs.getString("work_description"),rs.getBigDecimal("estimated_cost"));
                works.add(work);
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
            return null;
        }
        return works;
    }

    @Override
    public AgriculturalWork findWorkByCode(String code) {
        PlotDAO plot = new PlotDAO();
        CropAux crop = new CropAux();
        ResponsibleDAO responsible = new ResponsibleDAO();
        String sql = "SELECT * FROM AGRICULTURAL_WORK WHERE code = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new AgriculturalWork(rs.getString("code"),plot.findPlotByCode(rs.getString("plot_code")),crop.findCropByCode("crop_code"),
                                            responsible.findResponsibleById("responsible_id"),rs.getString("date_completion"),rs.getString("labor_type"),
                                            rs.getString("work_description"),rs.getBigDecimal("estimated_cost"));
            }
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        }
        return null;
    }
    
}
