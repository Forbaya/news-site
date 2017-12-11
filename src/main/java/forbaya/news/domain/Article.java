package forbaya.news.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article extends AbstractPersistable<Long> {
    private String leadParagraph;
    private String text;
    private LocalDate releaseDate;
}
