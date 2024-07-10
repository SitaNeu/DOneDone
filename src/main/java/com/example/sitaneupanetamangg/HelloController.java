package com.example.sitaneupanetamangg;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class HelloController implements Initializable {
    @FXML
    private TableView<OrderDetails> orderTable;
    @FXML
    private TableColumn<OrderDetails, Integer> orderIDColumn;
    @FXML
    private TableColumn<OrderDetails, String> customerNameColumn;
    @FXML
    private TableColumn<OrderDetails, Integer> mobileNumberColumn;
    @FXML
    private TableColumn<OrderDetails, String> pizzaSizeColumn;
    @FXML
    private TableColumn<OrderDetails, Integer> toppingsColumn;
    @FXML
    private TableColumn<OrderDetails, Double> totalColumn;
    @FXML
    private TextField orderID;
    @FXML
    private TextField customerName;
    @FXML
    private TextField mobileNumber;
    @FXML
    private TextField pizzaSize;
    @FXML
    private TextField toppings;
    @FXML
    private TextField total;
    @FXML
    private Label welcomeText;

     ObservableList<OrderDetails> list = FXCollections.observableArrayList();

    @FXML
    protected void fetchData() {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/sitaprogramming";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "SELECT * FROM orderdetails";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int orderID = resultSet.getInt("OrderID");
                String customerName = resultSet.getString("CustomerName");
                int mobileNumber = resultSet.getInt("MobileNumber");
                String pizzaSize = resultSet.getString("PizzaSize");
                int toppings = resultSet.getInt("Toppings");
                double total = resultSet.getDouble("Total");
                list.add(new OrderDetails(orderID, customerName, mobileNumber, pizzaSize, toppings, total));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderIDColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        mobileNumberColumn.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        pizzaSizeColumn.setCellValueFactory(new PropertyValueFactory<>("pizzaSize"));
        toppingsColumn.setCellValueFactory(new PropertyValueFactory<>("toppings"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        orderTable.setItems(list);
    }

    @FXML
    public void InsertData(ActionEvent actionEvent) {
        String cname = customerName.getText();
        String number = mobileNumber.getText();
        String size = pizzaSize.getText();
        int top = Integer.parseInt(toppings.getText());


        if (size.equals("S")) {

            Integer x = (int) ((8 + top * 1.50) * 0.15);
            String tot = String.valueOf(x);
            total.setText(tot);
        } else if (size.equals("M")) {
            Integer x = (int) ((10 + top * 1.50) * 0.15);
            String tot = String.valueOf(x);
            total.setText(tot);

        } else if (size.equals("L")) {
            Integer x = (int) ((12 + top * 1.50) * 0.15);
            String tot = String.valueOf(x);
            total.setText(tot);
        } else {
            Integer x = (int) ((15 + top * 1.50) * 0.15);
            String tot = String.valueOf(x);
            total.setText(tot);

        }



        String jdbcUrl = "jdbc:mysql://localhost:3306/sitaprogramming";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "INSERT INTO orderdetails (CustomerName, MobileNumber, PizzaSize, Toppings) VALUES ('"+cname+"','"+number+"','"+size+"','"+top+"','"+total+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void UpdateData(ActionEvent actionEvent) {
        int id = Integer.parseInt(orderID.getText());
        String name = customerName.getText();
        int number = Integer.parseInt(mobileNumber.getText());
        String size = this.pizzaSize.getText();
        int top = Integer.parseInt(this.toppings.getText());
        Integer x = (int) ((15 + top * 1.50) * 0.15);
        String tot = String.valueOf(x);
        total.setText(tot);


        String jdbcUrl = "jdbc:mysql://localhost:3306/sitaprogramming";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "UPDATE orderdetails SET  `orderID`='"+id+"', `CustomerName`='"+name+"',`MobileNumber`='"+number+"',`PizzaSize`='"+size+"', `Toppings`='"+top+"',`Total`='"+total+"' WHERE id='"+id+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void DeleteData(ActionEvent actionEvent) {

        String id = orderID.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/sitaprogramming";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "DELETE FROM orderdetails WHERE OrderID = '"+id+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void LoadData(ActionEvent actionEvent) {
        String id = orderID.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/db_csd214_lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM user WHERE id='"+id+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {

                String name = resultSet.getString("Customer Name");
                int number = resultSet.getInt("Mobile Number");
                String size = resultSet.getString("Pizza Size");
                int top = resultSet.getInt("Toppings");
                double tot = resultSet.getDouble("Total");

                customerName.setText(name);
                mobileNumber.setText(String.valueOf(number));
                pizzaSize.setText(size);
                toppings.setText(String.valueOf(top));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
