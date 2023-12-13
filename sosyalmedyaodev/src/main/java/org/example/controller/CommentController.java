package org.example.controller;

import org.example.entity.Comments;
import org.example.service.CommentService;
import org.example.utility.Singleton;

import java.util.List;

public class CommentController{
    CommentService commentService;

    public CommentController(){
        commentService = Singleton.getCommentService();
    }

    public void save(String comment,int ownerId,int postId){

        commentService.save(comment,ownerId,postId);
    }
    public List<Comments> commentsListById(int id){
        return commentService.commentListById(id);
    }

    public List<Comments> getAll(){
        return commentService.getAll();
    }

}
