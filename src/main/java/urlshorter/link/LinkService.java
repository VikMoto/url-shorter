package urlshorter.link;

import java.util.List;

public interface LinkService {
    Link getByShortLink(String shortLink);
    void save(Link link);
    void update(Link link);
    void deleteByShortLink(String shortLink);
    List<Link> listAll();
    List<Link> search(String query);

}
