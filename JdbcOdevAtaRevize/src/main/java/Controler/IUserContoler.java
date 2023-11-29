package Controler;

import Entity.Users;

import java.util.List;

public interface IUserContoler {
    public boolean getUserControl(String email, String password);
    public boolean createUsersService(String email, String password);
    public boolean usersUpdateMail(String updateMail,String email,String password);
    public boolean usersUpdateName(String name);
    public boolean usersUpdateLastName(String lastname);
    public boolean usersUpdatePassword(String password);
    public List<Users> getUsers();

}

