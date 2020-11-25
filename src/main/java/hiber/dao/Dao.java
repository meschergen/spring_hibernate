package hiber.dao;

import java.util.List;

public interface Dao<T> {
    void add(T t);
    List<T> getAsList();
    void clear();
}
