package org.example.service;

import org.example.entity.Comments;
import org.example.repository.CommentRepository;
import org.example.utility.Singleton;

import java.util.List;

public class CommentService{

    CommentRepository commentRepository;
    public CommentService(){
        commentRepository = Singleton.getCommentRepository();
    }

    public void save(String comment,int ownerId,int postId){
        Comments comments = new Comments();
        comments.setComments(comment);
        comments.setOwnerId(ownerId);
        comments.setPostId(postId);
        commentRepository.save(comments);
    }
    public List<Comments> commentListById(int id){
        return commentRepository.commentListById(id);
    }

    public List<Comments> getAll(){
        return commentRepository.getAll(Comments.class);
    }
}
