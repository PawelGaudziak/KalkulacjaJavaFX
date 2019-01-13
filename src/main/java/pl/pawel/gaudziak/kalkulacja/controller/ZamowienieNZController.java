package pl.pawel.gaudziak.kalkulacja.controller;


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

import java.io.IOException;

//import static java.lang.ProcessImpl.start;

public class ZamowienieNZController extends KalkulacjaController {
    @FXML
    private TextField ZNimieOkno;

    @FXML
    private TextField ZNnazwiskoOkno;

    @FXML
    private TextField ZNfirmaOkno;

    @FXML
    private TextField ZNnakladOkno;

    @FXML
    private TextField ZNgramaturaOkno;

    @FXML
    private ComboBox<?> ZNformatUlotkiCombo;

    @FXML
    private TextField ZNmailOkno;

    @FXML
    private Button zZamowienieBtn;

    @FXML
    private Button zStartowyBtn;

    @FXML
    private Button zExit;

    @FXML
    void ZNexitClick(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void ZNformatUlotkiCombo(MouseEvent event) {

    }

    @FXML
    public void ZNstartowyClick(MouseEvent event) throws IOException {
            Stage primaryStageNZ = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/view/powitalnyView.fxml"));
            primaryStageNZ.setTitle("logowanie");
            primaryStageNZ.setScene(new Scene(root));
            primaryStageNZ.show();

            ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    void ZNzamowienieClick(MouseEvent event) {

    }

}
