package org.example.repository;

import org.example.entity.Comments;
import org.example.utility.CrudRepository;
import org.example.utility.DbConnection;
import org.example.utility.Singleton;

import java.util.ArrayList;
import java.util.List;

public class CommentRepository extends CrudRepository<Comments,Integer>{
    DbConnection dbConnection=null;
    public CommentRepository(){
        dbConnection= Singleton.getDbConnection();
    }

    public List<Comments> commentListById(int id) {
        List<Object[]> objects;
        List<Comments> commentsList=new ArrayList<>();
        try{
            dbConnection.openSession();
            //list=dbConnection.session.createNativeQuery("select * from '"+entityClass+"'",entityClass).getResultList();
            objects=dbConnection
                    .session
                    .createNativeQuery("select comments.id,comments.postid,comments.comments,comments.ownerid from comments inner join posts on comments.postid=posts.id inner join userprofile on posts.ownerid=userprofile.id")
                    .getResultList();
            dbConnection.closeSession();
            for (Object []o:objects
            ) {
                Comments comments=new Comments();
                comments.setId((Integer) o[0]);
                comments.setPostId((Integer) o[1]);
                comments.setComments((String)o[2]);
                comments.setOwnerId((Integer)o[3]);
                commentsList.add(comments);

            }
            return commentsList;
        }catch (Exception exception){
            System.out.println("Kayıt listesi getirilemedi crud repository");
            dbConnection.rollBack();
            return commentsList;
        }
    }






}
