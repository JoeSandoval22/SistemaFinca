module cr.ac.una.sistemafinca {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    
    opens cr.ac.una.sistemafinca to javafx.fxml;
    opens cr.ac.una.sistemafinca.controller to javafx.fxml;
    exports cr.ac.una.sistemafinca;
    opens cr.ac.una.sistemafinca.dao;
    opens cr.ac.una.sistemafinca.model;
    opens cr.ac.una.sistemafinca.conexion;
}
