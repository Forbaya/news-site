package forbaya.news.controller;

import forbaya.news.domain.Category;
import forbaya.news.repository.CategoryRepository;
import forbaya.news.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * The category controller.
 */
@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private HttpSession session;

    /**
     * Handles GET /category/new
     *
     * @return newCategory.html view
     */
    @GetMapping("/category/new")
    public String getNewCategory() {
        return "newCategory";
    }

    /**
     * Handles POST /category/new
     *
     * @param name the name of the category
     * @return redirects to /
     */
    @PostMapping("/category/new")
    public String postNewCategory(@RequestParam String name) {
        categoryService.add(name);
        return "redirect:/";
    }

    /**
     * Handles GET /category/{name}
     *
     * @param model the model
     * @param name the name of the category
     * @return category.html view
     */
    @GetMapping("/category/{name}")
    public String getCategory(Model model, @PathVariable String name) {
        Category category = categoryRepository.findByName(name);
        model.addAttribute("category", category);
        model.addAttribute("articles", category.getArticles());
        return "category";
    }
}
