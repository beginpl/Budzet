package com.budzet.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;



public class DochodModel {
    private static SessionFactory factory;

    public DochodModel() {
        try {
            factory = new Configuration().configure().buildSessionFactory();

        } catch (Throwable thr) {
            System.err.println("Filed to create sessionFactory object: " + thr);
        }
    }

    /* metoda dodatje dochod do bazy danych */
    public Integer addDochod(double cena, String opis) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer dochodID = null;
        try {
            tx = session.beginTransaction();
            Dochod dochod = new Dochod(cena, opis);
            dochodID = (Integer) session.save(dochod);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return dochodID;
    }

    public void updateDochod(int id, double cena, String opis) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.createQuery("UPDATE Dochod SET cena='"+cena+"',opis='"+opis+"' WHERE id ="+id+"").executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteDochod(int id)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.createQuery("DELETE Dochod WHERE id="+id+"").executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public double sumaDochod()
    {
        double suma = 0.0;
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List list = session.createQuery("SELECT SUM(cena) FROM Dochod ").list();
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

    public ArrayList<Dochod> daneDochod() {
            Session session = factory.openSession();
            Transaction tx = null;
            ArrayList<Dochod> l = new ArrayList<Dochod>();


            try {
                tx = session.beginTransaction();
                List location = session.createQuery("from Dochod ").list();

                for (Iterator iterator =
                     location.iterator(); iterator.hasNext(); ) {
                    Dochod loc = (Dochod) iterator.next();
                    l.add(loc);
                }
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
            return l;
        }

    }


