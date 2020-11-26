package hiber.service;

import java.util.List;

public interface Service<T> {
    void add(T t);
    List<T> getAsList();
    void clear();
}
