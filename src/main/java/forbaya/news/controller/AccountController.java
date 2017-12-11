package forbaya.news.controller;

import forbaya.news.repository.AccountRepository;
import forbaya.news.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("accounts", accountRepository.findAll());
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam String username, @RequestParam String password) {
        accountService.add(username, password);
        return "redirect:/register";
    }
}
