package d.model.interfaces;

import d.model.Post;

import java.util.List;

public interface Parser {
    List<Post> parse(String json);
}
