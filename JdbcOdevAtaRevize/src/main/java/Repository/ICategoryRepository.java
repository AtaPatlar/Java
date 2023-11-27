package Repository;

import Entity.Category;

import java.util.List;

public interface ICategoryRepository {

    public boolean createCategory(String categoryName);
    public boolean deleteCategory(String categoryName);
    public Category categoryGetByName (String categoryName);
    public List<Category> getCategory();


}
