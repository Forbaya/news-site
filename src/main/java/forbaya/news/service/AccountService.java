package forbaya.news.service;

import forbaya.news.domain.Account;
import forbaya.news.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private HttpSession session;

    @Transactional
    public void add(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        accountRepository.save(account);
    }

    public boolean login(String username, String password) {
        Account account = accountRepository.findByUsername(username);
        if (account != null && account.getPassword().equals(password)) {
            session.setAttribute("loggedAccount", account);
            return true;
        }
        return false;
    }
}
