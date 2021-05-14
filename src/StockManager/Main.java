package StockManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Hashtable;

public class Main extends Application {

    protected static Hashtable<String, Hashtable<String, String>> inv = new Hashtable<>();
    protected static String DIR_PATH = "C:\\Users\\svarp\\IdeaProjects\\StockManager\\src\\StockManager\\DATA.json";

    @Override
    public void start(Stage primaryStage) throws Exception{

        // Loading Data From JSONFile
        storeJson.loadDATA();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("iSTONKS");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        primaryStage.setResizable(false);

        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            exit(primaryStage);
        });
    }

    public void exit(Stage stage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ClOSE");
        alert.setHeaderText("YOU are about to leave APP");

        if(alert.showAndWait().get() == ButtonType.OK){
            storeJson.storeToJson();
            stage.close();
        }
    }


    public static void main(String[] args) {
        storeJson.loadDATA();
        launch(args);
    }
}
