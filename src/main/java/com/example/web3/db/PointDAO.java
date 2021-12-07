package com.example.web3.db;

import com.example.web3.models.Point;
import com.example.web3.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PointDAO implements DAO {
    @Override
    public boolean addPoint(Point result) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(result);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Point> getAll() {
//        System.out.println(HibernateSessionFactory.getSessionFactory().openSession()
//                .createQuery("Select point From Point point"));
        @SuppressWarnings("unchecked")
        List<Point> results = HibernateSessionFactory.getSessionFactory().openSession()
                .createQuery("Select point From Point point").list();
        return results;
    }

    @Override
    public List<Point> getHead(int i) {
        return null;
    }

    @Override
    public void clear() {
        String stringQuery = "DELETE FROM Point ";
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();
        session.createQuery(stringQuery).executeUpdate();
        session.getTransaction().commit();

        session.close();
    }

}
