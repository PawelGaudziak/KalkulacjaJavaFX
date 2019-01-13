package pl.pawel.gaudziak.kalkulacja.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.pawel.gaudziak.kalkulacja.database.DBConnector;
import pl.pawel.gaudziak.kalkulacja.model.User;
import pl.pawel.gaudziak.kalkulacja.model.Zlecenia;
import pl.pawel.gaudziak.kalkulacja.service.ZleceniaService;
import pl.pawel.gaudziak.kalkulacja.service.*;
import pl.pawel.gaudziak.kalkulacja.controller.*;


import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.util.List;

public class ZleceniaTableController {


    private static long selectedItemId;
    @FXML
    private TableView<Zlecenia> tableZlecenia;

    @FXML
    private TableColumn<Zlecenia, Integer> colIdZlecenia;

    @FXML
    private TableColumn<Zlecenia, Integer> colIKlienta;

    @FXML
    private TableColumn<Zlecenia, Integer> colNaklad;

    @FXML
    private TableColumn<Zlecenia, Integer> colGramatura;

    @FXML
    private TableColumn<Zlecenia, Double> colCenaZaKg;

    @FXML
    private TableColumn<Zlecenia, Double> colWagaPapieru;

    @FXML
    private TableColumn<Zlecenia, Double> colCenaPapieru;

    @FXML
    private TableColumn<Zlecenia, Integer> colArkDoDruku;

    @FXML
    private TableColumn<Zlecenia, Integer> colFormatDoDruku;

    @FXML
    private TableColumn<Zlecenia, Integer> colFormatUlotki;

    @FXML
    private TableColumn<Zlecenia, String> colRodzajPapieru;

    @FXML
    private Button BackBtn;

    @FXML
    private Button pokazBtn;

    @FXML
    void BackClick(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/adminView.fxml"));
        adminStage.setTitle("Panel administratora");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene().getWindow().hide();

    }

    @FXML
    void pokazClick(MouseEvent event) throws IOException {


        long id = tableZlecenia.getSelectionModel().getSelectedItem().getId_zlecenia();
        KalkulacjaController.selectedItemId = id;

        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/kalkulacjaView.fxml"));
        adminStage.setTitle("Kalkulacja");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene().getWindow().hide();

    }

    public void initialize() {



        DBConnector db = new DBConnector();
        //-- Pobranie danych z bazy danych z tabeli user i dodanie do TableView na widoku
        ZleceniaService zleceniaService = new ZleceniaService();
        List<Zlecenia> zlecenia = zleceniaService.getAllZlecenia();
       // Zlecenia zlecenia = zleceniaService.znajdzPoId(selectedItemId);

        ObservableList<Zlecenia> allZlecenia = FXCollections.observableArrayList(zlecenia);
        tableZlecenia.setItems(null);
        tableZlecenia.setItems(allZlecenia);
        //------

       /*
        if (selectedItemId > 0) {
            ZleceniaService zleceniaService = new ZleceniaService();
            Zlecenia zlecenia = zleceniaService.znajdzPoId(selectedItemId);
*/
            // wskazanie kolumn do wyświetlenia z naszego modelu
            colIdZlecenia.setCellValueFactory(new PropertyValueFactory<Zlecenia, Integer>("id_zlecenia"));
            colIKlienta.setCellValueFactory(new PropertyValueFactory<Zlecenia, Integer>("Klienci_id_klienta"));
            colNaklad.setCellValueFactory(new PropertyValueFactory<Zlecenia, Integer>("naklad"));
            colGramatura.setCellValueFactory(new PropertyValueFactory<Zlecenia, Integer>("gramatura"));
            colCenaZaKg.setCellValueFactory(new PropertyValueFactory<Zlecenia, Double>("cena_za_kg"));
            colWagaPapieru.setCellValueFactory(new PropertyValueFactory<Zlecenia, Double>("waga_papieru"));
            colCenaPapieru.setCellValueFactory(new PropertyValueFactory<Zlecenia, Double>("cena_papieru"));
            colArkDoDruku.setCellValueFactory(new PropertyValueFactory<Zlecenia, Integer>("ilosc_arkuszy_do_druku"));
            colFormatDoDruku.setCellValueFactory(new PropertyValueFactory<Zlecenia, Integer>("formatDoDruku")); //zaciągają się całe wiersze
            colFormatUlotki.setCellValueFactory(new PropertyValueFactory<Zlecenia, Integer>("formatUlotki"));  //zaciągają się całe wiersze
            colRodzajPapieru.setCellValueFactory(new PropertyValueFactory<Zlecenia, String>("rodzajPapieru"));  //zaciągają się całe wiersze
//            colFormatUlotki.setText(String.valueOf(zlecenia.getId_u().getFormat()));   //----- dlaczego to nie działa? A działa w KalkulacjaController? Id_u świeci się na czerwono
//            colFormatDoDruku.setText(String.valueOf(zlecenia.getId_fp().getNazwa()));  //----- dlaczego to nie działa? A działa w KalkulacjaController? Id_fp świeci się na czerwono
//            colRodzajPapieru.setText(String.valueOf(zlecenia.getId_p().getRodzaj_papieru()))   //----- dlaczego to nie działa? A działa w KalkulacjaController? Id_p świeci się na czerwono
            //colRodzajPapieru.setText(String.valueOf(zlecenia.getId_p().getRodzaj_papieru()));

        }
    }
