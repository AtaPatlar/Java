package org.example.repository;

import org.example.entity.Likes;
import org.example.utility.CrudRepository;
import org.example.utility.DbConnection;
import org.example.utility.Singleton;

public class LikeRepository extends CrudRepository<Likes,Integer> {


    DbConnection dbConnection;

    public LikeRepository() {
            dbConnection= Singleton.getDbConnection();
    }
}
