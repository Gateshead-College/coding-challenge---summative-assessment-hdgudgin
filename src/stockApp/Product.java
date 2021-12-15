package stockApp;

public class Product {

    public int productID;
    public String productMan;
    public String productName;
    double productPrice;
    int productStock;

    public Product(int productID, String productMan, String productName, double productPrice, int productStock) {
        this.productID = productID;
        this.productMan = productMan;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }
}
