package ru.itis.gospital.crm.hibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateConnector {

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("SaveLinks");
        }
        return entityManagerFactory;
    }

    public static void close() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }


}
