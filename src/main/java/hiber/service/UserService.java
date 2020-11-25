package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService extends Service<User>{

    @Override
    void add(User user);

    @Override
    List<User> getAsList();

    @Override
    void clear();
}
