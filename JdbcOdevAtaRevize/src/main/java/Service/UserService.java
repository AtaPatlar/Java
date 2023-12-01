package Service;

import Entity.Category;
import Entity.Users;
import Repository.IUserRepository;
import Repository.UserRepository;
import Utility.Singleton;

import javax.xml.catalog.CatalogManager;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService implements IUserService {
    IUserRepository userRepository;
    Scanner scs = new Scanner(System.in);
    public UserService(){
        userRepository = new UserRepository();
    }

    public boolean getUserControl(String email, String password) {
        Users users = new Users();
        users.seteMail(email);
        users.setPassword(password);
        if (userRepository.getUsersControl(users.geteMail(),users.getPassword()).getId()!=0){
            return true;
        }
        else {
            System.out.println("Kullanıcı adı veya şifre hatalı");
            return false;
        }
    }
    public boolean createUsersService(String email1, String password1){
        Users users1 = new Users();
        users1.seteMail(email1);
        users1.setPassword(password1);
        if (userRepository.getUsersControl(users1.geteMail(),users1.getPassword()).getId()!=0){
            System.out.println("Kullanıcı zaten kayıtlı");
            return false;
        }
        else {
            System.out.println("isminizi küçük harflerle giriniz.");
            String name = scs.nextLine();
            System.out.println("soyisminizi küçük harflerle giriniz.");
            String lastname = scs.nextLine();

            Users usersx = Users.UserBuilder.startUserBuilder().Name(name).Surname(lastname).eMail(email1).Password(password1).
                    build();
            userRepository.createUsers(usersx);
            System.out.println("Kullanıcı başarı oluşturuldu."+usersx);
            return true;
        }
    }
    public boolean usersUpdateMail(String updateMail,String email,String password){
        Users users2 = new Users();

              users2.seteMail(email);
              users2.setPassword(password);
              return userRepository.updateUsersMail(users2, updateMail);
    }
    public boolean usersUpdateName(String name ,String email){
        Users users2 = new Users();
            users2.setName(name);
            users2.seteMail(email);
            userRepository.updateUsersName(users2);
            return true;
    }
    public boolean usersUpdateLastName(String lastname,String email){
        Users users2 = new Users();
            users2.setSurname(lastname);
            users2.seteMail(email);
            userRepository.updateUsersLastName(users2);
            return true;
    }
    public boolean usersUpdatePassword(String password,String email){
        Users users2 = new Users();
            users2.setPassword(password);
            users2.seteMail(email);
            userRepository.updateUsersPassword(users2);
            return true;
    }
    public List<Users> getUsers(){
        return userRepository.getUsers();
    }

}
