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

public class REMOVE {

    private Stage stage;
    private Scene scene;
    private Parent root;

    StockManager.Display display = new Display();
    StockManager.updateInventory updateItem = new updateInventory();
    StockManager.addItem item = new addItem();

    @FXML
    TextField Name;

    public void mainPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void submit(ActionEvent event) throws IOException{
        String name = Name.getText();

        if (Main.inv.containsKey(name)){
            Main.inv.remove(name);
            mainPage(event);
        } else {
            // If the Does not Exist
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("ITEM NOT FOUND");
            alert.setHeaderText("Item Is not present in the database");

            if(alert.showAndWait().get() == ButtonType.OK){
                Name.setText("");
            }
        }

        updateItem.deleteItem(name);
    }
}
