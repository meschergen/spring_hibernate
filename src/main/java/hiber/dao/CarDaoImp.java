package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void add(Car car) { sessionFactory.getCurrentSession().save(car); }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getAsList() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("FROM Car car JOIN FETCH car.user user");
        return query.getResultList();
    }

    @Override
    public void clear() {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM Car").executeUpdate();
        sessionFactory.getCurrentSession().createSQLQuery("ALTER TABLE cars AUTO_INCREMENT = 1").executeUpdate();
    }
}
