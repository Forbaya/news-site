package forbaya.news.controller;

import forbaya.news.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * The default controller.
 */
@Controller
public class DefaultController {
    @Autowired
    private HttpSession session;
    @Autowired
    private ArticleRepository articleRepository;

    /**
     * Handles default GET requests.
     *
     * @param model the model
     * @return the index.html view
     */
    @GetMapping("*")
    public String handleDefault(Model model) {
        model.addAttribute("newestArticles", articleRepository.findAll(new PageRequest(0, 5, Sort.Direction.DESC, "releaseDate")));
        return "index";
    }
}
