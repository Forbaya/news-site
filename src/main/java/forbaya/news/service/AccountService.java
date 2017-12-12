package forbaya.news.service;

import forbaya.news.domain.Account;
import forbaya.news.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

/**
 * Account service for the account controller to use.
 */
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private HttpSession session;

    /**
     * Adds a new account to the database.
     *
     * @param username the username
     * @param password the password
     * @param forename the forename
     * @param surname  the surname
     */
    @Transactional
    public void add(String username, String password, String forename, String surname) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setForename(forename);
        account.setSurname(surname);
        accountRepository.save(account);
    }

    /**
     * Logs an account in.
     *
     * @param username the username
     * @param password the password
     * @return true if login was successful, false otherwise
     */
    public boolean login(String username, String password) {
        Account account = accountRepository.findByUsername(username);
        if (account != null && account.getPassword().equals(password)) {
            session.setAttribute("loggedAccount", account);
            return true;
        }
        return false;
    }
}
