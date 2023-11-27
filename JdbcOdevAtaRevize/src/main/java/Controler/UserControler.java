package Controler;

import Entity.Users;
import Repository.CategoryRepository;
import Service.CategoryService;
import Service.UserService;
import Utility.Singleton;

import java.util.Scanner;

public class UserControler implements IUserContoler {
    Scanner sci = new Scanner(System.in);
    boolean loop1 = true, loop2 = true;
    int choose1, choose2;
    UserService userService = Singleton.getUserService();
    CategoryControler categoryControler = new CategoryControler();


    public void UserSeeControler(){

        if (userService.getUserControlService()){

            while (loop2) {
                System.out.println("1.Kullanıcı işlemleri");
                System.out.println("2.Kategori işlemleri");
                System.out.println("3.Çıkış");
                System.out.println("Lütfen seçiminizi yapınız");
                choose2 = sci.nextInt();

                switch (choose2) {

                  case 1:
                    while (loop1) {
                        // Menüyü göster
                        System.out.println("1-Kullanıcı Adını Güncelle");
                        System.out.println("2-Soyadını Güncelle");
                        System.out.println("3-Emaili Güncelle");
                        System.out.println("4-Şifreyi Güncelle");
                        System.out.println("5-Kullanıcı ekle");
                        System.out.println("6-Kullanıcı getir");
                        System.out.println("7-Çıkış");

                        // Kullanıcının seçimini al
                        System.out.print("Lütfen Seçim yapınız: ");
                        choose1 = sci.nextInt();

                        // Switch-case yapısı ile kullanıcının seçimine göre işlem yap
                        switch (choose1) {
                            case 1:
                                userService.usersUpdateName();
                                break;
                            case 2:
                                userService.usersUpdateLastName();
                                break;
                            case 3:
                                userService.usersUpdateMail();
                                break;
                            case 4:
                                userService.usersUpdatePassword();
                                break;
                            case 5:
                                userService.createUsersService();
                                break;
                            case 6:
                                userService.getUserService();
                                break;
                            case 7:
                                System.out.println("Çıkış yapılıyor...");
                                loop1 = false;
                                break;
                            default:
                                System.out.println("Geçersiz seçim, tekrar deneyin.");
                                break;
                        }
                    }
                         break;
                    case 2:
                    categoryControler.userSeeCategory();
                        break;
                    case 3:
                        System.out.println("Çıkış yapılıyor...");
                        break;
                    default:
                        System.out.println("Hatalı seçim yeniden deneyiniz");
                        break;
                }
            }
        }
    }
}