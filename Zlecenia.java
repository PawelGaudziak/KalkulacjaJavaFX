package pl.pawel.gaudziak.kalkulacja.model;

import javafx.collections.ObservableList;

import javax.persistence.*;

@Entity
@Table(name="zlecenia")
public class Zlecenia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_zlecenia;

   // Jak dodasz model klienta to wtedy będziesz mógł to podpiąć.
//    @ManyToOne
//    @JoinColumn(name = "id_klienta")
//    private Klienci id_klienta;
    private Long id_klienta;
    private Integer naklad;
    private Integer gramatura;
    private Double cena_za_kg;
    private Double waga_papieru;
    private Double cena_papieru;
    private Integer ilosc_arkuszy_do_druku;
    private Boolean format_do_druku;
    private Boolean format_ulotki;


    //public Zlecenia(String naklad, String gramatura, String combo) {


    public Zlecenia(Long id_klienta, Integer naklad, Integer gramatura, Double cena_za_kg, Double waga_papieru, Double cena_papieru, Integer ilosc_arkuszy_do_druku, Boolean format_do_druku, Boolean format_ulotki) {
        this.id_klienta = id_klienta;
        this.naklad = naklad;
        this.gramatura = gramatura;
        this.cena_za_kg = cena_za_kg;
        this.waga_papieru = waga_papieru;
        this.cena_papieru = cena_papieru;
        this.ilosc_arkuszy_do_druku = ilosc_arkuszy_do_druku;
        this.format_do_druku = format_do_druku;
        this.format_ulotki = format_ulotki;
    }

    public Zlecenia(Long id_zlecenia, Long id_klienta, Integer naklad, Integer gramatura, Double cena_za_kg, Double waga_papieru, Double cena_papieru, Integer ilosc_arkuszy_do_druku, Boolean format_do_druku, Boolean format_ulotki) {
        this.id_zlecenia = id_zlecenia;
        this.id_klienta = id_klienta;
        this.naklad = naklad;
        this.gramatura = gramatura;
        this.cena_za_kg = cena_za_kg;
        this.waga_papieru = waga_papieru;
        this.cena_papieru = cena_papieru;
        this.ilosc_arkuszy_do_druku = ilosc_arkuszy_do_druku;
        this.format_do_druku = format_do_druku;
        this.format_ulotki = format_ulotki;
    }

    public Long getId_zlecenia() {
        return id_zlecenia;
    }

    public void setId_zlecenia(Long id_zlecenia) {
        this.id_zlecenia = id_zlecenia;
    }

    public Long getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(Long id_klienta) {
        this.id_klienta = id_klienta;
    }

    public Integer getNaklad() {
        return naklad;
    }

    public void setNaklad(Integer naklad) {
        this.naklad = naklad;
    }

    public Integer getGramatura() {
        return gramatura;
    }

    public void setGramatura(Integer gramatura) {
        this.gramatura = gramatura;
    }

    public Double getCena_za_kg() {
        return cena_za_kg;
    }

    public void setCena_za_kg(Double cena_za_kg) {
        this.cena_za_kg = cena_za_kg;
    }

    public Double getWaga_papieru() {
        return waga_papieru;
    }

    public void setWaga_papieru(Double waga_papieru) {
        this.waga_papieru = waga_papieru;
    }

    public Double getCena_papieru() {
        return cena_papieru;
    }

    public void setCena_papieru(Double cena_papieru) {
        this.cena_papieru = cena_papieru;
    }

    public Integer getIlosc_arkuszy_do_druku() {
        return ilosc_arkuszy_do_druku;
    }

    public void setIlosc_arkuszy_do_druku(Integer ilosc_arkuszy_do_druku) {
        this.ilosc_arkuszy_do_druku = ilosc_arkuszy_do_druku;
    }

    public Boolean isFormat_do_druku() {
        return format_do_druku;
    }

    public void setFormat_do_druku(Boolean format_do_druku) {
        this.format_do_druku = format_do_druku;
    }

    public Boolean isFormat_ulotki() {
        return format_ulotki;
    }

    public void setFormat_ulotki(Boolean format_ulotki) {
        this.format_ulotki = format_ulotki;
    }

    @Override
    public String toString() {
        return "Zlecenia{" +
                "id_zlecenia=" + id_zlecenia +
                ", id_klienta=" + id_klienta +
                ", naklad=" + naklad +
                ", gramatura=" + gramatura +
                ", cena_za_kg=" + cena_za_kg +
                ", waga_papieru=" + waga_papieru +
                ", cena_papieru=" + cena_papieru +
                ", ilosc_arkuszy_do_druku=" + ilosc_arkuszy_do_druku +
                ", format_do_druku=" + format_do_druku +
                ", format_ulotki=" + format_ulotki +
                '}';
    }
}