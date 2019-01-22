package pl.pawel.gaudziak.kalkulacja.model;

import javax.persistence.*;

@Entity(name = "Zlecenia")
@Table(name = "zlecenia")
public class Zlecenia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_zlecenia;

    @ManyToOne
    @JoinColumn(name = "Klienci_id_klienta")
    private User id_klienta;

    private Integer naklad;
    private Integer gramatura;
    private Double cena_za_kg;
    private Double waga_papieru;
    private Double cena_papieru;
    private Integer ilosc_arkuszy_do_druku;

    @ManyToOne
    @JoinColumn(name = "Papier_id_p")
    private Papier id_p;

    @Transient
    private String rodzajPapieru;


    @ManyToOne
    @JoinColumn(name = "Rodzaj_pracy_id_r")
    private RodzajPracy id_r;

    @ManyToOne
    @JoinColumn(name = "z_format_pap_ulotka")
    private FormatPapUlotka id;

    @Transient
    private  String formatDoDruku;

    @Transient
    private String formatUlotki;

    @ManyToOne
    @JoinColumn(name = "Format_ulotki_id_u")
    private FormatUlotki id_u;

    public Zlecenia() {
    }

    public Zlecenia(User id_klienta, Integer naklad, Integer gramatura, Papier id_p, RodzajPracy id_r, FormatUlotki id_u) {
        this.id_klienta = id_klienta;
        this.naklad = naklad;
        this.gramatura = gramatura;
        this.id_p = id_p;
        this.id_r = id_r;
        this.id_u = id_u;
    }

    public Zlecenia(User id_klienta, Integer naklad, Integer gramatura, Double cena_za_kg, Double waga_papieru, Double cena_papieru, Integer ilosc_arkuszy_do_druku,
                    Papier id_p, RodzajPracy id_r, FormatPapUlotka id, FormatUlotki id_u) {
        this.id_klienta = id_klienta;
        this.naklad = naklad;
        this.gramatura = gramatura;
        this.cena_za_kg = cena_za_kg;
        this.waga_papieru = waga_papieru;
        this.cena_papieru = cena_papieru;
        this.ilosc_arkuszy_do_druku = ilosc_arkuszy_do_druku;
        this.id_p = id_p;
        this.id_r = id_r;
        this.id = id;
        this.id_u = id_u;
        //this.nazwa = nazwa;
    }

    public Zlecenia(Long id_zlecenia, User id_klienta, Integer naklad, Integer gramatura, Double cena_za_kg, Double waga_papieru, Double cena_papieru,
                    Integer ilosc_arkuszy_do_druku,
                    Papier id_p, RodzajPracy id_r, FormatPapUlotka id, FormatUlotki id_u) {
        this.id_zlecenia = id_zlecenia;
        this.id_klienta = id_klienta;
        this.naklad = naklad;
        this.gramatura = gramatura;
        this.cena_za_kg = cena_za_kg;
        this.waga_papieru = waga_papieru;
        this.cena_papieru = cena_papieru;
        this.ilosc_arkuszy_do_druku = ilosc_arkuszy_do_druku;
        this.id_p = id_p;
        this.id_r = id_r;
        this.id = id;
        this.id_u = id_u;
    }

    public Long getId_zlecenia() {
        return id_zlecenia;
    }

    public void setId_zlecenia(Long id_zlecenia) {
        this.id_zlecenia = id_zlecenia;
    }

    public Integer getId_klienta() {
        return id_klienta.getId_klienta();
    }
    public String getEmail_klienta() { return id_klienta.getE_mail(); }


    public void setId_klienta(User id_klienta) {
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

    public Papier getId_p() {
        return id_p;
    }

    public void setId_p(Papier id_p) {
        this.id_p = id_p;
    }

    public RodzajPracy getId_r() {
        return id_r;
    }

    public void setId_r(RodzajPracy id_r) {
        this.id_r = id_r;
    }

    public FormatPapUlotka getId() {
        return id;
    }

    public void setId(FormatPapUlotka id) {
        this.id = id;
    }

    public FormatUlotki getId_u() {
        return id_u;
    }

    public void setId_u(FormatUlotki id_u) {
        this.id_u = id_u;
    }

    public String getRodzajPapieru() {
        if (id_r != null) {
            rodzajPapieru = id_p.getRodzaj_papieru();
        }
        return rodzajPapieru;
    }

    public String getFormatUlotki() {
        if (id_u != null) {
            formatUlotki = id_u.getFormat();
        }
        return formatUlotki;
    }


    public String getFormatDoDruku() {
        if (id != null) {
            formatDoDruku = id.getId_fp().getNazwa();
        }
        return formatDoDruku;
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
               ", id_p=" + id_p +
               ", id_r=" + id_r +
               ", id=" + id +
               ", id_u=" + id_u +
               '}';
    }
}