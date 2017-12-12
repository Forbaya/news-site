package forbaya.news.service;

import forbaya.news.domain.Account;
import forbaya.news.domain.Article;
import forbaya.news.domain.Category;
import forbaya.news.domain.Image;
import forbaya.news.repository.ArticleRepository;
import forbaya.news.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

/**
 * The article service for the article controller to use.
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private HttpSession session;

    /**
     * Adds a new article to the database.
     *
     * @param title         the title
     * @param image         the image
     * @param category      the category
     * @param leadParagraph the lead paragraph
     * @param bodyText      the body text
     */
    @Transactional
    public void add(String title, Image image, Category category, String leadParagraph, String bodyText) {
        Article article = new Article();
        article.setTitle(title);
        article.setImage(image);
        article.setCategory(category);
        article.setLeadParagraph(leadParagraph);
        article.setBodyText(bodyText);
        article.setReleaseDate(LocalDateTime.now());
        article.setAccount((Account) session.getAttribute("loggedAccount"));
        articleRepository.save(article);

        category.getArticles().add(article);
        categoryRepository.save(category);
    }
}
