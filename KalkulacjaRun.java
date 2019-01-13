package pl.pawel.gaudziak.kalkulacja;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KalkulacjaRun extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/view/powitalnyView.fxml"));
        primaryStage.setTitle("logowanie");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        //((Node) start.getSource()).getScene().getWindow().hide();
    }


    public static void main(String[] args) {
        launch(args);
    }
}