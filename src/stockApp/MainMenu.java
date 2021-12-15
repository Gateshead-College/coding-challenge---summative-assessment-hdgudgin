package stockApp;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    ArrayList<String> stockList = new ArrayList<String>();
    ArrayList<Product> products = new ArrayList<>();
    private boolean exit = false;

    public void getInfo() {
        Initialise init = new Initialise();
        products = init.getProducts(init.readFile(Initialise.productsFile));
        while (!exit)
            menu();
    }

    public void menu() {
        System.out.println("Please select an option:");
        System.out.println("1 - View Products");
        System.out.println("2 - Add a New Product");
        System.out.println("3 - Amend a Product");
        System.out.println("4 - Remove a Product");
        System.out.println("5 - Exit");
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        handleChoice(choice);
    }

    private void handleChoice(int choice) {
        switch (choice) {

            case 1:
                displayProducts();
                break;
            case 2:
                addProduct();
                break;
            case 3:
                amendProduct();
                break;
            case 4:
                removeProduct();
                break;
            case 5:
                accountSettings();
                break;
            case 6:
                exitApp();
                break;
            default:
                System.out.println("Input is invalid");
        }
    }

    private void displayProducts() {
        for (Product p : products) {
            System.out.println("ID: " + p.productID + ", Manufacturer: " + p.productMan + ", Name: " + p.productName + ", Price (£): " + p.productPrice + ", Current Stock: " + p.productStock + ".");
        }
    }

    private void addProduct() {
        System.out.println("Please enter the product ID: ");
        int productID = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("Please enter the product manufacturer: ");
        String productMan = new Scanner(System.in).nextLine();
        System.out.println("Please enter the product name: ");
        String productName = new Scanner(System.in).nextLine();
        System.out.println("Please enter the product price: ");
        double productPrice = Double.parseDouble(new Scanner(System.in).nextLine());
        System.out.println("Please enter the amount currently in stock: ");
        int productStock = Integer.parseInt(new Scanner(System.in).nextLine());
        products.add(new Product(productID, productMan, productName, productPrice, productStock));
    }

    private void amendProduct() {
        System.out.println("Please enter the product ID for the product you'd like to amend");
        int id = Integer.parseInt(new Scanner(System.in).nextLine());
        Product amendProduct = null;
        for (Product p : products) {
            if (p.productID == id) {
                amendProduct = p;
                break;
            }
        }
        System.out.println("Which field would you like to amend?");
        System.out.println("1 - ID");
        System.out.println("2 - Manufacturer");
        System.out.println("3 - Name");
        System.out.println("4 - Price");
        System.out.println("5 - Stock");
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("Please enter the new value");
        if (amendProduct != null) {
            if (choice == 1) {
                amendProduct.productID = Integer.parseInt(new Scanner(System.in).nextLine());
            } else if (choice == 2) {
                amendProduct.productMan = new Scanner(System.in).nextLine();
            } else if (choice == 3) {
                amendProduct.productName = new Scanner(System.in).nextLine();
            } else if (choice == 4) {
                amendProduct.productPrice = Double.parseDouble(new Scanner(System.in).nextLine());
            } else if (choice == 5) {
                amendProduct.productStock = Integer.parseInt(new Scanner(System.in).nextLine());
            } else {
                System.out.println("Invalid input.");
                amendProduct();
            }
        }
    }

    private void removeProduct() {
        System.out.println("Please select the item you want to remove: ");
        int count = 1;
        for (Product p : products) {
            System.out.println(count + " - " + p.productName);
            count++;
        }
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        products.remove(choice - 1);
    }

    private void exitApp() {
        Initialise.writeData(products);
        products.clear();
        exit = true;
    }

    private void accountSettings() {

    }
}
