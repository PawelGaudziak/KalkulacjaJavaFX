package pl.pawel.gaudziak.kalkulacja.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ZamowienieWyborController {

    @FXML
    private Button backBtn;

    @FXML
    private Button ulotkiBtn;

    @FXML
    private Button plakatyBtn;

    @FXML
    private Button kartonyBtn;

    @FXML
    private Button exitBtn;

    @FXML
    void backClick(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/logowanieView.fxml"));
        adminStage.setTitle("logowanie");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();

    }

    @FXML
    void broszuryClick(MouseEvent event) {

    }

    @FXML
    void exitClick(MouseEvent event) {

    }



    @FXML
    void kartonyClick(MouseEvent event) {

    }

    @FXML
    void plakatyClick(MouseEvent event) {

    }

    @FXML
    void ulotkiClick(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/zamowienieZView.fxml"));
        adminStage.setTitle("Składanie zleceń na ulotki");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

}
