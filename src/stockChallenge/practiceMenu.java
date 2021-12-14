//package stockChallenge;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class mainMenu {
//
//    adminStock stock = new adminStock();
//
//    public mainMenu(stock stock) {
//        menu();
//    }
//
//    private void menu() {
//        System.out.println("Welcome, please select an option from the list below:");
//        System.out.println("1 - View Stock");
//        System.out.println("2 - Add a new stock item");
//        System.out.println("3 - Update an existing stock item");
//        System.out.println("4 - Remove an existing stock item");
//        System.out.println("5 - Logout");
//        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
//        if (choice == 1) {
//            displayStock();
//            menu();
//        } else if (choice == 2) {
//            addItem;
//            menu();
//        } else if (choice == 3) {
//            addStock;
//            menu();
//        } else if (choice == 4) {
//            removeStock;
//            menu();
//        } else if (choice == 5) {
//            System.out.println("Sign out...");
//        }
//    }
//
//    private void displayStock() {
//        Scanner myScanner = new Scanner(System.in);
//        System.out.println("Please enter your password to view stock");
//        String password = myScanner.nextLine();
//        ArrayList<stock> stocks = stock.getStocks(password);
//        if (stocks != null) {
//            for (stock i : stocks) {
//                System.out.println("Name: " + i.itemName + ", Price: " + i.itemPrice + ", Manufacturer: " + i.itemMan + ", Product ID: " + i.productID + ", Stock: " + i.itemStock);
//            }
//        } else
//            System.out.println("Incorrect Password.");
//    }
//}
