package pl.pawel.gaudziak.kalkulacja.service;

import org.hibernate.Session;
import pl.pawel.gaudziak.kalkulacja.model.FormatPapieru;
import pl.pawel.gaudziak.kalkulacja.utils.HibernateUtils;

import java.util.List;

public class FormatPapieruService {

    public List<FormatPapieru> lista() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<FormatPapieru> list = session
                .createSQLQuery("SELECT * FROM formatpapieru")
                .addEntity(FormatPapieru.class)
                .list();
        session.close();
        return list;
    }

    public FormatPapieru znajdzPoNazwie(String nazwa) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<FormatPapieru> list = session
                .createSQLQuery("SELECT * FROM formatpapieru WHERE nazwa = :nazwa")
                .addEntity(FormatPapieru.class)
                .setParameter("nazwa", nazwa)
                .list();
        session.close();
        return list.get(0);
    }

    public FormatPapieru znajdzPoId(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<FormatPapieru> list = session
                .createSQLQuery("SELECT * FROM formatpapieru WHERE id_fp = :id")
                .addEntity(FormatPapieru.class)
                .setParameter("id", id)
                .list();
        session.close();
        return list.get(0);
    }
}
