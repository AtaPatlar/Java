package Controler;

import Entity.Category;
import Utility.Singleton;

import java.util.List;

public interface ICategoryControler {

    public boolean createCategory(String categoryName);

    public boolean deleteCategory(String categoryName);

    public Category getCategoryName(String categoryName);

    public List<Category> getCategory();
}
