package Controler;

import Entity.Category;
import Service.ICategoryService;
import Utility.Singleton;

import java.util.List;

public class CategoryController implements  ICategoryController {
    ICategoryService categoryService;

    public CategoryController(){
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
