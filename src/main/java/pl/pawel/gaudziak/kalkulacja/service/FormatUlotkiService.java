package pl.pawel.gaudziak.kalkulacja.service;

import org.hibernate.Session;
import pl.pawel.gaudziak.kalkulacja.model.FormatUlotki;
import pl.pawel.gaudziak.kalkulacja.utils.HibernateUtils;

import java.util.List;

public class FormatUlotkiService {

    public List<FormatUlotki> lista() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List list = session
                .createSQLQuery("SELECT * FROM format_ulotki")
                .addEntity(FormatUlotki.class)
                .list();
        return list;
    }

    public FormatUlotki znajdzPoId(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<FormatUlotki> list = session
                .createSQLQuery("SELECT * FROM format_ulotki WHERE id_u = :id")
                .addEntity(FormatUlotki.class)
                .setParameter("id", id)
                .list();
        return list.get(0);
    }
}
