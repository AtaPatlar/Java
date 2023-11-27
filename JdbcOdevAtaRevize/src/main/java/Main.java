import Controler.CategoryControler;
import Controler.UserControler;
import Entity.Users;
import Repository.CategoryRepository;
import Repository.UserRepository;
import Service.CategoryService;
import Service.UserService;

public class Main {
    public static void main(String[] args) {

        UserControler userControler = new UserControler();
        userControler.UserSeeControler();
    }
}