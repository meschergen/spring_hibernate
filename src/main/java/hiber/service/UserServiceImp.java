package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> getAsList() {
      return userDao.getAsList();
   }

   @Transactional
   @Override
   public void clear() { userDao.clear(); }

   @Transactional
   @Override
   public List<User> getByCarModel(String model){ return userDao.getByCarModel(model); }

   @Transactional
   @Override
   public User getByCarSeries(Long series){ return userDao.getByCarSeries(series); }
}
