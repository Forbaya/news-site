package forbaya.news.controller;

import forbaya.news.domain.Category;
import forbaya.news.domain.Image;
import forbaya.news.repository.ArticleRepository;
import forbaya.news.repository.CategoryRepository;
import forbaya.news.repository.ImageRepository;
import forbaya.news.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * The article controller.
 */
@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private HttpSession session;

    /**
     * Handles GET /article/new
     *
     * @param model the model
     * @return newArticle.html view
     */
    @GetMapping("/article/new")
    public String getNewArticle(Model model) {
        model.addAttribute("images", imageRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "newArticle";
    }

    /**
     * Handles POST /article/new
     *
     * @param title         the title of an article
     * @param image         the image of an article
     * @param category      the category of an article
     * @param leadParagraph the lead paragraph of an article
     * @param bodyText      the body text of an article
     * @return redirects to /
     */
    @PostMapping("/article/new")
    public String postNewArticle(@RequestParam String title, @RequestParam Image image, @RequestParam Category category, @RequestParam String leadParagraph, @RequestParam String bodyText) {
        articleService.add(title, image, category, leadParagraph, bodyText);
        return "redirect:/";
    }

    /**
     * Handles GET /article/{id}
     *
     * @param model the model
     * @param id the id
     * @return article.html view
     */
    @GetMapping("/article/{id}")
    public String getArticle(Model model, @PathVariable Long id) {
        model.addAttribute("article", articleRepository.getOne(id));
        return "article";
    }
}
