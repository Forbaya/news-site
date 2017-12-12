package forbaya.news.repository;

import forbaya.news.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Image repository interface.
 */
public interface ImageRepository extends JpaRepository<Image, Long> {
}
