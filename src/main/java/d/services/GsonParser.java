package d.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import d.model.interfaces.Parser;
import d.model.Post;

import java.util.List;

public class GsonParser implements Parser {

    @Override
    public List<Post> parse(String json) {
        return new Gson().fromJson(json, new TypeToken<List<Post>>(){}.getType());
    }

}
