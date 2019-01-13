package pl.pawel.gaudziak.kalkulacja.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.pawel.gaudziak.kalkulacja.model.User;
import pl.pawel.gaudziak.kalkulacja.service.UserService;

import java.io.IOException;

public class RejestracjaController {

    @FXML
    private TextField rImieOkno;

    @FXML
    private TextField rNazwiskoOkno;

    @FXML
    private TextField rLoginOkno;

    @FXML
    private TextField rHasloOkno;

    @FXML
    private TextField rMailOkno;

    @FXML
    private TextField rFirmaOkno;

    @FXML
    private TextField rNIPOkno;

    @FXML
    private TextField rTelefonOkno;

    @FXML
    private TextField rUlicaOkno;

    @FXML
    private TextField rKod;

    @FXML
    private TextField rMiasto;

    @FXML
    private Button rZatwierdzBtn;

    @FXML
    private Button rExitBtn;

    @FXML
    private Button rStartowaBtn;

    @FXML
    void rExitClick(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void rStartowaAction(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/powitalnyView.fxml"));
        adminStage.setTitle("Strona startowa");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

    @FXML
    private void rZatwierdzClick(MouseEvent event) throws IOException {

        UserService userService = new UserService();

        String imie = rImieOkno.getText();
        String nazwisko = rNazwiskoOkno.getText();
        String login = rLoginOkno.getText();
        String haslo = rHasloOkno.getText();
        String e_mail = rMailOkno.getText();
        String nazwa_firmy = rFirmaOkno.getText();
        Integer NIP = Integer.valueOf(rNIPOkno.getText());
        Integer nr_telefonu = Integer.valueOf(rTelefonOkno.getText());
        String adres_firmy_ulica = rUlicaOkno.getText();
        String adres_firmy_kod = rKod.getText();
        String adres_firmy_miasto = rMiasto.getText();


        User user = new User(login, haslo, imie, nazwisko, nazwa_firmy, e_mail, NIP, nr_telefonu, adres_firmy_ulica, adres_firmy_kod, adres_firmy_miasto);
        userService.save(user);

        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/powitalnyView.fxml"));
        adminStage.setTitle("Strona startowa");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }
}
