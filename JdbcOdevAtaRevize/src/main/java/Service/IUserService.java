package Service;

import Entity.Users;

import java.util.List;

public interface IUserService {
    public boolean getUserControl(String email, String password) ;
    public boolean createUsersService(String email, String password);
    public boolean usersUpdateMail(String updateMail,String email,String password);
    public boolean usersUpdateName(String name,String email);
    public boolean usersUpdateLastName(String lastname,String email);
    public boolean usersUpdatePassword(String password,String email);
    public List<Users> getUsers();
}
