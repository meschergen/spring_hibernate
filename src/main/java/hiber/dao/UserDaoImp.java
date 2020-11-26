package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) { sessionFactory.getCurrentSession().save(user); }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> getAsList() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User user JOIN FETCH user.car car");
      return query.getResultList();
   }

   @Override
   public void clear() {
      sessionFactory.getCurrentSession().createQuery("DELETE FROM User").executeUpdate();
   }

   @Override
   @SuppressWarnings("unchecked")
   public User getByCarSeries(Long series){
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User user JOIN FETCH user.car car WHERE car.series = :carSeries");
      query.setParameter("carSeries", series);
      return query.getSingleResult();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> getByCarModel(String model){
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User user JOIN FETCH user.car car WHERE car.model = :carModel");
      query.setParameter("carModel", model);
      return query.getResultList();
   }


}
