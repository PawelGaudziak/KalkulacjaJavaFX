package pl.pawel.gaudziak.kalkulacja.service;

import org.hibernate.Session;
import pl.pawel.gaudziak.kalkulacja.model.FormatPapUlotka;
import pl.pawel.gaudziak.kalkulacja.model.FormatPapieru;
import pl.pawel.gaudziak.kalkulacja.model.Zlecenia;
import pl.pawel.gaudziak.kalkulacja.utils.HibernateUtils;

import java.util.List;

public class KalkulacjaService {

    public int policzIloscArkDoDruku(int zlecenieId, int formatDoDrukuIdAdmin) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        Zlecenia zlecenie = znajdzZlecenie(zlecenieId, session);

        FormatPapUlotkaService formatPapUlotkaService = new FormatPapUlotkaService();

        FormatPapUlotka formatPapUlotka = formatPapUlotkaService.znajdzFormatPapUlotkoa(formatDoDrukuIdAdmin, zlecenie.getId_u().getId());

        int iloscArkuszuDoDruku = (int) Math.ceil((float) zlecenie.getNaklad() / (float) formatPapUlotka.getIlosc_ul_arkusz());

        session.close();
        return iloscArkuszuDoDruku;
    }

    public float policzWagaPapieru(int zlecenieId, int formatDoDrukuIdAdmin) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        Zlecenia zlecenie = znajdzZlecenie(zlecenieId, session);

        FormatPapieruService formatPapieruService = new FormatPapieruService();
        FormatPapieru formatPapieru = formatPapieruService.znajdzPoId(formatDoDrukuIdAdmin);

        FormatPapUlotkaService formatPapUlotkaService = new FormatPapUlotkaService();
        FormatPapUlotka formatPapUlotka = formatPapUlotkaService.znajdzFormatPapUlotkoa(formatDoDrukuIdAdmin, zlecenie.getId_u().getId());

        float waga = zlecenie.getGramatura() * formatPapieru.getWsp().floatValue() * zlecenie.getNaklad()
                / formatPapUlotka.getIlosc_ul_arkusz() / 1000;

        session.close();
        return waga;
    }

    private Zlecenia znajdzZlecenie(int zlecenieId, Session session) {
        List<Zlecenia> zleceniaList = session.createSQLQuery("SELECT * FROM zlecenia WHERE id_zlecenia= :zlecenieId")
                .addEntity(Zlecenia.class)
                .setParameter("zlecenieId", zlecenieId)
                .list();
        return zleceniaList.get(0);
    }
}
