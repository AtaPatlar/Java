package org.example.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {


    private static SessionFactory sessionFactory=null;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory==null){

            try {
                sessionFactory=new Configuration().configure().buildSessionFactory();
                return sessionFactory;
            }catch (Exception e){
                System.out.println("Hibernateconfig hata");
                e.printStackTrace();
                return sessionFactory;
            }

        }else {
            return sessionFactory;
        }


    }

}
