package forbaya.news.controller;

import forbaya.news.repository.AccountRepository;
import forbaya.news.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private HttpSession session;

    private boolean loginFailed;

    @PostConstruct
    public void initialize() {
        loginFailed = false;
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("accounts", accountRepository.findAll());
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam String username, @RequestParam String password, @RequestParam String forename, @RequestParam String surname) {
        accountService.add(username, password, forename, surname);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        if (loginFailed) {
            model.addAttribute("loginFailed", new ArrayList<>().add("true"));
        }
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam String username, @RequestParam String password) {
        boolean loginSuccess = accountService.login(username, password);
        if (loginSuccess) {
            loginFailed = false;
            return "redirect:/";
        }
        loginFailed = true;
        return "redirect:/login";
    }
}
