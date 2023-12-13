package org.example.service;

import org.example.entity.Likes;
import org.example.entity.Posts;
import org.example.repository.LikeRepository;
import org.example.utility.Singleton;

import java.util.List;

public class LikeService {

    LikeRepository likeRepository;

    public LikeService(){
        likeRepository = Singleton.getLikeRepository();
    }

    public void save(int ownerId,int postId){

        Likes likes = new Likes();

        likes.setOwnerId(ownerId);
        likes.setPostId(postId);
        likeRepository.save(likes);

    }

    public void delete(int ownerId,int postId){
        Likes likes = new Likes();

        likes.setOwnerId(ownerId);
        likes.setPostId(postId);
        likeRepository.delete(likes);
    }
    public List<Likes> getAll(){
        return likeRepository.getAll(Likes.class);
    }

    public Likes getById(Integer id){
        return likeRepository.getById(Likes.class,id);
    }

}
