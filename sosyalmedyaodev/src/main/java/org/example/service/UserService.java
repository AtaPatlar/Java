package org.example.service;

import org.example.entity.UserProfile;
import org.example.repository.UserRepository;
import org.example.utility.Singleton;

import java.util.ArrayList;
import java.util.List;

public class UserService{

    UserRepository userRepository=null;

    public  UserService(){
        userRepository= Singleton.getUserRepository();
    }



    public UserProfile isExist(String userName,String password){

        UserProfile userProfile=new UserProfile();
        userProfile.setUsername(userName);
        userProfile.setPassword(password);

        UserProfile userProfile1=userRepository.isExist(userProfile);

        if(userProfile1.getId()==0){
                return null;
        }else{
            return userProfile1;
        }
    }
    public UserProfile getById(Integer id){
      return   userRepository.getById(UserProfile.class,id);
    }

    public List<UserProfile> getAll(){
        return userRepository.getAll(UserProfile.class);
    }



}
