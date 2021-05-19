package d.persistence.rest;

import d.model.Post;
import d.model.interfaces.Caller;
import d.model.interfaces.Parser;
import d.model.interfaces.Repository;

import java.util.List;

public class RestPostDataSource implements Repository<Post> {

    private final Caller caller;
    private final Parser parser;

    public RestPostDataSource(Caller caller, Parser parser) {
        this.caller = caller;
        this.parser = parser;
    }

    @Override
    public List<Post> get() {
        return parser.parse(
                caller.run()
        );
    }

    @Override
    public void save(List<Post> posts) {
        System.out.println("Saved");
    }

}
