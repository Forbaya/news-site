package forbaya.news.controller;

import forbaya.news.repository.ArticleRepository;
import forbaya.news.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/article/new")
    public String getNewArticle(Model model) {
        model.addAttribute("articles", articleRepository.findAll());
        return "newArticle";
    }

    @PostMapping("/article/new")
    public String postNewArticle(@RequestParam String title, @RequestParam String leadParagraph, @RequestParam String bodyText) {
        articleService.add(title, leadParagraph, bodyText);
        return "redirect:/article/new";
    }

    @GetMapping("/article/{id}")
    public String getArticle(Model model, @PathVariable Long id) {
        model.addAttribute("article", articleRepository.getOne(id));
        return "article";
    }
}
