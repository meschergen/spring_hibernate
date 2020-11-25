package hiber.service;

import hiber.model.Car;

import java.util.List;

public interface CarService extends Service<Car>{
    @Override
    void add(Car car);

    @Override
    List<Car> getAsList();

    @Override
    void clear();
}
