package Repository;

import Entity.Category;
import Entity.Users;
import Utility.DbConnect;
import Utility.Singleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    DbConnect dbConnect;
    Connection connection = null;
    public CategoryRepository(){
        dbConnect = Singleton.getDbConnect();
    }

    public boolean createCategory(String categoryName){

        String createCategory = "insert into category(name) values('"+categoryName+"')";
        connection = dbConnect.getConnection();
        try {
            PreparedStatement ps = connection.prepareCall(createCategory);
            ps.executeUpdate();
            System.out.println(categoryName +" Kategorisi oluşturuldu.");
            return true;
        }
        catch (SQLException s){
            s.printStackTrace();
            System.out.println("Kategori oluşturulamadı");
        }
        finally {
            dbConnect.closeConnection(connection);
        }
        return false;
    }

    public boolean deleteCategory(String categoryName){

        String deleteCategory = "delete from category where name = '"+categoryName+"'";
        connection = dbConnect.getConnection();

        try {
            PreparedStatement ps = connection.prepareCall(deleteCategory);
            ps.executeUpdate();
            System.out.println(categoryName +" Kategorisi silindi.");
            return true;
        }

        catch (SQLException s){
        s.printStackTrace();
            System.out.println("Kategori silinemedi");
        }
        finally {
            dbConnect.closeConnection(connection);
        }
        return false;
    }

    public Category categoryGetByName (String categoryName){


        String Sql1 = "select * from category where name = '"+categoryName+"'";
        connection = dbConnect.getConnection();


        try {
            PreparedStatement ps = connection.prepareCall(Sql1);
            ResultSet resultSet = ps.executeQuery();
            Category category = new Category();

            while (resultSet.next()){
            category.setId(resultSet.getInt("id"));
            category.setCategoryName(resultSet.getString("name"));
            System.out.println(category);
            }

            return category;
        }
        catch (SQLException s){
            s.printStackTrace();
            System.out.println("Kategori ismi getirilemedi");
        }
        finally {
            dbConnect.closeConnection(connection);
        }
return null;
    }

    public List<Category> getCategory(){


        String getCategory = "Select * from category";
        connection = dbConnect.getConnection(); // connetion açtık
        List<Category> categoryList = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareCall(getCategory);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){

                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("name"));

               categoryList.add(category);
               System.out.println(category);
            }
            return categoryList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Liste getirilemedi");
        }
        finally {
            dbConnect.closeConnection(connection);
        }
        return null;
    }




}
