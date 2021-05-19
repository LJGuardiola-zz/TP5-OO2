package d.model;

import d.model.interfaces.Repository;

import java.util.List;

public class Blog {

    private final Repository<Post> repository;

    public Blog(Repository<Post> repository) {
        this.repository = repository;
    }

    public List<Post> getAllPosts() {
        return repository.get();
    }

    public void saveAllPost(List<Post> posts) {
        repository.save(posts);
    }

}
