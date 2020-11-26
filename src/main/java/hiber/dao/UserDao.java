package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao extends Dao<User>{

   @Override
   void add(User user);

   @Override
   List<User> getAsList();

   @Override
   void clear();
}
