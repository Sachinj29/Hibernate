package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {



        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("ASUS");
        l1.setModel("ROG");
        l1.setRam(32);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("DELL");
        l2.setModel("RXP");
        l2.setRam(16);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("HP");
        l3.setModel("PLX");
        l3.setRam(16);



        Alien a1 = new Alien();
        a1.setAid(101);                       // THIS FOR CHANGING A TABLE AND COLUMN NAME FROM ALIEN CLASS
        a1.setAname("Pratik Kale");
        a1.setTech("AWS");


        Alien a2 = new Alien();
        a2.setAid(102);                       // THIS FOR CHANGING A TABLE AND COLUMN NAME FROM ALIEN CLASS
        a2.setAname("Somraj Patil");
        a2.setTech("Java");

        Alien a3 = new Alien();
        a3.setAid(103);                       // THIS FOR CHANGING A TABLE AND COLUMN NAME FROM ALIEN CLASS
        a3.setAname("Suraj Khot");
        a3.setTech("AI");

        a1.setLaptop(Arrays.asList(l1,l2));
        a2.setLaptop(Arrays.asList(l2,l3));
        a3.setLaptop(Arrays.asList(l1));

        l1.setAlien(Arrays.asList(a1,a3));
        l2.setAlien(Arrays.asList(a2,a3));
        l3.setAlien(Arrays.asList(a2));

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
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();


        Transaction transaction  = session.beginTransaction();

        //session.persist(s1);                        // CREATE  TO SAVE DATA INTO DATABASE USING "persist()" METHOD

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(a1);
        session.persist(a2);
        session.persist(a3);                             // THIS FOR CHANGING TABLE AND COLUMN NAME


        // s2 = session.get(Student.class, 2);          // CREATE FOR FETCH DATA FROM DATABASE USING "get()" METHOD

        //  session.merge(s1);                          //CREATE TO  UPDATE THE DATA USING " merg()" METHODE

//        s1 = session.get(Student.class,6);            // FIRST FETCH THE DATA FROM DB AND THEN DELETE IT.
//        session.remove(s1);                           // CREATE TO DELETE THE DATA USING "remove()" METHOD

        transaction.commit();

        Alien a5 = session.get(Alien.class,102);
        System.out.println(a2);


        session.close();
        sf.close();

        //System.out.println(s1);

        System.out.println(a1);

    }
}