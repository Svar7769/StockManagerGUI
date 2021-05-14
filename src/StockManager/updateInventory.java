package StockManager;

import java.util.*;

public class updateInventory {
    // Constructor
    public updateInventory() {
    }

    // Method to modify the content for the given item name
    void updateItem(String name, int qty) {
        // Qty of item to be updated
        int preQty =Integer.parseInt(Main.inv.get(name).get("QUANTITY"));
        int newQty = preQty-qty;

        // Condition Checking
        if (newQty<0){
            System.out.println("You don't have that much item in your inventory");
        }else if (newQty == 0) {
            deleteItem(name);
        }
        else {
            // Changing Qty in Inv
            Main.inv.get(name).replace("QUANTITY", String.valueOf(newQty));
        }
    }

    // Delete method
    void deleteItem(String name) {
        if (Main.inv.containsKey(name)){
            Main.inv.remove(name);
        } else {
            // If the Does not Exist
            System.out.println("Your Inventory does not contain such Item\n");
        }
    }

    void buyExistingItem(String name, int qty, float price) {
        int preQty =Integer.parseInt(Main.inv.get(name).get("QUANTITY"));
        int newQty = qty+preQty;

        // changing quantity
        Main.inv.get(name).replace("QUANTITY", String.valueOf(newQty));

        // Checking if price Change
        // This Variable can be used to track change in price if wanted
        int prePrice =Integer.parseInt(Main.inv.get(name).get("QUANTITY"));
        // Updating Data if there is a change in price
        if (prePrice != price) {
            Main.inv.get(name).replace("PRICE", String.valueOf(price));
        }
    }

    void buyNewItem(String name, int qty, float price) {
        // Simply creating a new Item
        StockManager.addItem item = new addItem();
        item.addToInventory(name, qty, price);
    }

    void sellItem(String name, int qty, float price) {
        int preQty =Integer.parseInt(Main.inv.get(name).get("QUANTITY"));
        int curQty = preQty - qty;
        // Condition Checking
        if (curQty<0){
            System.out.println("You don't have that much item in your inventory");
        }else if (curQty <= 0) {
            // delete  item if we are out of stock
            deleteItem(name);
        }
        else {
            // Changing Qty in Inv
            Main.inv.get(name).replace("QUANTITY", String.valueOf(curQty));
        }

        // Checking if price Change
        // This Variable can be used to track change in price if wanted
        int prePrice =Integer.parseInt(Main.inv.get(name).get("QUANTITY"));
        // Updating Data if there is a change in price
        if (prePrice != price) {
            Main.inv.get(name).replace("PRICE", String.valueOf(price));
        }
    }
}
