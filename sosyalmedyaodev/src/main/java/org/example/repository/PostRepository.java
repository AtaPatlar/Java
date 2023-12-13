package org.example.repository;

import org.example.entity.Posts;
import org.example.utility.CrudRepository;
import org.example.utility.DbConnection;
import org.example.utility.Singleton;

import java.util.ArrayList;
import java.util.List;

public class PostRepository extends CrudRepository<Posts,Integer>{

        DbConnection dbConnection=null;

        public PostRepository(){
            dbConnection= Singleton.getDbConnection();
        }


}
