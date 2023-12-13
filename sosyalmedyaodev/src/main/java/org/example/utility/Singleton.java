package org.example.utility;


import org.example.controller.CommentController;
import org.example.controller.LikeController;
import org.example.controller.PostController;
import org.example.controller.UserController;
import org.example.repository.CommentRepository;
import org.example.repository.LikeRepository;
import org.example.repository.PostRepository;
import org.example.repository.UserRepository;
import org.example.service.CommentService;
import org.example.service.LikeService;
import org.example.service.PostService;
import org.example.service.UserService;

public class Singleton {

        private static DbConnection dbConnection=null;
   //

        private static UserRepository userRepository=null;
        private static UserService userService=null;
        private static UserController userController=null;

   //
        private  static  CommentRepository commentRepository=null;

        private static CommentController commentController=null;
        private static CommentService commentService=null;

        //
     private static LikeController likeController=null;
     private static LikeService likeService=null;
     private static LikeRepository likeRepository=null;

     private static PostController postController=null;
     private static PostService postService=null;
     private static PostRepository postRepository=null;


    public static PostController getPostController(){
        if(postController==null){
            postController=new PostController();
            return postController;
        }else{
            return postController;
        }
    }

    public static PostService getPostService(){
        if(postService==null){
            postService=new PostService();
            return postService;
        }else{
            return postService;
        }
    }
     public static PostRepository getPostRepository(){
        if(postRepository==null){
            postRepository=new PostRepository();
            return postRepository;
        }else{
            return postRepository;
        }
    }

    public static LikeController getLikeController(){
        if(likeController==null){
            likeController=new LikeController();
            return likeController;
        }else{
            return likeController;
        }
    }
    public static LikeService getLikeService(){
        if(likeService==null){
            likeService=new LikeService();
            return likeService;
        }else{
            return likeService;
        }
    }
        public static LikeRepository getLikeRepository(){
            if(likeRepository==null){
                likeRepository=new LikeRepository();
                    return likeRepository;
            }else{
                return likeRepository;
            }
        }
    public static DbConnection getDbConnection(){
        if(dbConnection==null){
            dbConnection=new DbConnection();
            return dbConnection;
        }else{
            return dbConnection;
        }
    }
    public static UserRepository getUserRepository(){
        if(userRepository==null){
            userRepository=new UserRepository();
            return userRepository;
        }else{
            return userRepository;
        }
    }
    public static  UserService getUserService(){
        if (userService==null) {
                userService=new UserService();
                return userService;
        }
        else{
            return userService;
        }
    }
    public static UserController getUserController(){
            if(userController==null){
                userController=new UserController();
                return userController;
            }else{
                return userController;
            }
    }
    public static CommentController getCommentController(){
        if(commentController==null){
            commentController=new CommentController();
            return commentController;
        }else{
            return commentController;
        }
    }
    public static CommentService getCommentService(){
        if(commentService==null){
            commentService=new CommentService();
            return commentService;
        }else{
            return commentService;
        }
    }
    public static CommentRepository getCommentRepository(){
        if(commentRepository==null){
            commentRepository=new CommentRepository();
            return commentRepository;
        }else{
            return commentRepository;
        }
    }



}
