package stockApp;

import java.io.*;
import java.util.ArrayList;

public class Initialise {

    static File productsFile = new File("C:/Users/harry.gudgin/Products.txt");

    public void createFileIfNoneExists() {
        try {
            if (!productsFile.isFile()) {
                productsFile.createNewFile();
            }
        } catch (IOException ioEx) {
            System.out.println("Encountered an error trying to create text file");
            ioEx.printStackTrace();
        }
    }

    public static void writeData(ArrayList<Product> products) {
        try {
            FileWriter writer = new FileWriter(productsFile);

            for (Product p : products) {
                writer.write(p.productID + "," + p.productMan + "," + p.productName + "," + p.productPrice + "," + p.productStock + ".");
                writer.write("\n");
            }
            writer.close();
        } catch (IOException ioex) {
            System.out.println("Failed to write to file");
            ioex.printStackTrace();
        }
    }

    public ArrayList<String> readFile(File file) {
        createFileIfNoneExists();
        ArrayList<String> lines = new ArrayList<>();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
        } catch (IOException ioex) {
            System.out.println("Failed to read the file");
            ioex.printStackTrace();
        }
        return lines;
    }

    private Product getProductsFromString(String productString) {
        Product p;
        String[] pd = productString.split(",");
        p = new Product(Integer.parseInt(pd[0]), pd[1], pd[2], Double.parseDouble(pd[3]), Integer.parseInt(pd[4]));
        return p;
    }

    public ArrayList<Product> getProducts(ArrayList<String> productStrings) {
        ArrayList<Product> products = new ArrayList<>();
        for (String s : productStrings) {
            products.add(getProductsFromString(s));
        }
        return products;
    }
}