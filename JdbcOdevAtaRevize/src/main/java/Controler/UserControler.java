package Controler;

import Entity.Users;
import Service.IUserService;
import Service.UserService;

import java.util.List;

public class UserControler implements IUserContoler{

    IUserService userService;

    public UserControler(){
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
    public boolean usersUpdateName(String name){
        return userService.usersUpdateName(name);

    }
    public boolean usersUpdateLastName(String lastname){
        return userService.usersUpdateLastName(lastname);
    }
    public boolean usersUpdatePassword(String password){
        return userService.usersUpdatePassword(password);
    }
    public List<Users> getUsers(){
        return userService.getUsers();
    }

}