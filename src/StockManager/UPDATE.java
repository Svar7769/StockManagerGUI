package StockManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UPDATE {

    // Class Variable declaration
    StockManager.Display display = new Display();
    StockManager.updateInventory updateItem = new updateInventory();
    StockManager.addItem item = new addItem();


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    TextField itemName;
    @FXML
    TextField itemquantity;
    @FXML
    TextField itemprice;

    public void mainPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void submit(ActionEvent event) throws IOException {
        String name = itemName.getText();
        String qty = itemquantity.getText();
        String price = itemprice.getText();

        try
        {
            // checking valid integer using parseInt() method
            Integer.parseInt(qty);
            Float.parseFloat(price);

            // check if item exists in your Inventory
            if (Main.inv.containsKey(name)) {
                updateItem.sellItem(name, Integer.parseInt(qty), Float.parseFloat(price));
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("ITEM NOT FOUND");
                alert.setHeaderText("ITEM IS NOT PRESENT IN THE DATABASE");

                if (alert.showAndWait().get() == ButtonType.OK) {
                    itemName.setText("");
                    itemquantity.setText("");
                    itemprice.setText("");
                }
            }

            System.out.println(Main.inv);
            mainPage(event);
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error :" + e);

            if(alert.showAndWait().get() == ButtonType.OK){
                itemName.setText("");
                itemquantity.setText("");
                itemprice.setText("");
            }
        }
    }
}
