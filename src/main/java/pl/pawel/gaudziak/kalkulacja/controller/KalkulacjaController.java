package pl.pawel.gaudziak.kalkulacja.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.pawel.gaudziak.kalkulacja.database.DBConnector;
import pl.pawel.gaudziak.kalkulacja.model.FormatPapUlotka;
import pl.pawel.gaudziak.kalkulacja.model.FormatPapieru;
import pl.pawel.gaudziak.kalkulacja.model.Zlecenia;
import pl.pawel.gaudziak.kalkulacja.service.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class KalkulacjaController {
    static long selectedItemId;

    @FXML
    private Label tytul;

    @FXML
    private Label kIDzlecenia;

    @FXML
    private Label kNaklad;

    @FXML
    private Label kGramatura;

    @FXML
    private TextField kFormatUlotkiOkno;

    @FXML
    private Label kCenaZaKg;

    @FXML
    private Label kRodzajPapieru;

    @FXML
    private Label kFormatDoDruku;

    @FXML
    private Label kWagaPapieru;

    @FXML
    private Label kCenaPapieru;

    @FXML
    private Label kIloscArkuszyDoDruku;

    @FXML
    private Label kMailKlienta;

    @FXML
    private TextField kRodzajPapieruOkno;

    @FXML
    private TextField kIDzleceniaOkno;

    @FXML
    private TextField kNakladOkno;

    @FXML
    private TextField kGramaturaOkno;

    @FXML
    private TextField kCenaZaKgOkno;

    @FXML
    private ComboBox<String> kCombo;
    ObservableList<String> formatDruk = FXCollections.observableArrayList("A1+", "A2+");

    @FXML
    private TextField kWagaPapieruOkno;

    @FXML
    private TextField kCenaPapieruOkno;

    @FXML
    private TextField kIloscArkuszyDoDrukuOkno;

    @FXML
    private TextField kMailKlientaOkno;

    @FXML
    private Button kPokazZleceniaBtn;

    @FXML
    private Button kEkranAdminBtn;

    @FXML
    private Button kExitBtn;

    @FXML
    private Button kPoliczBtn;

    @FXML
    private Button kZapiszBtn;

    @FXML
    private Button kWyslijBtn;
    private DBConnector db;
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#0.00");

    @FXML
    void kEkranAdminClick(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/adminView.fxml"));
        adminStage.setTitle("okno admina");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

    @FXML
    void kExitClick(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void kPoliczClick(MouseEvent event) throws SQLException {
        KalkulacjaService service = new KalkulacjaService();

        Integer zlecenieId = Integer.valueOf(kIDzleceniaOkno.getText());

        FormatPapieruService formatPapieruService = new FormatPapieruService();
        FormatPapieru formatPapieru = formatPapieruService.znajdzPoNazwie(kCombo.getValue());

        int iloscArkDoDruku = service.policzIloscArkDoDruku(zlecenieId, formatPapieru.getId());
        float waga = service.policzWagaPapieru(zlecenieId, formatPapieru.getId());
        float cenaPapieru = waga * Float.valueOf(kCenaZaKgOkno.getText());

        kIloscArkuszyDoDrukuOkno.setText(String.valueOf(iloscArkDoDruku));
        kWagaPapieruOkno.setText(DECIMAL_FORMAT.format(waga));
        kCenaPapieruOkno.setText(DECIMAL_FORMAT.format(cenaPapieru));
    }

    //"update zlecenia set ilosc_arkuszy_do_druku=188 where id_zlecenia=6;");
    private String getFormData() {


        String naklad = kNakladOkno.getText();
        String gramatura = kGramaturaOkno.getText();
        String cenaZaKg = kCenaZaKgOkno.getText();
        String iloscDoDruku = kIloscArkuszyDoDrukuOkno.getText();
        String waga = kWagaPapieruOkno.getText();
        String cena = kCenaPapieruOkno.getText();

        return "Nakład: " + naklad + " sztuk" + "\n"
                + "gramatura: " + gramatura + " g"+"\n"
                + "ilość arkuszy do druku: " +  iloscDoDruku + "\n"
                + "waga papieru: " + waga + " kg" + "\n"
                + "cena papieru: " + cena +" zł";
    }

    @FXML
    void kWyslijClick(MouseEvent event) throws MessagingException {

        MailService mailService = new MailService();
        mailService.sendMail(kMailKlientaOkno.getText(), "Zlecenie", getFormData());
    }

    @FXML
    void kZapiszClick(MouseEvent event) {
        ZleceniaService zleceniaService = new ZleceniaService();
        Zlecenia zlecenie = zleceniaService.znajdzPoId(Integer.valueOf(kIDzleceniaOkno.getText()));

        FormatPapieruService formatPapieruService = new FormatPapieruService();
        FormatPapieru formatPapieru = formatPapieruService.znajdzPoNazwie(kCombo.getValue());

        FormatPapUlotkaService formatPapUlotkaService = new FormatPapUlotkaService();
        FormatPapUlotka formatPapUlotka = formatPapUlotkaService.znajdzFormatPapUlotkoa(formatPapieru.getId(), zlecenie.getId_u().getId());

        zlecenie.setCena_za_kg(getAsDouble(kCenaZaKgOkno));
        zlecenie.setId(formatPapUlotka);
        zlecenie.setWaga_papieru(getAsDouble(kWagaPapieruOkno));
        zlecenie.setCena_papieru(getAsDouble(kCenaPapieruOkno));
        zlecenie.setIlosc_arkuszy_do_druku(Integer.valueOf(kIloscArkuszyDoDrukuOkno.getText()));

        zleceniaService.update(zlecenie);
    }

    private Double getAsDouble(TextField edit) {
        return Double.valueOf(edit.getText().replace(",","."));
    }

    private String formatDouble(String text) {
        return DECIMAL_FORMAT.format(Double.valueOf(text));
    }

    @FXML
    void kZleceniaClick(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/zleceniaView.fxml"));
        adminStage.setTitle("Lista wszystkich zleceń");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }


    public void initialize() {

        //wstawia do tabelki javy wartości ze zleceń

        DBConnector db = new DBConnector();
        // zFormatUlotkiCombo.
       // kCombo.setItems(formatDruk);


        if (selectedItemId > 0) {
            ZleceniaService zleceniaService = new ZleceniaService();
            Zlecenia zlecenia = zleceniaService.znajdzPoId(selectedItemId);

            kIDzleceniaOkno.setText(String.valueOf(zlecenia.getId_zlecenia()));
            kNakladOkno.setText(String.valueOf(zlecenia.getNaklad()));
            kGramaturaOkno.setText(String.valueOf(zlecenia.getGramatura()));
            kFormatUlotkiOkno.setText(String.valueOf(zlecenia.getId_u().getFormat()));
            kRodzajPapieruOkno.setText(String.valueOf(zlecenia.getId_p().getRodzaj_papieru()));
            kMailKlientaOkno.setText(String.valueOf(zlecenia.getId_klienta().getE_mail()));
            kCenaPapieruOkno.setText(String.valueOf(zlecenia.getCena_papieru()));
            kWagaPapieruOkno.setText(String.valueOf(zlecenia.getWaga_papieru()));
            kIloscArkuszyDoDrukuOkno.setText(String.valueOf(zlecenia.getIlosc_arkuszy_do_druku()));
            kCenaZaKgOkno.setText(String.valueOf(zlecenia.getCena_za_kg()));

            // uzupelnij cena, format waga ilosc itp jezeli jest w bazie danych

            FormatPapieruService formatPapieruService = new FormatPapieruService();
            kCombo.getItems().clear();
            for (FormatPapieru fp : formatPapieruService.lista()) {
                kCombo.getItems().add(fp.getNazwa());
            }

            //kMailKlientaOkno.setText(user.getE_mail());


        }
    }
}
