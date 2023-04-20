package urlshorter.link;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.lang.annotation.Target;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "link")
public class Link {
    @Id
    @Column(name = "short_link")
    String shortLink;

    String link;

    @Column(name = "open_count")
    int openCount;
}
