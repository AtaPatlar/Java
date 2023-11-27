package Utility;

import Entity.Category;
import Repository.CategoryRepository;
import Repository.UserRepository;
import Service.CategoryService;
import Service.UserService;

public class Singleton {

    public static DbConnect dbConnect = null;
    public static CategoryRepository categoryRepository = null;
    public static UserRepository userRepository =  null;
    public static CategoryService categoryService = null;
    public static UserService userService = null;


    public static DbConnect getDbConnect(){
        if (dbConnect == null){
           dbConnect =  new DbConnect();
           return dbConnect;
        }
        return dbConnect;
    }
    public static CategoryRepository getCategoryRepository(){
        if (categoryRepository == null){
            categoryRepository = new CategoryRepository();
            return categoryRepository;
        }
        return categoryRepository;
    }
    public static UserRepository getUserRepository(){
        if (userRepository == null){
            userRepository = new UserRepository();
            return userRepository;
        }
        return userRepository;
    }
    public static CategoryService getCategoryService(){
        if (categoryService == null){
            categoryService = new CategoryService();
            return categoryService;
        }
        return categoryService;
    }
    public static UserService getUserService(){
        if (userService == null){
            userService = new UserService();
            return userService;
        }
        return userService;
    }



}
