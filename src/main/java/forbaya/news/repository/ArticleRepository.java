package forbaya.news.repository;

import forbaya.news.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Article repository interface.
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
