package pl.pawel.gaudziak.kalkulacja.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "FormatPapieru")
@Table(name = "formatpapieru")
public class FormatPapieru {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fp")
    private Integer id;

    private String nazwa;

    private BigDecimal wsp;

    public FormatPapieru() {
    }

    public FormatPapieru(String nazwa, BigDecimal wsp) {
        this.nazwa = nazwa;
        this.wsp = wsp;
    }

    public FormatPapieru(Integer id, String nazwa, BigDecimal wsp) {
        this.id = id;
        this.nazwa = nazwa;
        this.wsp = wsp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public BigDecimal getWsp() {
        return wsp;
    }

    public void setWsp(BigDecimal wsp) {
        this.wsp = wsp;
    }

    @Override
    public String toString() {
        return "FormatPapieru{" +
               "id=" + id +
               ", nazwa='" + nazwa + '\'' +
               ", wsp=" + wsp +
               '}';
    }
}
