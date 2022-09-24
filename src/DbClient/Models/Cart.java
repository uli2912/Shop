package DbClient.Models;

import dbClient1.ClientProduct;

import java.util.Arrays;

public class Cart {
    public Cart(){}
    Cart(ClientProduct[] ClientProducts){
        this.ClientProducts = ClientProducts;
    }
    ClientProduct[] ClientProducts;

    @Override
    public String toString() {
        return "Cart{" +
                "ClientProducts=" + Arrays.toString(ClientProducts) +
                '}';
    }
}
