package forbaya.news.service;

import forbaya.news.domain.Article;
import forbaya.news.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    public void add(String leadParagraph, String bodyText) {
        Article article = new Article();
        article.setLeadParagraph(leadParagraph);
        article.setBodyText(bodyText);
        articleRepository.save(article);
    }
}
