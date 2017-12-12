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

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category/new")
    public String getNewCategory() {
        return "newCategory";
    }

    @PostMapping("/category/new")
    public String postNewCategory(@RequestParam String name) {
        categoryService.add(name);
        return "redirect:/";
    }

    @GetMapping("/category/{name}")
    public String getCategory(Model model, @PathVariable String name) {
        Category category = categoryRepository.findByName(name);
        model.addAttribute("category", category);
        model.addAttribute("articles", category.getArticles());
        return "category";
    }
}
