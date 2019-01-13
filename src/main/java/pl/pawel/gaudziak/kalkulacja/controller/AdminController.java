package pl.pawel.gaudziak.kalkulacja.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {


    @FXML
    private Button aDodajKlientaBtn;

    @FXML
    private Button aDodajZlecenieBtn;

    @FXML
    private Button aPokazZleceniaBtn;

    @FXML
    private Button aKalkulacjaBtn;

    @FXML
    private Button aExitBtn;

    @FXML
    private Button aKlienci;

    @FXML
    private Button aBack;

    @FXML
    void aBackClick(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/logowanieView.fxml"));
        adminStage.setTitle("Logowanie");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

    @FXML
    void aDodajKlientaClick(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/rejestracjaView.fxml"));
        adminStage.setTitle("Rejestracja");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

    @FXML
    void aDodajZlecenieClick(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/zamowienieWyborView.fxml"));
        adminStage.setTitle("Zamówienia");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

    @FXML
    void aExitClick(MouseEvent event) {
        System.exit(0);
    }


    @FXML
    void aKalkulacjaClick(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/kalkulacjaView.fxml"));
        adminStage.setTitle("Zamówienia");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

    @FXML
    void aPokazZleceniaClick(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/zleceniaView.fxml"));
        adminStage.setTitle("Lista wszystkich zleceń");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();

    }
    @FXML
    void aKlienciClick(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/userTableView.fxml"));
        adminStage.setTitle("Lista wszystkich klientów");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }
  }



