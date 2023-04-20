package urlshorter.link;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import urlshorter.util.HibernateUtil;

import java.util.List;

public class HibernateLinkService implements LinkService{
    @Override
    public Link getByShortLink(String shortLink) {
        Link result;
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            result = session.get(Link.class, shortLink);
            transaction.commit();
        }
        return result;
    }

    @Override
    public void save(Link link) {
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(link);
            transaction.commit();
        }
    }

    @Override
    public void deleteByShortLink(String shortLink) {
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(getByShortLink(shortLink));
            transaction.commit();
        }
    }

    @Override
    public List<Link> listAll() {
        List<Link> result;
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            result = session.createQuery("from Link", Link.class).list();
            transaction.commit();
        }
        return result;
    }

    @Override
    public List<Link> search(String query) {
        List<Link> result;
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "from Link where shortLink like '%" + query + "%' or link like '%" + query + "%'";
            result = session.createQuery(hql, Link.class).list();
            transaction.commit();
        }
        return result;
    }

    private Session openSession() {
        return HibernateUtil.buildSessionFactory().openSession();
    }
}
