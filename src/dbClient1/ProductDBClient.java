package dbClient1;

import DbClient.Models.Client;
import DbClient.Models.Product;

import java.sql.*;
import java.util.Scanner;

public class ProductDBClient {
    private static Scanner scanner = new Scanner(System.in);
    public static void getProducts() {
        String sql = "Select * from product";
        Connection connection = null;
        try {
            connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("Id " + "\t" + "Name " + "\t" + "price " + "\t" +"discount %");
            while (resultSet.next()) {

                System.out.println(resultSet.getInt(1) + "\t" +
                        resultSet.getString(2) + "\t" +
                        resultSet.getDouble(3) + "\t" +
                        resultSet.getDouble(4) + "\t");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ClientProduct getClientProductId(int userChoice) throws Exception {
        Connection connection = null;
        try {
            connection = DbConnection.getConnection();
            String selectSQL = "Select client_id, name, price, discount, quantity, amount, id from productClient where client_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, userChoice);
            ResultSet resultSet = preparedStatement.executeQuery();
            ClientProduct clientProduct = new ClientProduct();
            while (resultSet.next()) {
                clientProduct.setClientID(resultSet.getInt(1));
                clientProduct.setName(resultSet.getString(2));
                clientProduct.setPrice(resultSet.getDouble(3));
                clientProduct.setDiscount(resultSet.getDouble(4));
                clientProduct.setQuantity(resultSet.getInt(5));
                clientProduct.setAmount(resultSet.getDouble(6));
                clientProduct.setId(resultSet.getInt(7));
                System.out.println(resultSet.getInt("id") + "\t"
                + resultSet.getString("name") + "\t" +
                resultSet.getDouble("price") + "\t" +
                        resultSet.getDouble("discount") + "\t" +
                        resultSet.getInt("quantity")+ "\t" +
                                resultSet.getDouble("amount") + "\t");


            }
            return clientProduct;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        throw new Exception("fail");
    }
    public static void addProduct(ClientProduct clientProduct) throws Exception {
        System.out.println("Select product to add: ");
        int productChoice = scanner.nextInt();

        String sql = "Insert into ClientProduct (id, name,price, discount, quantity, amount, Client_id) " +
                "Values (" + productChoice +",?,?,?,?,?,?) where id = ";
        Connection connection = null;
        try {
            try {
                Product product = new Product();
                connection = DbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, clientProduct.getName());
                preparedStatement.setDouble(2, clientProduct.getPrice());
                preparedStatement.setDouble(3, clientProduct.getDiscount());
                preparedStatement.setInt(4, clientProduct.getQuantity());
                preparedStatement.setDouble(5, clientProduct.getAmount());
                preparedStatement.setInt(6, clientProduct.getClient().getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                if (connection != null) {
                    connection.close();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        throw  new Exception("Fail");
    }
    public static void insert(ClientProduct clientProduct) throws Exception {
        System.out.println("Enter client`s id ");
        int clientId =scanner.nextInt();
        String sql = "Insert into productClient (name, price, discount, quantity, amount, client_id)" +
                "values (?,?,?,?,?," + clientId +")";
        Connection connection = null;

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, clientProduct.getName());
                preparedStatement.setDouble(2,clientProduct.getPrice());
                preparedStatement.setDouble(3,clientProduct.getDiscount());
                preparedStatement.setDouble(4,clientProduct.getAmount());

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
            throw new Exception("Error");
        }
public static void Sum(int choice) {
Connection connection = null;
try {
    connection = DbConnection.getConnection();
    String sumQuery = "Select sum(amount) from productClient where client_id = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sumQuery);
    preparedStatement.setInt(1, choice);
    ResultSet resultSet = preparedStatement.executeQuery();
    ClientProduct clientProduct = new ClientProduct();
    while (resultSet.next()) {
        System.out.println(resultSet.getInt(1));
    }
}
catch (SQLException e) {
    e.printStackTrace();
}

}
}
