package stockChallenge;

import java.util.ArrayList;
import java.util.Scanner;

public class mainMenu {

    adminStock stock = new adminStock();

    public static void main(String[] args) {
        mainMenu mm = new mainMenu();
        mm.addStocks();
        mm.menu();
        mm.viewStocks();
        mm.updateStocks();
        mm.removeStocks();
    }

    private void menu() {
        System.out.println("Welcome, please select an option from the list below");
        System.out.println("1 - View Stock");
        System.out.println("2 - Add a new stock item");
        System.out.println("3 - Update an existing stock item");
        System.out.println("4 - Remove an existing stock item");
        System.out.println("5 - Logout");
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        if (choice == 1) {
            viewStocks();
        }
    }

    private void addStocks() {
        stock.addStock(new stock("001", "Greggs", "Sausage Rolls", "£1", "1000"));
        stock.addStock(new stock("002", "Greggs", "Vegan Sausage Rolls", "£1", "500"));
        stock.addStock(new stock("003", "Greggs", "Steak Bakes", "£1.50", "750"));
        stock.addStock(new stock("004", "Greggs", "Chicken Bakes", "£1.50", "500"));
        stock.addStock(new stock("005", "Greggs", "Festive Bakes", "£1.50", "500"));
        stock.addStock(new stock("006", "Greggs", "Sausage, Bean and Cheese Melts", "£1.50", "500"));
        stock.addStock(new stock("007", "Greggs", "Margherita Pizza", "£2", "750"));
        stock.addStock(new stock("008", "Greggs", "Pepperoni Pizza", "£2", "750"));
    }

    private void viewStocks() {
//        Scanner myScanner = new Scanner(System.in);
//        System.out.println("Please enter your password to view stock.");
//        String password = myScanner.nextLine();
//        ArrayList<stock> stocks = stock.getStocks(password);
//        if (stocks != null) {
        for (stock s : stocks) {
            System.out.println("ID: " + s.productID + ", Manufacturer: " + s.itemMan + ", Name: " + s.itemName + ", Price: " + s.itemPrice + ", Stock: " + s.itemAmount);
        }

        private void updateStocks () {
        }

        private void removeStocks () {
        }
    }
}
