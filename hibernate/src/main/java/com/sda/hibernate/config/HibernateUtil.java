package com.sda.hibernate.config;

import com.sda.hibernate.crud.Person;
import com.sda.hibernate.homework.Project;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    //build session factory
    private static SessionFactory buildSessionFactory() {
        //create configuration
        Configuration configuration = createConfiguration();

        //build registry using the properties in the configuration
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        //create session factory
        return configuration.buildSessionFactory(serviceRegistry);

    }

    private static Configuration createConfiguration() {
        Configuration configuration = new Configuration();

        //set connection properties in config
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate?serverTimezone=UTC");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "liliacului");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "create-drop");


        configuration.setProperties(settings);

        // add annotated classes
        configuration.addAnnotatedClass(Person.class);

        //configuration.addAnnotatedClass(Player.class);

        // one to one
//        configuration.addAnnotatedClass(Account.class);
//        configuration.addAnnotatedClass(Employee.class);

//        configuration.addAnnotatedClass(Mother.class);
//        configuration.addAnnotatedClass(Daughter.class);

//        configuration.addAnnotatedClass(Father.class);
//        configuration.addAnnotatedClass(Son.class);

//        configuration.addAnnotatedClass(Parent.class);
//        configuration.addAnnotatedClass(Child.class);

//        configuration.addAnnotatedClass(Post.class);
//        configuration.addAnnotatedClass(Tag.class);

        //configuration.addAnnotatedClass(Stock.class);
        //configuration.addAnnotatedClass(Trader.class);

        configuration.addAnnotatedClass(Project.class);

        return configuration;
    }


}
