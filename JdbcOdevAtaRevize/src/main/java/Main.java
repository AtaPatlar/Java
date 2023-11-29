import Controler.CategoryControler;
import Controler.ICategoryControler;
import Controler.IUserContoler;
import Controler.UserControler;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sci = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);
        boolean loop1 = true, loop2 = true, loop3 = true;;
        int choose1, choose2 ,choose3;
        String chooseS1,chooseS3,email,password,name,lastname,email1,password1;

        IUserContoler userControler;
        ICategoryControler categoryControler;
        categoryControler = new CategoryControler();
        userControler = new UserControler();

        System.out.println("Emailnizi giriniz");
        email= scs.nextLine();
        System.out.println("Şifrenizi giriniz");
        password = scs.nextLine();

            if (userControler.getUserControl(email,password)){

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
                                        System.out.println("Güncellemek istediğiniz isminizi küçük harflerle giriniz.");
                                        name = scs.nextLine();
                                        userControler.usersUpdateName(name);
                                        break;
                                    case 2:
                                        System.out.println("Güncellemek istediğiniz soyisminizi küçük harflerle giriniz.");
                                        lastname = scs.nextLine();
                                        userControler.usersUpdateLastName(lastname);
                                        break;
                                    case 3:
                                        System.out.println("Güncellemek istediğiniz emailinizi küçük harflerle giriniz.");
                                        String email2 = scs.nextLine();
                                        userControler.usersUpdateMail(email2,email,password);
                                        break;
                                    case 4:
                                        System.out.println("Güncellemek istediğiniz şifrenizi küçük harflerle giriniz.");
                                        password = scs.nextLine();
                                        userControler.usersUpdatePassword(password);
                                        break;
                                    case 5:
                                        System.out.println("Emailinizi küçük harflerle giriniz.");
                                        email1 = scs.nextLine();
                                        System.out.println("şifrenizi giriniz.");
                                        password1 = scs.nextLine();
                                        userControler.createUsersService(email1,password1);
                                        break;
                                    case 6:
                                        userControler.getUsers();
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
                            while (loop3)
                            {
                                System.out.println("Lütfen bir işlem seçin: ");
                                System.out.println("1.Kategori yarat");
                                System.out.println("2.Kategori sil");
                                System.out.println("3.Kategorilere bak");
                                System.out.println("4.Çıkış");
                                choose3 = sci.nextInt();

                                switch (choose3) {
                                    case 1:
                                        System.out.println("Kategori yarat işlemi seçildi.");
                                        categoryControler.getCategory();
                                        System.out.println("Kategori ismini giriniz:");
                                        chooseS1 = scs.nextLine();
                                        categoryControler.createCategory(chooseS1);
                                        // Burada category create işlemleri yapılır.
                                        break;
                                    case 2:
                                        System.out.println("Kategori sil işlemi seçildi.");
                                        categoryControler.getCategory();
                                        System.out.println("Silmek istediğiniz kategori ismini giriniz:");
                                        chooseS3 = scs.nextLine();
                                        categoryControler.deleteCategory(chooseS3);
                                        // Burada category delete işlemleri yapılır.
                                        break;
                                    case 3:
                                        System.out.println("Kategori bak işlemi seçildi.");
                                        categoryControler.getCategory();
                                        break;
                                    case 4:
                                        System.out.println("Programdan çıkılıyor.");
                                        loop3 = false;
                                        break;
                                    default:
                                        System.out.println("Geçersiz bir seçenek girdiniz. Lütfen tekrar deneyin.");
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Çıkış yapılıyor...");
                            loop2 = false;
                            break;
                        default:
                            System.out.println("Hatalı seçim yeniden deneyiniz");
                            break;
                    } // switch
                } // while
            } // if
    } // main
} // class