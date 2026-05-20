/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.dao;

import cr.ac.una.sistemafinca.conexion.Conexion;
import cr.ac.una.sistemafinca.model.Producer;
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
public class ProducerDAO implements ProducerInterface{
    private Connection connection;
    
    public ProducerDAO(){
        this.connection=Conexion.getConnection();
    }
    
    @Override
    public boolean insertProducer(Producer prod) {
        String sql = "INSERT INTO PRODUCERS (id_producer,producer_name) VALUES (?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, prod.getProducerId());
            ps.setString(2, prod.getProducerLandName());
            ps.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateProducer(Producer prod) {
        String sql = "UPDATE PRODUCERS SET producer_name WHERE id_producer = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, prod.getProducerLandName());
            ps.setString(2, prod.getProducerId());
            ps.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteProducer(Producer prod) {
        String sql = "DELETE FROM PRODUCERS WHERE id_producer = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, prod.getProducerId());
            ps.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public Producer findProducerByCode(String code) {
        String sql = "SELECT * FROM PRODUCERS WHERE id_producer = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Producer(rs.getString("id_producer"),rs.getString("producer_name"));
            }
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        }
        return null;
    }

    @Override
    public List<Producer> getAllProducers() {
        List<Producer> producers = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCERS";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Producer producer = new Producer(rs.getString("id_producer"),rs.getString("producer_name"));
                producers.add(producer);
            }
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        }
        return producers;
    }
}
