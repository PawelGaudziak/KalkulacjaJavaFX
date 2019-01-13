package pl.pawel.gaudziak.kalkulacja.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.pawel.gaudziak.kalkulacja.model.User;
import pl.pawel.gaudziak.kalkulacja.service.UserService;

import java.io.IOException;
import java.util.List;

public class UserTableController {

    @FXML
    private TableView<User> tableUser;

    @FXML
    private TableColumn<User, Integer> colId;

    @FXML
    private TableColumn<User, String> colLogin;

    @FXML
    private TableColumn<User, String> colHaslo;

    @FXML
    private TableColumn<User, String> colImie;

    @FXML
    private TableColumn<User, String> colNazwisko;

    @FXML
    private TableColumn<User, String> colFirma;

    @FXML
    private TableColumn<User, String> colEmail;

    @FXML
    private TableColumn<User, Integer> colNIP;

    @FXML
    private TableColumn<User, Integer> colTelefon;

    @FXML
    private TableColumn<User, String> colUlica;

    @FXML
    private TableColumn<User, String> colKod;

    @FXML
    private TableColumn<User, String> colMiasto;

    @FXML
    private Button btnBack;

    @FXML
    void BackClick(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/adminView.fxml"));
        adminStage.setTitle("Panel administratora");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene().getWindow().hide();

    }
    public void initialize(){

        //-- Pobranie danych z bazy danych z tabeli user i dodanie do TableView na widoku
        UserService userService = new UserService();
        List<User> users = userService.getAllUser();

        ObservableList<User> allUser= FXCollections.observableArrayList(users);
        tableUser.setItems(null);
        tableUser.setItems(allUser);
        //------

        // wskazanie kolumn do wyświetlenia z naszego modelu
        colId.setCellValueFactory(new PropertyValueFactory<User, Integer>("Klienci_id_klienta"));
        colLogin.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
        colHaslo.setCellValueFactory(new PropertyValueFactory<User, String>("haslo"));
        colImie.setCellValueFactory(new PropertyValueFactory<User, String>("imie"));
        colNazwisko.setCellValueFactory(new PropertyValueFactory<User, String>("nazwisko"));
        colEmail.setCellValueFactory(new PropertyValueFactory<User, String>("e_mail"));
        colFirma.setCellValueFactory(new PropertyValueFactory<User, String>("nazwa_firmy"));
        colNIP.setCellValueFactory(new PropertyValueFactory<User, Integer>("NIP"));
        colTelefon.setCellValueFactory(new PropertyValueFactory<User, Integer>("nr_telefonu"));
        colUlica.setCellValueFactory(new PropertyValueFactory<User, String>("adres_firmy_ulica"));
        colKod.setCellValueFactory(new PropertyValueFactory<User, String>("adres_firmy_kod"));
        colMiasto.setCellValueFactory(new PropertyValueFactory<User, String>("adres_firmy_miasto"));





        // -------

    }

}
