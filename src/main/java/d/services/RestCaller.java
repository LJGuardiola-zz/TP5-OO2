package d.services;

import d.model.interfaces.Caller;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class RestCaller implements Caller {

    private final String URL;

    public RestCaller(String URL) {
        this.URL = URL;
    }

    @Override
    public String run() {
        try (
                Response response = new OkHttpClient().newCall(
                        new Request.Builder().url(URL).build()
                ).execute()
        ) {
            return Objects.requireNonNull(
                    response.body()
            ).string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
