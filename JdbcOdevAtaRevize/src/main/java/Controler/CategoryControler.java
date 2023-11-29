package Controler;

import Entity.Category;
import Service.CategoryService;
import Service.ICategoryService;
import Service.UserService;
import Utility.Singleton;

import java.util.List;
import java.util.Scanner;

public class CategoryControler implements  ICategoryControler {
    ICategoryService categoryService;

    public CategoryControler(){
        categoryService = Singleton.getCategoryService();
    }
    public boolean createCategory(String categoryName){
        categoryService.createCategory(categoryName);
        return true;
    }
    public boolean deleteCategory(String categoryName){
        categoryService.deleteCategory(categoryName);
        return true;
    }
    public Category getCategoryName(String categoryName){
       return categoryService.getCategoryName(categoryName);
    }
    public List<Category> getCategory() {
        return categoryService.getCategory();
    }
}
