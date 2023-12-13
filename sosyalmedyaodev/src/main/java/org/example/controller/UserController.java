package org.example.controller;

import org.example.entity.UserProfile;
import org.example.service.UserService;
import org.example.utility.Singleton;

import java.util.List;

public class UserController{
    UserService userService=null;

    public UserController() {
        this.userService = Singleton.getUserService();
    }
    public UserProfile isExist(String userName,String password){
        return userService.isExist(userName,password);
    }

    public UserProfile getByid(int id){
       return userService.getById(id);
    }

    public List<UserProfile> getAll(){
        return userService.getAll();
    }


}
