package forbaya.news.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * Article entity.
 */
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
    @Column(length = 1000000)
    private Account account;
    @Column(length = 1000000)
    private Image image;
    @Column(length = 1000000)
    private Category category;
}
