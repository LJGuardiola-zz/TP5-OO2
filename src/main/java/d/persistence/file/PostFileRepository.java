package d.persistence.file;

import d.model.Post;
import d.model.interfaces.Repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PostFileRepository implements Repository<Post> {

    private final File file;
    private final Repository<Post> repository;

    public PostFileRepository(String file, Repository<Post> repository) {
        this.file = new File(file);
        this.repository = repository;
    }

    @Override
    public List<Post> get() {
        return repository.get();
    }

    @Override
    public void save(List<Post> posts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (Post post : posts)
                writer.write(
                        post.getUserId() + "| " + post.getId() + "| " + post.getTitle() + "| " + post.getBody() + "\n"
                );
        } catch (IOException e) {
            throw new RuntimeException("No se pudo escribir en el archivo de ventas.", e);
        }
        repository.save(posts);
    }

}
