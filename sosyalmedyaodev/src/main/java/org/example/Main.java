package org.example;

import org.example.controller.CommentController;
import org.example.controller.LikeController;
import org.example.controller.PostController;
import org.example.controller.UserController;
import org.example.entity.Comments;
import org.example.entity.Posts;
import org.example.entity.UserProfile;
import org.example.repository.UserRepository;
import org.example.utility.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserController userController=Singleton.getUserController();
        PostController postController=Singleton.getPostController();
        LikeController likeController=Singleton.getLikeController();
        CommentController commentController=Singleton.getCommentController();

        Scanner scannerscs=new Scanner(System.in);
        Scanner scannersci=new Scanner(System.in);


        boolean anaDongu=true;
        boolean altDongu1=true;
        int secenek1 ,secenek2,secenek3;
        String secenek6,secenek4,secenek5;
        String anaKullaniciAdi;
        String anaKullaniciSifre;

        while(anaDongu){

            System.out.println("Kullanıcı adını giriniz");
            anaKullaniciAdi=scannerscs.nextLine();
            System.out.println("Kullanıcı şiresini giriniz");
            anaKullaniciSifre=scannerscs.nextLine();

            UserProfile anaKullanici=userController.isExist(anaKullaniciAdi,anaKullaniciSifre);
            if(anaKullanici.getId()!=0){

                        while (altDongu1){
                            anaDongu = false;
                            System.out.println("1-> Post At");
                            System.out.println("2-> Post Yorumla ");
                            System.out.println("3-> Post Beğen ");
                            System.out.println("4-> Post ve Yorumlarını Gör");
                            System.out.println("5-> Çıkış");

                            secenek1=scannersci.nextInt();
                            switch (secenek1){
                                case 1:
                                    System.out.println("Post içeriğini yazınız");
                                    String postName=scannerscs.nextLine();
                                    postController.postSave(postName, anaKullanici.getId());
                                    break;
                                case 2:
                                    List<Posts> postsList = postController.getAll();
                                    UserProfile userProfile = new UserProfile();

                                    for (int i =0; i<postsList.size() ; i++){

                                        userProfile = userController.getByid(postsList.get(i).getOwnerId());
                                        System.out.println("Post ismi----->"+postsList.get(i).getPostName()+" Kullanıcı ismi----->"+userProfile.getUsername()
                                        +" Post id------>"+postsList.get(i).getId());
                                    }
                                    System.out.println("Yorumlamak istediğiniz postun id sini yazınız");
                                    secenek2 = scannersci.nextInt();
                                    System.out.println("Yorumunuzu yazınız");
                                    secenek4 = scannerscs.nextLine();

                                    Posts posts = new Posts();
                                    posts=postController.getById(secenek2);
                                    if (posts!=null){
                                       commentController.save(secenek4,anaKullanici.getId(),secenek2);
                                    }
                                    else {
                                        System.out.println("Böyle bir kullanıcı bulunamadı");
                                    }
                                    break;
                                case 3:
                                    List<Posts> postsList1 = postController.getAll();
                                    UserProfile userProfile1 = new UserProfile();

                                    for (int i =0; i<postsList1.size() ; i++){

                                        userProfile = userController.getByid(postsList1.get(i).getOwnerId());
                                        System.out.println("Post ismi----->"+postsList1.get(i).getPostName()+" Kullanıcı ismi----->"+userProfile.getUsername()
                                                +" Post id------>"+postsList1.get(i).getId());

                                    }
                                    System.out.println("beğenmek istediğiniz postun id sini yazınız");
                                    secenek3 = scannersci.nextInt();

                                    Posts posts1 = new Posts();
                                    posts=postController.getById(secenek3);

                                    if (posts!=null){
                                        likeController.save(anaKullanici.getId(),secenek3);
                                    }
                                    else {
                                        System.out.println("Böyle bir kullanıcı bulunamadı");
                                    }
                                    break;
                                case 4:
                                    List<UserProfile> userProfileList=userController.getAll();
                                    List<Posts> postsList2=postController.getAll();
                                    List<Comments> commentsList=commentController.getAll();

                                    for(int i=0;i<userProfileList.size();i++){
                                        for(int j=0;j<postsList2.size();j++){
                                            if(userProfileList.get(i).getId()==postsList2.get(j).getOwnerId()){
                                                System.out.println("*****************");
                                                System.out.print("Kullanıcı adı : ");
                                                System.out.println(userProfileList.get(i).getUsername());
                                                System.out.print("Post :: ");
                                                System.out.println(postsList2.get(j).getPostName());
                                                for(int z=0;z<commentsList.size();z++){
                                                    if(postsList2.get(j).getId()==commentsList.get(z).getPostId()){
                                                        System.out.println("                    Yorum ");
                                                        System.out.println("                    "+commentsList.get(z).getComments());
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    break;
                                case 5:
                                    altDongu1=false;
                                    break;
                                default:
                                    System.out.println("Hatalı seçim");
                            }
                        }
                     }
            else{
                System.out.println("KULLANICI BULUNAMADI  KAYIT OLUNUZ");
            }
        }
    }
}