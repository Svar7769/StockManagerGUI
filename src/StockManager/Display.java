package StockManager;

import java.util.*;

public class Display {

    void showInventory() {
        // get keys() from Hashtable and iterate
        Enumeration<String> enumeration = Main.inv.keys();

        // iterate using enumeration object
        while (enumeration.hasMoreElements()) {

            String key = enumeration.nextElement();
            System.out.println("Item : " + key);

            Enumeration<String> secondEnumeration = Main.inv.get(key).keys();

            while (secondEnumeration.hasMoreElements()) {
                String secondKey = secondEnumeration.nextElement();
                System.out.println("    " + secondKey + " : " + Main.inv.get(key).get(secondKey));
            }
        }
    }
}