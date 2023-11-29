package Service;
import Entity.Category;
import Repository.CategoryRepository;
import Repository.ICategoryRepository;
import Utility.Singleton;

import java.util.List;

public class CategoryService implements  ICategoryService{

    ICategoryRepository categoryRepository;

    public CategoryService(){
        categoryRepository = Singleton.getCategoryRepository();
    }

    public boolean createCategory(String categoryName){
            if (categoryRepository.categoryGetByName(categoryName).getId()==0){
                categoryRepository.createCategory(categoryName);
                return true;
            }
            else {
                System.out.println("Bu kategori mevcuttur");
            }
            return false;
    }

    public boolean deleteCategory(String categoryName){

        if (categoryRepository.categoryGetByName(categoryName).getId()==0){
            System.out.println("Bu kategori mevcut değildir");
        }
        else {
            categoryRepository.deleteCategory(categoryName);
            return true;
        }
        return false;
    }

    public Category getCategoryName(String categoryName){
        if (categoryRepository.categoryGetByName(categoryName).getId()==0){
            System.out.println("Bu kategori mevcut değil");
            return null;
        }
        else {
            return categoryRepository.categoryGetByName(categoryName);
        }

    }
    public List<Category> getCategory() {
        return  categoryRepository.getCategory();
    }
}
