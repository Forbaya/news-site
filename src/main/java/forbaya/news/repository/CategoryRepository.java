package forbaya.news.repository;

import forbaya.news.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Category repository interface.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    /**
     * Finds a category by name.
     *
     * @param name the name
     * @return the category
     */
    Category findByName(String name);
}
