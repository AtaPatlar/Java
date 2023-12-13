package org.example.repository;

import org.example.entity.UserProfile;
import org.example.utility.CrudRepository;
import org.example.utility.DbConnection;
import org.example.utility.Singleton;

public class UserRepository extends CrudRepository<UserProfile,Integer>{
    DbConnection dbConnection;
    public UserRepository(){
        dbConnection= Singleton.getDbConnection();
    }

    public UserProfile isExist(UserProfile userProfile){

        String sql="select * from userprofile where username='"+userProfile.getUsername()+"' and password='"+userProfile.getPassword()+"'";
        UserProfile userProfile1=null;
        try{
            dbConnection.openSession();
            userProfile1=dbConnection.session.createNativeQuery(sql,UserProfile.class).getSingleResult();
            if(userProfile1==null){
                dbConnection.closeSession();
                return userProfile1;
            }else{
                dbConnection.closeSession();
                return userProfile1;
            }
        }catch (Exception exception){
            System.out.println("Kullanıcı var sorgusu yapılamadı kanka sorun UserRepository de isExist fonksiyonunda");
            dbConnection.rollBack();
            return userProfile1;
        }

    }



}
