package org.example.service;

import org.example.entity.Posts;
import org.example.repository.PostRepository;
import org.example.utility.Singleton;

import java.util.List;

public class PostService {

    PostRepository postRepository;

    public PostService() {
        this.postRepository = Singleton.getPostRepository();
    }

    public void postSave(String postName,int ownerId){
        Posts posts=new Posts();
        posts.setPostName(postName);
        posts.setOwnerId(ownerId);
        postRepository.save(posts);
    }
    public List<Posts> getAll(){
      return postRepository.getAll(Posts.class);
    }

    public Posts getById(Integer id){
        return postRepository.getById(Posts.class,id);
    }
}
