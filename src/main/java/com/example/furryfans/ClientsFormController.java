package com.example.furryfans;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientsFormController {
    @FXML
    private Connection con;

    @FXML
    private Statement stmt;

    public TextField txtId_client;
    public TextField txtSurname;
    public TextField txtName;
    public TextField txtTelefone;
    public TextField txtCity;
    public TextField txtAddress;
    public TextField txtEmail;

    private Boolean modalResult = false;


    public void onSaveClick(ActionEvent actionEvent) {
        this.modalResult = true;
        ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow()).close();
    }

    public void onCancelClick(ActionEvent actionEvent) {
        this.modalResult = false;
        ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow()).close();
    }

    public Boolean getModalResult() {
        return modalResult;
    }


    public Clients getClients() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafxTest","javafxTest","changeme");
            stmt = con.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Unable to connect to database " + e.getMessage());
        }


        try {
            String sql;
            sql = "insert into client(Id_client,Surname,Name,Telefone,City,Address,Email) values ("
                    + txtId_client.getText() + ","
                    + "'" + txtSurname.getText() + "',"
                    + "'" + txtName.getText() + "',"
                    + "'" + txtTelefone.getText() + "',"
                    + "'" + txtCity.getText() + "',"
                    + "'" + txtAddress.getText() + "',"
                    + "'" + txtEmail.getText() + "')";

            int rs = stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Информация сохранёна");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to insert record " + e.getMessage());
        }

        return null;
    }
}
