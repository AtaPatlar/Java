package Repository;

import Entity.Users;

import java.util.List;

public interface IUserRepository {
    public boolean updateUsersMail(Users users);
    public boolean updateUsersName(Users users);
    public boolean updateUsersLastName(Users users);
    public boolean updateUsersPassword(Users users);
    public boolean createUsers(Users users);
    public List<Users> getUsers();
    public Users getUsersControl(String email , String password);

}
