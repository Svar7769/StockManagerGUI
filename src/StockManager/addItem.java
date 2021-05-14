package StockManager;

import java.util.*;

public class addItem {
    private String name;
    private int qty;
    private float price;

    public addItem() {
    }

    void addToInventory(String name, int qty, float price) {

        // Making an value
        Hashtable<String, String> itemInfo = new Hashtable<>();

        // Placing Value in hashTable
        itemInfo.put("PRICE", String.valueOf(price));
        itemInfo.put("QUANTITY", String.valueOf(qty));


        // adding it to the Inv
        Main.inv.put(name, itemInfo);
    }
}
