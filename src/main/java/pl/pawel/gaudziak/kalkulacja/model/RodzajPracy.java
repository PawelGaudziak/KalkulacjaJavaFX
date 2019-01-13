package pl.pawel.gaudziak.kalkulacja.model;

import javax.persistence.*;

@Entity(name="RodzajPracy")
@Table(name="rodzaj_pracy")
public class RodzajPracy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_r;

    private String rodzaj;

    public RodzajPracy() {
    }

    public RodzajPracy(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public RodzajPracy(Long id_r, String rodzaj) {
        this.id_r = id_r;
        this.rodzaj = rodzaj;
    }

    public Long getId_r() {
        return id_r;
    }

    public void setId_r(Long id_r) {
        this.id_r = id_r;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    @Override
    public String toString() {
        return "RodzajPracy{" +
                "id_r=" + id_r +
                ", rodzaj='" + rodzaj + '\'' +
                '}';
    }
}

