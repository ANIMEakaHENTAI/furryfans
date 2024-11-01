package com.example.furryfans;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ClientsController implements Initializable {
    public TableView mainTable;
    private ObservableList<Clients> readersList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        mainTable.setItems(readersList);


        TableColumn<Clients, Integer> Id_clientColumn = new TableColumn<>("Номер клиента");
        Id_clientColumn.setCellValueFactory(new PropertyValueFactory<>("Id_client"));

        TableColumn<Clients, String> SurnameColumn = new TableColumn<>("Фамилия клиента");
        SurnameColumn.setCellValueFactory(new PropertyValueFactory<>("Surname"));

        TableColumn<Clients, String> NameColumn = new TableColumn<>("Имя клиента");
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<Clients, String> TelefoneColumn = new TableColumn<>("Номер телефона клиента");
        TelefoneColumn.setCellValueFactory(new PropertyValueFactory<>("Telefone"));

        TableColumn<Clients, String> CityColumn = new TableColumn<>("Номер телефона клиента");
        CityColumn.setCellValueFactory(new PropertyValueFactory<>("City"));

        TableColumn<Clients, String> AddressColumn = new TableColumn<>("Номер телефона клиента");
        AddressColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));

        TableColumn<Clients, String> EmailColumn = new TableColumn<>("Почта клиента");
        EmailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));

        mainTable.getColumns().addAll(Id_clientColumn, SurnameColumn, NameColumn, TelefoneColumn, CityColumn, AddressColumn, EmailColumn);

        readersList = FXCollections.observableArrayList();
        loadData();

        mainTable.setItems(readersList);
    }

    private void loadData() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafxTest","javafxTest","changeme");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM client");

            while (rs.next()) {
                int Id_client = rs.getInt("Id_client");
                String Name = rs.getString("Name");
                String Surname = rs.getString("Surname");
                String Telefone = rs.getString("Telefone");
                String City = rs.getString("City");
                String Address = rs.getString("Address");
                String Email = rs.getString("Email");
                readersList.add(new Clients(Id_client, Surname, Name, Telefone, City, Address, Email));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onAddClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ClientsAddForm.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(this.mainTable.getScene().getWindow());

        stage.showAndWait();

        ClientsFormController controller = loader.getController();
        if (controller.getModalResult()) {
            Clients newReaders = controller.getClients();
            this.readersList.add(newReaders);
        }
    }


    public void onDeleteClick(ActionEvent actionEvent) {
        try
        {
            Clients selectedrow = (Clients) mainTable.getSelectionModel().getSelectedItem();

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafxTest","javafxTest","changeme");;
            PreparedStatement ps = conn.prepareStatement("DELETE FROM client WHERE Id_client = ?");

            ps.setInt(1, selectedrow.getId_client());

            ps.execute();
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
}
