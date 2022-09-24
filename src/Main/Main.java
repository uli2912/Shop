package Main;

import DbClient.Models.*;
import dbClient1.ProductDBClient;
import dbClient1.ClientProduct;

import java.security.ProtectionDomain;
import java.util.Scanner;


public class Main {
private static final int yes = 1;
private static final int no = 2;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();
        Product product = new Product();

        Cart cart = new Cart();
        System.out.println("There is our products: "
        );
        ProductDBClient.getProducts();

//        System.out.println("Select your product: ");
        System.out.println("Enter client's id: ");
        int userChoice = scanner.nextInt();
        ClientProduct clientProduct1 = ProductDBClient.getClientProductId(userChoice);

        System.out.println("Sum for client " + userChoice + " =");
        ProductDBClient.Sum(userChoice);
    }


    }

