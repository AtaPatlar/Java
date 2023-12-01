package Repository;

import Entity.Users;
import Utility.DbConnect;
import Utility.Singleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    DbConnect dbConnect;
    Connection connection = null;

    public UserRepository(){
        dbConnect = Singleton.getDbConnect();
    }
    public boolean createUsers(Users users){
    connection = dbConnect.getConnection(); // connection açtık

    String UsersCreate = "insert into users(email,name,lastname,password) values (?,?,?,?)";
    try {
        PreparedStatement ps = connection.prepareCall(UsersCreate);
        ps.setString(1,users.geteMail());
        ps.setString(2,users.getName());
        ps.setString(3, users.getSurname());
        ps.setString(4, users.getPassword());
        ps.executeUpdate();
        return true;
    }
    catch (SQLException s){
        s.printStackTrace();
        System.out.println("SQL bağlantı hatası");
    }
    finally {
        dbConnect.closeConnection(connection);
    }
    return false;
    }

    public List<Users> getUsers(){

        connection = dbConnect.getConnection(); // connetion açtık
        String getUsers = "Select * from users";
        List<Users> usersList = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareCall(getUsers);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){

                Users users = new Users();
                users.setId(resultSet.getInt("id"));
                users.seteMail(resultSet.getString("email"));
                users.setName(resultSet.getString("name"));
                users.setSurname(resultSet.getString("lastname"));
                users.setPassword(resultSet.getString("password"));

                usersList.add(users);
                System.out.println(users);
            }
            return usersList;
        } catch (SQLException e) {
           e.printStackTrace();
            System.out.println("Liste getirilemedi");
        }
        finally {
            dbConnect.closeConnection(connection);
        }
        return null;
    }


    public Users getUsersControl(String email , String password){
        connection = dbConnect.getConnection(); // connetion açtık
        String usersControl = "select * from users where email = '"+email+"' and password = '"+password+"'";
        try {
            PreparedStatement ps = connection.prepareCall(usersControl);
            ResultSet resultSet = ps.executeQuery();
            Users users1 = new Users();

            while (resultSet.next()){

                users1.setId(resultSet.getInt("id"));
                users1.seteMail(resultSet.getString("email"));
                users1.setName(resultSet.getString("name"));
                users1.setSurname(resultSet.getString("lastname"));
                users1.setPassword(resultSet.getString("password"));
            }
            return users1;
        }
        catch (SQLException s){
            s.printStackTrace();
            System.out.println("Kontrol yapılamadı");
        }
        finally {
            dbConnect.closeConnection(connection);
        }
        return null;

    }

    public boolean updateUsersMail(Users users,String updateMail){
       // connetion açtık
        Users userIsExist=getUsersControl(users.geteMail(), users.getPassword());
        String mailUpdate = "update users set email = '"+updateMail+"'  where id='"+userIsExist.getId()+" '";
        connection = dbConnect.getConnection();
        try {
            PreparedStatement ps = connection.prepareCall(mailUpdate);
            ps.executeUpdate();
            System.out.println("Kullanıcı mail adresi güncellendi= "+ users.geteMail());

            return true;
        }
        catch (SQLException s){
            s.printStackTrace();
            System.out.println("E mail güncellenmedi");
        }
        finally {
            dbConnect.closeConnection(connection);
        }
        return false;
    }


    public boolean updateUsersName(Users users){
        connection = dbConnect.getConnection(); // connetion açtık
        String nameUpdate =  "UPDATE users SET name = '"+users.getName()+"'  WHERE email ='"+users.geteMail()+"'";
        try {
            PreparedStatement ps = connection.prepareCall(nameUpdate);
            ps.executeUpdate();
            System.out.println("Kullanıcı ismi adresi güncellendi= "+ users.getName());
            return true;
        }
        catch (SQLException s){
            s.printStackTrace();
            System.out.println("İsim güncellenmedi");
        }
        finally {
            dbConnect.closeConnection(connection);
        }
        return false;

    }

    public boolean updateUsersLastName(Users users){
        connection = dbConnect.getConnection(); // connetion açtık
        String lastnameUpdate =  "UPDATE users SET lastname = ? where email = ? ";
        try {
            PreparedStatement ps = connection.prepareCall(lastnameUpdate);
            ps.setString(1,users.getSurname());
            ps.setString(2,users.geteMail());

            ps.executeUpdate();
            System.out.println("Kullanıcı soyismi güncellendi= "+ users.getSurname());
            return true;
        }
        catch (SQLException s){
            s.printStackTrace();
            System.out.println("Soyisim güncellenmedi");
        }
        finally {
            dbConnect.closeConnection(connection);
        }
        return false;

    }
    public boolean updateUsersPassword(Users users){
        connection = dbConnect.getConnection(); // connetion açtık
        String passwordUpdate =  "UPDATE users SET password = '"+users.getPassword()+"'  WHERE email ='"+users.geteMail()+"'";
        try {
            PreparedStatement ps = connection.prepareCall(passwordUpdate);
            ps.executeUpdate();
            System.out.println("Kullanıcı şifresi güncellendi= "+ users.getPassword());
            return true;
        }
        catch (SQLException s){
            s.printStackTrace();
            System.out.println("Şifre güncellenmedi");
        }
        finally {
            dbConnect.closeConnection(connection);
        }
        return false;
    }
}
