package org.example.controller;

import org.example.entity.Likes;
import org.example.entity.Posts;
import org.example.service.LikeService;
import org.example.utility.Singleton;

import java.util.List;

public class LikeController{
    LikeService likeService;
    public LikeController(){
        likeService = Singleton.getLikeService();
    }

    public void save(int ownerId, int postId){

        likeService.save(ownerId,postId);
    }
    public void delete(int ownerId, int postId){

        likeService.delete(ownerId,postId);
    }
    public List<Likes> getAll(){
        return likeService.getAll();
    }
    public Likes getById(int id){
        return likeService.getById(id);
    }

}
