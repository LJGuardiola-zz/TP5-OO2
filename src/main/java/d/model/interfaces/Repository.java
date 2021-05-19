package d.model.interfaces;

import java.util.List;

public interface Repository<T> {
    List<T> get();
    void save(List<T> data);
}
