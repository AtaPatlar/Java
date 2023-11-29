package Service;

import Entity.Category;

import java.util.List;

public interface ICategoryService {

    public boolean createCategory(String categoryName);
    public boolean deleteCategory(String categoryName);
    public Category getCategoryName(String categoryName);
    public List<Category> getCategory();

}
