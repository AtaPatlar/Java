package org.example.utility;

import org.example.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DbConnection {

        public Session session=null;
        public Transaction transaction=null;

        public void openSession(){
           try{
               session= HibernateConfig.getSessionFactory().openSession();
               transaction=session.beginTransaction();
           }catch (Exception exception){
               System.out.println("Oturum açılamadı kanka");
           }
        }
        public void closeSession(){
            try{
                transaction.commit();
                session.close();
            }catch (Exception exception){
                System.out.println("Oturum kapatılamadı kanka");
            }
        }
        public void rollBack(){
            try {
                transaction.rollback();
                session.close();
            }catch (Exception exception){
                System.out.println("Transaction yapılamadı kanka");
            }
        }


}
