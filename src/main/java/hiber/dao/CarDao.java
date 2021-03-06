package hiber.dao;

import hiber.model.Car;

import java.util.List;

public interface CarDao extends Dao<Car> {

    @Override
    void add(Car car);

    @Override
    List<Car> getAsList();

    @Override
    void clear();
}
