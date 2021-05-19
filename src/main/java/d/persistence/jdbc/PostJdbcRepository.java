package d.persistence.jdbc;

import d.model.Post;
import d.model.interfaces.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PostJdbcRepository implements Repository<Post> {

    private final static JdbcConnectionManager CONNECTION_MANAGER = JdbcConnectionManager.getInstance();

    private final Repository<Post> repository;

    public PostJdbcRepository(Repository<Post> repository) {
        this.repository = repository;
    }

    @Override
    public List<Post> get() {
        return repository.get();
    }

    @Override
    public void save(List<Post> posts) {
        try (
                Connection connection = CONNECTION_MANAGER.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO POSTS (ID, USER_ID, TITLE, BODY) VALUES (?, ?, ?, ?)"
                )
        ) {

            for (Post post : posts) {
                preparedStatement.setInt(1, post.getId());
                preparedStatement.setInt(2, post.getUserId());
                preparedStatement.setString(3, post.getTitle());
                preparedStatement.setString(4, post.getBody());
                preparedStatement.executeUpdate();
                preparedStatement.clearParameters();
            }

        } catch (SQLException e) {
            throw new RuntimeException("No se pudo registrar en la base de datos", e);
        } finally {
            if (repository != null)
                repository.save(posts);
        }
    }

}
