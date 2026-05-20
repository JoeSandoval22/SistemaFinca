/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.dao;

import cr.ac.una.sistemafinca.conexion.Conexion;
import cr.ac.una.sistemafinca.model.AgriculturalTechnician;
import cr.ac.una.sistemafinca.model.Responsible;
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
public class ResponsibleDAO implements ResponsibleInterface{
    private Connection connection;
    
    public ResponsibleDAO(){
        this.connection=Conexion.getConnection();
    }
    
    @Override
    public boolean insertResponsible(Responsible responsible) {
        String sql = "INSERT INTO RESPONSIBLES (identification,responsible_name,email,phone_number,responsible_type,land_name_asociation,technical_specialty) VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, responsible.getIdentification());
            ps.setString(2, responsible.getResponsibleName());
            ps.setString(3, responsible.getEmail());
            ps.setString(4, responsible.getPhoneNumber());
            ps.setString(5, responsible.getResponsibleType());
            ps.setString(6, responsible.getLandNameAsociation().getProducerId());
            ps.setString(7, responsible.getTechnicalSpeciality().getSpecialty());
            ps.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateResponsible(Responsible responsible) {
        String sql = "UPDATE RESPONSIBLES SET responsible_name = ?,email = ?,phone_number = ?,responsible_type = ?,land_name_asociation = ?,technical_specialty = ? WHERE identification = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, responsible.getResponsibleName());
            ps.setString(2, responsible.getEmail());
            ps.setString(3, responsible.getPhoneNumber());
            ps.setString(4, responsible.getResponsibleType());
            ps.setString(5, responsible.getLandNameAsociation().getProducerId());
            ps.setString(6, responsible.getTechnicalSpeciality().getSpecialty());
            ps.setString(7, responsible.getIdentification());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteResponsible(Responsible responsible) {
        String sql = "DELETE FROM RESPONSIBLES WHERE identification = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, responsible.getIdentification());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Responsible> getAllResponsibles() {
        ProducerDAO producer = new ProducerDAO();
        List<Responsible> responsibles = new ArrayList<>();
        String sql = "SELECT * FROM RESPONSIBLES";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Responsible responsible = new Responsible(rs.getString("identification"),rs.getString("responsible_name"),rs.getString("email"),rs.getString("phone_number"),
                                                          rs.getString("responsible_type"),producer.findProducerByCode(rs.getString("land_name_asociation")),
                                                          AgriculturalTechnician.valueOf(rs.getString("technical_specialty")));
                responsibles.add(responsible);
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
            return null;
        }
        return responsibles;
    }

    @Override
    public Responsible findResponsibleById(String id) {
        ProducerDAO producer = new ProducerDAO();
        String sql = "SELECT * FROM RESPONSIBLES WHERE identification = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Responsible(rs.getString("identification"),rs.getString("responsible_name"),rs.getString("email"),rs.getString("phone_number"),
                           rs.getString("responsible_type"),producer.findProducerByCode(rs.getString("land_name_asociation")),
                           AgriculturalTechnician.valueOf(rs.getString("technical_specialty")));
            }
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
            return null;
        }
        return null;
    }
}