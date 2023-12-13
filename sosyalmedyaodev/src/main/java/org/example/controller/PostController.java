package org.example.controller;

import org.example.entity.Posts;
import org.example.service.PostService;
import org.example.utility.Singleton;

import java.util.List;

public class PostController{
    PostService postService;
    public PostController() {
        postService= Singleton.getPostService();
    }
    public void postSave(String postName,int ownerId){
        postService.postSave(postName,ownerId);
    }
    public List<Posts> getAll(){
        return postService.getAll();
    }
    public Posts getById(int id){
        return postService.getById(id);
    }
}
