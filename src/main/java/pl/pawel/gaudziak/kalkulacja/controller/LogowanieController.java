package pl.pawel.gaudziak.kalkulacja.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.pawel.gaudziak.kalkulacja.database.DBConnector;
import pl.pawel.gaudziak.kalkulacja.model.ModelHelper;
import pl.pawel.gaudziak.kalkulacja.model.User;
import pl.pawel.gaudziak.kalkulacja.service.UserService;

import java.io.IOException;
import java.sql.SQLException;

public class LogowanieController {

    @FXML
    private TextField lLoginOkno;

    @FXML
    private PasswordField hasloOkno;

    @FXML
    private Button lLogin;

    @FXML
    private Button lPowrot;

    @FXML
    private Button LExit;

    @FXML
    void lExitClick(MouseEvent event) {
        System.exit(0);
    }

    private DBConnector db;

    public void initialize() {
        db = new DBConnector();
    }

    @FXML
    void lLoginClick(MouseEvent event) throws SQLException, IOException {
        String login = lLoginOkno.getText();
        String haslo = hasloOkno.getText();

        UserService userService = new UserService();
        User user = userService.login(login, haslo);

        if (user != null) {
            String login2 = user.getLogin();
            ModelHelper.loggedUser = user;

            if ("admin".equals(login2)) {
                Stage adminStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/view/adminView.fxml"));
                adminStage.setScene(new Scene(root));
                adminStage.show();

                ((Node) event.getSource()).getScene().getWindow().hide();

            }
            else if (login2 != null) {
                Stage userStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/view/zamowienieWyborView.fxml"));
                userStage.setScene(new Scene(root));
                userStage.show();
                ((Node) event.getSource()).getScene().getWindow().hide();
            }

        }
        else {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("Error");
            error.setContentText("Błędny login lub hasło, albo jedno i drugie!!!");
            error.setTitle("Podaj poprawne dane logowania");
            error.showAndWait();
        }
    }

    @FXML
    void lPowrotClick(MouseEvent event) throws IOException {
        Stage userStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/powitalnyView.fxml"));
        userStage.setScene(new Scene(root));
        userStage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

}
