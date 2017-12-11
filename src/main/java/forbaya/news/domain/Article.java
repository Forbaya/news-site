package forbaya.news.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article extends AbstractPersistable<Long> {
    private String title;
    @Size(max = 1000)
    private String leadParagraph;
    @Size(max = 15000)
    private String bodyText;
    private LocalDateTime releaseDate;
    @ManyToMany
    private List<Account> accounts;
}
