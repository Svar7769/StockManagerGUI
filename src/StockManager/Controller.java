package StockManager;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private TableView<item> tableView;

    @FXML
    private TableColumn<item, String> tableName;

    @FXML
    private TableColumn<item, String> tableQuantity;

    @FXML
    private TableColumn<item, String> tablePrice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableName.setCellValueFactory(new PropertyValueFactory<item, String>("name"));
        tableQuantity.setCellValueFactory(new PropertyValueFactory<item, String>("qty"));
        tablePrice.setCellValueFactory(new PropertyValueFactory<item, String>("price"));

        // get keys() from Hashtable and iterate
        Enumeration<String> enumeration = Main.inv.keys();

        // iterate using enumeration object
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            item Item = new item(key, (String)Main.inv.get(key).get("QUANTITY"), (String)Main.inv.get(key).get("PRICE"));
            tableView.getItems().add(Item);
        }
    }

    public void addPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ADD.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void updatePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("UPDATE.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void removePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("REMOVE.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
