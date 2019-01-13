package pl.pawel.gaudziak.kalkulacja.model;

import javax.persistence.*;

@Entity(name = "FormatPapUlotka")
@Table(name = "format_pap_ulotka")
public class FormatPapUlotka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FPU_id_fp")
    private FormatPapieru id_fp;

    @ManyToOne
    @JoinColumn(name = "nazwa")
    private FormatPapieru nazwa;

    @ManyToOne
    @JoinColumn(name = "FPU_id_u")
    private FormatUlotki id_u;

    private Integer ilosc_ul_arkusz;

    public FormatPapUlotka() {
    }

    public FormatPapUlotka(FormatPapieru id_fp, FormatUlotki id_u, Integer ilosc_ul_arkusz) {
        this.id_fp = id_fp;
        this.id_u = id_u;
        this.ilosc_ul_arkusz = ilosc_ul_arkusz;
    }

    public FormatPapUlotka(Long id, FormatPapieru id_fp, FormatUlotki id_u, Integer ilosc_ul_arkusz) {
        this.id = id;
        this.id_fp = id_fp;
        this.id_u = id_u;
        this.ilosc_ul_arkusz = ilosc_ul_arkusz;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FormatPapieru getId_fp() {
        return id_fp;
    }

    public void setId_fp(FormatPapieru id_fp) {
        this.id_fp = id_fp;
    }

    public FormatUlotki getId_u() {
        return id_u;
    }

    public void setId_u(FormatUlotki id_u) {
        this.id_u = id_u;
    }

    public Integer getIlosc_ul_arkusz() {
        return ilosc_ul_arkusz;
    }

    public void setIlosc_ul_arkusz(Integer ilosc_ul_arkusz) {
        this.ilosc_ul_arkusz = ilosc_ul_arkusz;
    }

    @Override
    public String toString() {
        return "FormatPapUlotka{" +
               "id=" + id +
               ", id_fp=" + id_fp +
               ", id_u=" + id_u +
               ", ilosc_ul_arkusz=" + ilosc_ul_arkusz +
               '}';
    }
}
