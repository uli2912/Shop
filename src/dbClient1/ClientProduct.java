package dbClient1;

import DbClient.Models.Client;
import DbClient.Models.Product;

public class ClientProduct extends Product {

    int quantity;
    double amount;
    int clientID;
    public ClientProduct(){}

    @Override
    public Client getClient() {
        return super.getClient();
    }

    @Override
    public void setClient(Client client) {
        super.setClient(client);
    }

    public ClientProduct(int id, String name, double price, double discount,
                         int quantity, double amount) {
        super(id, name, price, discount);
        this.quantity = quantity;
        this.amount = amount;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    @Override
    public void setDiscount(double discount) {
        super.setDiscount(discount);
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }


    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public  double getDiscount() {
        return super.getDiscount();
    }

    @Override
    public  double getPrice() {
        return super.getPrice();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public double getAmount() {
        return amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
