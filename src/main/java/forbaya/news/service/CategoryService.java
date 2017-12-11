package forbaya.news.service;

import forbaya.news.domain.Category;
import forbaya.news.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void add(String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
    }
}
