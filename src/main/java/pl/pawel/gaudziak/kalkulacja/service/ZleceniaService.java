package pl.pawel.gaudziak.kalkulacja.service;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pawel.gaudziak.kalkulacja.model.FormatUlotki;
import pl.pawel.gaudziak.kalkulacja.model.Papier;
import pl.pawel.gaudziak.kalkulacja.model.RodzajPracy;
import pl.pawel.gaudziak.kalkulacja.model.Zlecenia;
import pl.pawel.gaudziak.kalkulacja.utils.HibernateUtils;

import java.util.List;

public class ZleceniaService {

    public List<Zlecenia> getAllZlecenia() {
        Session session = HibernateUtils.getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();

        List<Zlecenia> zlecenia = session.createQuery("SELECT k FROM Zlecenia k")
                .list();

        transaction.commit();
        session.close();
        return zlecenia;
    }

    public long save(Zlecenia zlecenia) {
        Session session = HibernateUtils.getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();

        long id = (Long) session.save(zlecenia);

        transaction.commit();
        session.close();
        return id;
    }

    public void update(Zlecenia zlecenia) {
        Session session = HibernateUtils.getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();

        session.update(zlecenia);

        transaction.commit();
        session.close();
    }

    public FormatUlotki getFormatUlotki(String formatUlotki) {
        Session session = HibernateUtils.getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();

        SQLQuery sqlQuery = session.createSQLQuery("Select * from format_ulotki where Format=:format");
        sqlQuery.setString("format", formatUlotki);
        sqlQuery.setMaxResults(1);
        sqlQuery.addEntity(FormatUlotki.class);
        FormatUlotki formatUlotki1 = (FormatUlotki) sqlQuery.uniqueResult();

        transaction.commit();
        session.close();
        return formatUlotki1;
    }

    public Papier getRodzajPapieru(String rodzajPapieru) {
        Session session = HibernateUtils.getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();

        SQLQuery sqlQuery = session.createSQLQuery("Select * from papier where Rodzaj_papieru=:nazwa");
        sqlQuery.setString("nazwa", rodzajPapieru);
        sqlQuery.setMaxResults(1);
        sqlQuery.addEntity(Papier.class);
        Papier papier = (Papier) sqlQuery.uniqueResult();

        transaction.commit();
        session.close();
        return papier;
    }

    public Zlecenia znajdzPoId(long id) {
        Session session = HibernateUtils.getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();

        Zlecenia zlecenia = (Zlecenia) session.get(Zlecenia.class, id);

        transaction.commit();
        session.close();
        return zlecenia;
    }

    public RodzajPracy getRodzajPracy(String praca) {

        Session session = HibernateUtils.getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();

        SQLQuery sqlQuery = session.createSQLQuery("Select * from rodzaj_pracy where rodzaj=:rodzaj");
        sqlQuery.setString("rodzaj", praca);
        sqlQuery.setMaxResults(1);
        sqlQuery.addEntity(RodzajPracy.class);
        RodzajPracy rodzajPracy = (RodzajPracy) sqlQuery.uniqueResult();

        transaction.commit();
        session.close();
        return rodzajPracy;
    }
}
