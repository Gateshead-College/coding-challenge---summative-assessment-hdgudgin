package stockApp;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

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
        System.out.println(ANSI_RED + "------------------------------");
        System.out.println("Please select an option:");
        System.out.println(ANSI_RED + "------------------------------");
        System.out.println(ANSI_GREEN + "1 " + ANSI_RESET + " - View Products");
        System.out.println(ANSI_BLUE + "2 " + ANSI_RESET + " - Add a New Product");
        System.out.println(ANSI_YELLOW + "3 " + ANSI_RESET + " - Amend a Product");
        System.out.println(ANSI_PURPLE + "4 " + ANSI_RESET + " - Remove a Product");
        System.out.println(ANSI_BLACK + "5 " + ANSI_RESET + " - Exit");
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
                exitApp();
                break;
            default:
                System.out.println(ANSI_BLACK + "------------------------------");
                System.out.println("Input is invalid");
                System.out.println(ANSI_BLACK + "------------------------------");
        }
    }

    private void displayProducts() {
        for (Product p : products) {
            System.out.println("ID: " + p.productID + ", Manufacturer: " + p.productMan + ", Name: " + p.productName + ", Price (£): " + p.productPrice + ", Current Stock: " + p.productStock + ".");
        }
    }

    private void addProduct() {
        System.out.println(ANSI_RED + "------------------------------");
        System.out.println("Please enter the product ID: ");
        System.out.println(ANSI_RED + "------------------------------");
        int productID = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println(ANSI_RED + "------------------------------");
        System.out.println("Please enter the product manufacturer: ");
        System.out.println(ANSI_RED + "------------------------------");
        String productMan = new Scanner(System.in).nextLine();
        System.out.println(ANSI_RED + "------------------------------");
        System.out.println("Please enter the product name: ");
        System.out.println(ANSI_RED + "------------------------------");
        String productName = new Scanner(System.in).nextLine();
        System.out.println(ANSI_RED + "------------------------------");
        System.out.println("Please enter the product price: ");
        System.out.println(ANSI_RED + "------------------------------");
        double productPrice = Double.parseDouble(new Scanner(System.in).nextLine());
        System.out.println(ANSI_RED + "------------------------------");
        System.out.println("Please enter the amount currently in stock: ");
        System.out.println(ANSI_RED + "------------------------------");
        int productStock = Integer.parseInt(new Scanner(System.in).nextLine());
        products.add(new Product(productID, productMan, productName, productPrice, productStock));
    }

    private void amendProduct() {
        System.out.println(ANSI_RED + "------------------------------");
        System.out.println("Please enter the product ID for the product you'd like to amend");
        System.out.println(ANSI_RED + "------------------------------");
        int id = Integer.parseInt(new Scanner(System.in).nextLine());
        Product amendProduct = null;
        for (Product p : products) {
            if (p.productID == id) {
                amendProduct = p;
                break;
            }
        }
        System.out.println("Which field would you like to amend?");
        System.out.println(ANSI_GREEN + "1 - ID");
        System.out.println(ANSI_BLUE + "2 - Manufacturer");
        System.out.println(ANSI_YELLOW + "3 - Name");
        System.out.println(ANSI_PURPLE + "4 - Price");
        System.out.println(ANSI_BLACK + "5 - Stock");
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println(ANSI_RED + "------------------------------");
        System.out.println("Please enter the new value");
        System.out.println(ANSI_RED + "------------------------------");
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
                System.out.println(ANSI_BLACK + "------------------------------");
                System.out.println("Invalid input.");
                System.out.println(ANSI_BLACK + "------------------------------");
                amendProduct();
            }
        }
    }

    private void removeProduct() {
        System.out.println(ANSI_RED + "------------------------------");
        System.out.println("Please select the item you want to remove: ");
        System.out.println(ANSI_RED + "------------------------------");
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
}
