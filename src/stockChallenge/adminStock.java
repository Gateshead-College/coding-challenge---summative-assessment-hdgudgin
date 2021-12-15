package stockChallenge;

import java.util.ArrayList;

public class adminStock {

    private ArrayList<stock> stocks = new ArrayList<stock>();
    ArrayList<String> stockList = new ArrayList<String>();

    public adminStock() {
        populateStockList();
    }

    private void populateStockList() {
        stockList.add("Sausage Rolls");
        stockList.add("Vegan Sausage Rolls");
        stockList.add("Steak Bakes");
        stockList.add("Chicken Bakes");
        stockList.add("Festive Bakes");
        stockList.add("Sausage, Bean and Cheese Melts");
        stockList.add("Margherita Pizza");
        stockList.add("Pepperoni Pizza");
    }



    public void addStock(stock i) {
        if (stockList.contains(i.itemName)) {
            this.stocks.add(i);
        } else {
            System.out.println("This item does not belong at Greggs.");
        }
    }

    public ArrayList<stock> getStocks(String password) {
        if (password.equals("password123")) {
            return this.stocks;
        } else return null;
    }
}