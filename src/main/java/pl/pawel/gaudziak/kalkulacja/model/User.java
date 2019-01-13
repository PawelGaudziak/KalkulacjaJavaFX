package pl.pawel.gaudziak.kalkulacja.model;

import javax.persistence.*;

@Entity
@Table(name = "klienci")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_klienta;

    private String login;
    private String haslo;
    private String imie;
    private String nazwisko;
    private String nazwa_firmy;
    private String e_mail;
    private int NIP;
    private int nr_telefonu;
    private String adres_firmy_ulica;
    private String adres_firmy_kod;
    private String adres_firmy_miasto;

    public User(){

    }

    public User(String login, String haslo, String imie, String nazwisko, String nazwa_firmy, String e_mail, int NIP, int nr_telefonu, String adres_firmy_ulica, String adres_firmy_kod, String adres_firmy_miasto) {
        this.login = login;
        this.haslo = haslo;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nazwa_firmy = nazwa_firmy;
        this.e_mail = e_mail;
        this.NIP = NIP;
        this.nr_telefonu = nr_telefonu;
        this.adres_firmy_ulica = adres_firmy_ulica;
        this.adres_firmy_kod = adres_firmy_kod;
        this.adres_firmy_miasto = adres_firmy_miasto;
    }

    public User(int id_klienta, String login, String haslo, String imie, String nazwisko, String nazwa_firmy, String e_mail, int NIP, int nr_telefonu, String adres_firmy_ulica, String adres_firmy_kod, String adres_firmy_miasto) {
        this.id_klienta = id_klienta;
        this.login = login;
        this.haslo = haslo;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nazwa_firmy = nazwa_firmy;
        this.e_mail = e_mail;
        this.NIP = NIP;
        this.nr_telefonu = nr_telefonu;
        this.adres_firmy_ulica = adres_firmy_ulica;
        this.adres_firmy_kod = adres_firmy_kod;
        this.adres_firmy_miasto = adres_firmy_miasto;
    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNazwa_firmy() {
        return nazwa_firmy;
    }

    public void setNazwa_firmy(String nazwa_firmy) {
        this.nazwa_firmy = nazwa_firmy;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public int getNIP() {
        return NIP;
    }

    public void setNIP(int NIP) {
        this.NIP = NIP;
    }

    public int getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(int nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public String getAdres_firmy_ulica() {
        return adres_firmy_ulica;
    }

    public void setAdres_firmy_ulica(String adres_firmy_ulica) {
        this.adres_firmy_ulica = adres_firmy_ulica;
    }

    public String getAdres_firmy_kod() {
        return adres_firmy_kod;
    }

    public void setAdres_firmy_kod(String adres_firmy_kod) {
        this.adres_firmy_kod = adres_firmy_kod;
    }

    public String getAdres_firmy_miasto() {
        return adres_firmy_miasto;
    }

    public void setAdres_firmy_miasto(String adres_firmy_miasto) {
        this.adres_firmy_miasto = adres_firmy_miasto;
    }
}

