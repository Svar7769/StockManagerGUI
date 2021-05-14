package StockManager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;

public class storeJson {

    // Updates and store HashTable to Json File while closing the App
    public static void storeToJson(){
        // Converting HashTable to JSON
        String jsonText = JSONValue.toJSONString(Main.inv);

        // Writing JsonText to JSON FIle
        try(FileWriter file = new FileWriter("D:\\Java Programs\\StockManager\\src\\DATA.json")) {
            file.write(jsonText);
            file.flush();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }


    // Loads Data to HashTable while loading the app
    public static void loadDATA(){
        // Creating JSON parser object
        JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader("D:\\Java Programs\\StockManager\\src\\DATA.json")) {
            // Loading JSONdata to JASONArray
            Object o  = parser.parse(reader);
            JSONArray array = new JSONArray();
            array.add(o);

            // Looping every record
            for(int i=0; array.size() > i ;i++) {

                // Stroting Single record to obj
                JSONObject obj = (JSONObject) array.get(i);

                // iterating Over Keys(Which is ItemName)
                obj.keySet().forEach(key ->
                {
                    // Loading JSONObject Using Key
                    JSONObject array2 = (JSONObject) obj.get(key);

                    // Creating Hash Table to Store Item Info
                    Hashtable<String, String> itemInfo = new Hashtable<>();

                    // Placing Value in hashTable
                    itemInfo.put("QUANTITY", String.valueOf((String) array2.get("QUANTITY")));
                    itemInfo.put("PRICE", String.valueOf((String) array2.get("PRICE")));

                    // adding it to the Inv
                    Main.inv.put((String)key , itemInfo);


                });
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
