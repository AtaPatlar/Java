package Controler;

import Service.CategoryService;
import Service.UserService;
import Utility.Singleton;

import java.util.Scanner;

public class CategoryControler implements ICategoryControler{
    Scanner sci = new Scanner(System.in);
    Scanner scs = new Scanner(System.in);
    boolean loop1 = true, loop2 = true;
    int choose1;
    String chooseS1, chooseS3;
    UserService userService = Singleton.userService;
    CategoryService categoryService = Singleton.getCategoryService();
    public void userSeeCategory() {

        while (loop1)
        {
            System.out.println("Lütfen bir işlem seçin: ");
            System.out.println("1.Kategori yarat");
            System.out.println("2.Kategori sil");
            System.out.println("3.Kategorilere bak");
            System.out.println("4.Çıkış");
            choose1 = sci.nextInt();

            switch (choose1) {
                case 1:
                    System.out.println("Kategori yarat işlemi seçildi.");
                    categoryService.getCategory();
                    System.out.println("Kategori ismini giriniz:");
                    chooseS1 = scs.nextLine();
                    categoryService.createCategory(chooseS1);
                    // Burada category create işlemleri yapılır.
                    break;
                case 2:
                    System.out.println("Kategori sil işlemi seçildi.");
                    categoryService.getCategory();
                    System.out.println("Silmek istediğiniz kategori ismini giriniz:");
                    chooseS3 = scs.nextLine();
                    categoryService.deleteCategory(chooseS3);
                    // Burada category delete işlemleri yapılır.
                    break;
                case 3:
                    System.out.println("Kategori bak işlemi seçildi.");
                    categoryService.getCategory();
                    break;
                case 4:
                    System.out.println("Programdan çıkılıyor.");
                    loop1 = false;
                    break;
                default:
                    System.out.println("Geçersiz bir seçenek girdiniz. Lütfen tekrar deneyin.");
            }
        }
    }
}
