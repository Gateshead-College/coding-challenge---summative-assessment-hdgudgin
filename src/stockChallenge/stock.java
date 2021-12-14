package stockChallenge;

public class stock {

    String itemName;
    String itemPrice;
    String itemMan;
    String productID;
    String itemAmount;

    public stock(String productID, String itemMan, String itemName, String itemPrice, String itemAmount) {
        this.productID = productID;
        this.itemMan = itemMan;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemAmount = itemAmount;
    }
}
