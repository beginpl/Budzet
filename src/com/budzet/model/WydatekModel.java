package com.budzet.model;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class WydatekModel
{

    private static SessionFactory factory;

    public WydatekModel() {
        try {
            factory = new Configuration().configure().buildSessionFactory();

        } catch (Throwable thr) {
            System.err.println("Filed to create sessionFactory object: " + thr);
        }
    }

    public Integer addWydatek(double cena, String opis) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer wydatekID = null;
        try {
            tx = session.beginTransaction();
            Wydatek wydatek = new Wydatek(cena, opis);
            wydatekID = (Integer) session.save(wydatek);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return wydatekID;
    }

    public void updateWydatek(int id, double cena, String opis) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.createQuery("UPDATE Wydatek SET cena='"+cena+"',opis='"+opis+"' WHERE id ="+id+"").executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteWydatek(int id)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.createQuery("DELETE Wydatek WHERE id="+id+"").executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public double sumaWydatek()
    {
        double suma = 0.0;
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List list = session.createQuery("SELECT SUM(cena) FROM Wydatek ").list();
            suma = Double.parseDouble(list.get(0).toString());
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return suma;
    }
}
