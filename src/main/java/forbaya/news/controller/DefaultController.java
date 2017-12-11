package forbaya.news.controller;

import forbaya.news.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DefaultController {
    @Autowired
    private HttpSession session;
    @GetMapping("*")
    public String handleDefault(Model model) {
        Account account = (Account) session.getAttribute("loggedAccount");
        if (account != null) {
            model.addAttribute("account", account);
        }
        return "index";
    }
}
