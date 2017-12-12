package forbaya.news.repository;

import forbaya.news.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Account repository interface.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    /**
     * Finds an account by username.
     *
     * @param username the username
     * @return the account
     */
    Account findByUsername(String username);
}
