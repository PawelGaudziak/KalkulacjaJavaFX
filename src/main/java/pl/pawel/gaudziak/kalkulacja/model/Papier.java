package pl.pawel.gaudziak.kalkulacja.model;

import javax.persistence.*;

@Entity(name = "Papier")
@Table(name = "papier")
public class Papier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_p;

    private String Rodzaj_papieru;

    public Papier() {
    }

    public Papier(String rodzaj_papieru) {
        this.Rodzaj_papieru = rodzaj_papieru;
    }

    public Papier(Long id_p, String rodzaj_papieru) {
        this.id_p = id_p;
        this.Rodzaj_papieru = rodzaj_papieru;
    }

    public Long getId_p() {
        return id_p;
    }

    public void setId_p(Long id_p) {
        this.id_p = id_p;
    }

    public String getRodzaj_papieru() {
        return Rodzaj_papieru;
    }

    public void setRodzaj_papieru(String rodzaj_papieru) {
        Rodzaj_papieru = rodzaj_papieru;
    }

    @Override
    public String toString() {
        return "Papier{" +
               "id_p=" + id_p +
               ", Rodzaj_papieru='" + Rodzaj_papieru + '\'' +
               '}';
    }
}
