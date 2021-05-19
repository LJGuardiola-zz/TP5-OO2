package d;

import d.model.Blog;
import d.model.Post;
import d.persistence.file.PostFileRepository;
import d.persistence.jdbc.PostJdbcRepository;
import d.persistence.rest.RestPostDataSource;
import d.services.GsonParser;
import d.services.RestCaller;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Blog blog = new Blog(
                new PostJdbcRepository(
                        new PostFileRepository(
                                "posts.txt",
                                new RestPostDataSource(
                                        new RestCaller("https://jsonplaceholder.typicode.com/posts"),
                                        new GsonParser()
                                )
                        )
                )
        );

        List<Post> posts = blog.getAllPosts();

        blog.saveAllPost(posts);

    }
}
