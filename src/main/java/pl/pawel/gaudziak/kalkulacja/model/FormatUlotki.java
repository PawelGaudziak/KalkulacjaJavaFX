package pl.pawel.gaudziak.kalkulacja.model;

import javax.persistence.*;

@Entity(name = "FormatUlotki")
@Table(name = "format_ulotki")
public class FormatUlotki {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_u")
    private Integer id;

    private String Format;

    public FormatUlotki() {
    }

    public FormatUlotki(String format) {
        this.Format = format;
    }

    public FormatUlotki(Integer id, String format) {
        this.id = id;
        this.Format = format;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    @Override
    public String toString() {
        return "FormatUlotki{" +
               "id=" + id +
               ", Format='" + Format + '\'' +
               '}';
    }
}
