package pl.pawel.gaudziak.kalkulacja.model;

import javax.persistence.*;

@Entity
@Table(name="klienci")
public class Klienci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_klienta;

    private String imie;
    private String nazwisko;
    private String login;
    private String haslo;
    private String e_mail;
    private String nazwa_firmy;
    private Integer NIP;
    private Integer nr_telefonu;
    //private
}
