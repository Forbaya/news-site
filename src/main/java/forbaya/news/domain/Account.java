package forbaya.news.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Account entity.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Account extends AbstractPersistable<Long> {
    private String username;
    private String password;
    @OneToMany
    private List<Article> articles;
    private String forename;
    private String surname;
}
