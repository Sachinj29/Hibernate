package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


//        Configuration cfg = new Configuration();
//        cfg.configure();                                         // THIS THREE LINES OF CODE REFACTORING IN BELOW CODE :
//        SessionFactory sf  = cfg.buildSessionFactory();


        // REFACTORING CODE :

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        //SELECT * FROM Laptop WHERE ram =32;  --->SQL Query
        //FROM Laptop WHERE ram = 32; --->HQL Query

//        String brand = "ASUS";
//        Query query = session.createQuery("from Laptop where brand like ?1");   //HQL Query to Fetch Data From DB.
//        query.setParameter(1,brand);
//        List<Laptop> laptops = query.getResultList();


       // Laptop l1 = session.get(Laptop.class, 2);
       // System.out.println(laptops);


        session.close();
        sf.close();

    }
}