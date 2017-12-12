package forbaya.news.service;

import forbaya.news.domain.Category;
import forbaya.news.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Category service for the category controller to use.
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Adds a new category to the database.
     *
     * @param name the name
     */
    public void add(String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
    }
}
