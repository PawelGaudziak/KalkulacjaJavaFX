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

public class PowitalnyController {

    @FXML
    private Button pLogowanie;

    @FXML
    private Button rejestracja;

    @FXML
    private Button pZlecBezLog;

    @FXML
    private Button pExit;

    @FXML
    void pRejestracjaClick(MouseEvent event) throws IOException {
        Stage visitStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/rejestracjaView.fxml"));
        visitStage.setScene(new Scene(root));
        visitStage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }


    @FXML
    void pExitClick(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void pLogowanieClick(MouseEvent event) throws IOException {
        Stage visitStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/logowanieView.fxml"));
        visitStage.setScene(new Scene(root));
        visitStage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    void pZlecBezLogClick(MouseEvent event) throws IOException {
        Stage visitStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/zamowienieNZView.fxml"));
        visitStage.setScene(new Scene(root));
        visitStage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }
}
