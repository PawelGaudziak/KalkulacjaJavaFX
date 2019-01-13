package pl.pawel.gaudziak.kalkulacja.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.pawel.gaudziak.kalkulacja.database.DBConnector;
import pl.pawel.gaudziak.kalkulacja.model.*;
import pl.pawel.gaudziak.kalkulacja.service.ZleceniaService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZamowienieZController {

    @FXML
    private TextField zWitajOkno;

    @FXML
    private TextField zNakladOkno;

    @FXML
    private TextField zgramaturaOkno;

    @FXML
    private ComboBox<String> zFormatUlotkiCombo;

    ObservableList<String> formaty = FXCollections.observableArrayList("A4", "A5", "A6", "DL", "2DL");

    @FXML
    private ComboBox<String> rodzajPapieru;

    ObservableList<String> papier = FXCollections.observableArrayList("offset", "kreda mat", "kreda błysk");

    @FXML
    private Button zZamowienieBtn;

    @FXML
    private Button zStartowyBtn;

    @FXML
    private Button zExit;

    private DBConnector db;

    @FXML
    void zExitClick(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void zStartowyClick(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/powitalnyView.fxml"));
        adminStage.setTitle("Ekran powitalny");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

    //private String powitanie() {
    //  String witaj = zWitajOkno.setText(ModelHelper.login);

//    }

    /*
        private String getFormatData () {
            Integer naklad = Integer.valueOf(zNakladOkno.getText());
            Integer gramatura = Integer.valueOf(zgramaturaOkno.getText());
            String format = zFormatUlotkiCombo.getValue();

            return "Nakład: \n" + naklad + " " + gramatura;
        }
    */
    @FXML
    void zZamowienieClick(MouseEvent event) throws IOException {

        ZleceniaService zleceniaService = new ZleceniaService();
        Integer naklad = Integer.valueOf(zNakladOkno.getText());
        Integer gramatura = Integer.valueOf(zgramaturaOkno.getText());
        String format = zFormatUlotkiCombo.getValue();
        String papier = rodzajPapieru.getValue();
        String praca = "ulotka";

        FormatUlotki formatUlotki = zleceniaService.getFormatUlotki(format);
        Papier rodzajPapieru = zleceniaService.getRodzajPapieru(papier);
        RodzajPracy rodzajPracy = zleceniaService.getRodzajPracy(praca);
        User idKlienta = ModelHelper.loggedUser;

        Zlecenia zlecenia = new Zlecenia(idKlienta, naklad, gramatura, rodzajPapieru, rodzajPracy, formatUlotki);
        System.out.println(zlecenia);
        zleceniaService.save(zlecenia);
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/powitalnyView.fxml"));
        adminStage.setTitle("Strona startowa");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

    public void initialize() throws SQLException {

        db = new DBConnector();
        // zFormatUlotkiCombo.
        zFormatUlotkiCombo.setItems(formaty);
        rodzajPapieru.setItems(papier);

        final Connection connection = db.connection();
        PreparedStatement ps = connection.prepareStatement("SELECT nazwa_firmy FROM klienci WHERE login=?");
        ps.setString(1, ModelHelper.loggedUser.getLogin());
        ResultSet rs = ps.executeQuery();
        //System.out.println(ps);

        //zWitajOkno.
        zWitajOkno.setText(ModelHelper.loggedUser.getLogin());
    }
}