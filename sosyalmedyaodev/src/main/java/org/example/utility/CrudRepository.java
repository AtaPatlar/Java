package org.example.utility;

import java.util.List;

public class CrudRepository<T,ID> implements ICrudRepository<T,ID>{

    DbConnection dbConnection=null;

    public CrudRepository() {
        this.dbConnection = Singleton.getDbConnection();
    }



    public T getById(Class<T> entityClass, ID id) {
        try {
            dbConnection.openSession();

            // EntityManager.find metodu kullanarak nesneyi çek
            Object result = dbConnection.session.find(entityClass, id);

            // Eğer result null değilse ve entityClass türüne cast edilebiliyorsa, cast et
            if (result != null && entityClass.isInstance(result)) {
                T object = entityClass.cast(result);
                dbConnection.closeSession();
                return object;
            } else {
                System.out.println("Belirtilen ID'ye sahip nesne bulunamadı veya tip uyuşmazlığı.");
                dbConnection.closeSession();
                return null;
            }
        } catch (Exception exception) {
            System.out.println("getById yapılamadı, sorun crud repository'de ");
            dbConnection.rollBack();
            return null;
}
    }

    @Override
    public void save(T t) {
        try{
            dbConnection.openSession();
            dbConnection.session.save(t);
            dbConnection.closeSession();
        }catch (Exception exception){
            System.out.println("Kayıt yapılamadı Crud Repository");
            dbConnection.rollBack();
        }

    }

    @Override
    public void delete(T t) {
            try{
                dbConnection.openSession();
                dbConnection.session.delete(t);
                dbConnection.closeSession();
            }catch (Exception exception){
                System.out.println("Kayıt silinemedi Crud Repository");
                dbConnection.rollBack();
            }
    }

    @Override
    public void update(T t) {
        try{
            dbConnection.openSession();
            dbConnection.session.update(t);
            dbConnection.closeSession();
        }catch (Exception exception){
            System.out.println("Kayıt güncellenemedi Crud Repository");
            dbConnection.rollBack();
        }
    }



//    @Override
//    public<T> List<T> getAll(Class<T> entityClass) {
//        List<T> list=null;
//        String sinifAdi=entityClass.getSimpleName().toLowerCase();
//        try{
//            dbConnection.openSession();
//            list=dbConnection.session.createQuery("select * from '"+sinifAdi+"'",entityClass).getResultList();
//            dbConnection.closeSession();
//            return list;
//        }catch (Exception exception){
//            System.out.println("Kayıt listesi getirilemedi crud repository");
//            dbConnection.rollBack();
//            return list;
//        }
//    }

    @Override
    public<T> List<T> getAll(Class<T> entityClass){
        List<T> list=null;
        try{
            dbConnection.openSession();
            list=dbConnection.session.createNativeQuery("select * from "+entityClass.getSimpleName().toLowerCase(),entityClass).getResultList();
            dbConnection.closeSession();
            return list;
        }catch (Exception exception){
            System.out.println("Kayıt listesi getirilemedi crud repository");
            dbConnection.rollBack();
            return list;
        }
    }




}

