package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setBrand("ASUS");
        l1.setModel("Rog");
        l1.setRam(16);


        Alien a1 = new Alien();
        a1.setAid(3);                       // THIS FOR CHANGING A TABLE AND COLUMN NAME FROM ALIEN CLASS
        a1.setAname("Sahil Patil");
        a1.setTech("Java");
        a1.setLaptop(l1);

//        Student s1 = new Student();
//        s1.setId(8);
//        s1.setName("John Don");
//        s1.setAge(22);

        //Student s2 = null;       // CREATE FOR FETCH DATA FROM DATABASE CREATE ANOTHER OBJECT OF STUDENT CLASS .


//        Configuration cfg = new Configuration();
//        cfg.configure();                                         // THIS THREE LINES OF CODE REFACTORING IN BELOW CODE :
//        SessionFactory sf  = cfg.buildSessionFactory();


        // REFACTORING CODE :

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Alien.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();


        Transaction transaction  = session.beginTransaction();

        //session.persist(s1);                        // CREATE  TO SAVE DATA INTO DATABASE USING "persist()" METHOD

        session.persist(a1);                     // THIS FOR CHANGING TABLE AND COLUMN NAME

       // s2 = session.get(Student.class, 2);          // CREATE FOR FETCH DATA FROM DATABASE USING "get()" METHOD

       //  session.merge(s1);                          //CREATE TO  UPDATE THE DATA USING " merg()" METHODE

//        s1 = session.get(Student.class,6);            // FIRST FETCH THE DATA FROM DB AND THEN DELETE IT.
//        session.remove(s1);                           // CREATE TO DELETE THE DATA USING "remove()" METHOD


        transaction.commit();
        session.close();
        sf.close();

        //System.out.println(s1);

        System.out.println(a1);

    }
}