package forbaya.news.service;

import forbaya.news.domain.Article;
import forbaya.news.domain.Image;
import forbaya.news.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    public void add(String title, String leadParagraph, String bodyText, Image image) {
        Article article = new Article();
        article.setTitle(title);
        article.setLeadParagraph(leadParagraph);
        article.setBodyText(bodyText);
        article.setReleaseDate(LocalDateTime.now());
        article.setImage(image);
        articleRepository.save(article);
    }
}
