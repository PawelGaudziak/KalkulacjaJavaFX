package pl.pawel.gaudziak.kalkulacja.service;

import org.hibernate.Session;
import pl.pawel.gaudziak.kalkulacja.model.FormatPapUlotka;
import pl.pawel.gaudziak.kalkulacja.utils.HibernateUtils;

import java.util.List;

public class FormatPapUlotkaService {

    public FormatPapUlotka znajdzFormatPapUlotkoa(int formatDoDrukuIdAdmin, int formatUlotkiIdUzytkownik) {
        Session session = HibernateUtils.getSessionFactory()
                .openSession();
        List<FormatPapUlotka> list = session.createSQLQuery(
                "SELECT * FROM format_pap_ulotka WHERE FPU_id_u = :odUzytkownika AND FPU_id_fp = :odAdmina")
                .addEntity(FormatPapUlotka.class)
                .setParameter("odUzytkownika", formatUlotkiIdUzytkownik)
                .setParameter("odAdmina", formatDoDrukuIdAdmin)
                .list();
        session.close();
        return list.get(0);
    }
}
