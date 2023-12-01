package Controler;

import Entity.Users;
import Service.IUserService;
import Service.UserService;

import java.util.List;

public class UserController implements IUserContoller{

    IUserService userService;

    public UserController(){
        userService = new UserService();
    }

    public boolean getUserControl(String email, String password) {
        return userService.getUserControl(email, password);
    }
    public boolean createUsersService(String email, String password) {
        return userService.createUsersService(email, password);
    }
    public boolean usersUpdateMail(String updateMail,String email1,String password1){
        return userService.usersUpdateMail(updateMail,email1,password1);
    }
    public boolean usersUpdateName(String name,String email){
        return userService.usersUpdateName(name,email);

    }
    public boolean usersUpdateLastName(String lastname,String email){
        return userService.usersUpdateLastName(lastname,email);
    }
    public boolean usersUpdatePassword(String password,String email){
        return userService.usersUpdatePassword(password,email);
    }
    public List<Users> getUsers(){
        return userService.getUsers();
    }

}