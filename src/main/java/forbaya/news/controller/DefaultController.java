package forbaya.news.controller;

import forbaya.news.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DefaultController {
    @Autowired
    private HttpSession session;
    @GetMapping("*")
    public String handleDefault() {
        return "index";
    }
}
