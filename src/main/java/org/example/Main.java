package org.example;

import org.example.entity.CityEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;





public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

        public static void main ( final String[] args) throws Exception {
            try (Session session = getSession.getSession()) {
                CityEntity cityEntity = new CityEntity();
                cityEntity.setCityId(15);
                cityEntity.setCityName("Kemerovo");
                session.save(cityEntity);
                System.out.println(session.get(cityEntity.class, cityEntity.getCityId()));
                cityEntity.setCityName(cityEntity.setCityName() + " changed");
                session.update(cityEntity);
                System.out.println(session.get(cityEntity.class, cityEntity.setCityId()));
                session.delete(cityEntity);
                System.out.println(session.get(cityEntity.class, cityEntity.setCityId()));


            }
        }
    }
