package Service;

import Entity.Category;
import Entity.Users;
import Repository.UserRepository;
import Utility.Singleton;

import javax.xml.catalog.CatalogManager;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService implements IUserService {
    Scanner sci = new Scanner(System.in);
    Scanner scs = new Scanner(System.in);
    UserRepository userRepository = Singleton.getUserRepository();
    CategoryService categoryService = Singleton.getCategoryService();
    Users users = new Users();
    String email,password,name,lastname;
    int userCheck;

    public boolean getUserControlService () {

        System.out.println("Emailinizi küçük harflerle giriniz...");
        email = scs.nextLine();
        System.out.println("Şifrenizi giriniz...");
        password= scs.nextLine();
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

    public void createUsersService(){

        System.out.println("Emailinizi küçük harflerle giriniz.");
        email = scs.nextLine();
        System.out.println("şifrenizi giriniz.");
        password = scs.nextLine();
        users.seteMail(email);
        users.setPassword(password);
        if (userRepository.getUsersControl(users.geteMail(),users.getPassword()).getId()!=0){
            System.out.println("Kullanıcı zaten kayıtlı");
        }
        else {
            System.out.println("isminizi küçük harflerle giriniz.");
            name = scs.nextLine();
            System.out.println("soyisminizi küçük harflerle giriniz.");
            lastname = scs.nextLine();

            Users users1 = Users.UserBuilder.startUserBuilder().Name(name).Surname(lastname).eMail(email).Password(password).
                    build();

            userRepository.createUsers(users1);
            System.out.println("Kullanıcı başarı oluşturuldu."+users1);
        }
    }

    public void usersUpdateMail(){
              System.out.println("Güncellemek istediğiniz emailinizi küçük harflerle giriniz.");
              email = scs.nextLine();
              users.seteMail(email);
              userRepository.updateUsersMail(users);
    }
    public void usersUpdateName(){

            System.out.println("Güncellemek istediğiniz isminizi küçük harflerle giriniz.");
            name = scs.nextLine();
            users.setName(name);
            userRepository.updateUsersName(users);
    }
    public void usersUpdateLastName(){

            System.out.println("Güncellemek istediğiniz soyisminizi küçük harflerle giriniz.");
            lastname = scs.nextLine();
            users.setSurname(lastname);
            userRepository.updateUsersLastName(users);
    }
    public void usersUpdatePassword(){

            System.out.println("Güncellemek istediğiniz şifrenizi küçük harflerle giriniz.");
            password = scs.nextLine();
            users.setPassword(password);
            userRepository.updateUsersPassword(users);
    }
    public void getUserService(){
            userRepository.getUsers();
    }

}
