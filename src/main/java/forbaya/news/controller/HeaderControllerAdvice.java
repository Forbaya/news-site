package forbaya.news.controller;

import forbaya.news.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Header controller advice to get the categories to the header fragment.
 */
@ControllerAdvice
public class HeaderControllerAdvice extends ResponseEntityExceptionHandler {
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Adds the categories to the model, so they can be seen in the header fragment.
     *
     * @param model the model
     * @return header.html view
     */
    @ModelAttribute
    public String showCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "fragments/header :: header";
    }
}
