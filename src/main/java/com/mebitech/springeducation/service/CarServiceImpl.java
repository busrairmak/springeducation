package com.mebitech.springeducation.service;

import com.mebitech.springeducation.dao.CarDao;
import com.mebitech.springeducation.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarServiceImpl implements CarService{
    @Autowired
    private CarDao carDao;
    @Override
    public void create(Car car) {
        carDao.save(car);
        System.out.println(car.getName()+"saved.");

    }

    @Override
    public void remove(Long id) {
        carDao.delete(id);
        System.out.println(" Car deleted.");



    }

    @Override
    public void edit(Long id, Car car) {
//        Car willBeUpdatedCar=carDao.findById(id);
//        willBeUpdatedCar.setName(car.getName());
//        willBeUpdatedCar.setModel(car.getModel());
//        willBeUpdatedCar.setColor(car.getColor());
//        carDao.update(willBeUpdatedCar);
        car.setId(id);
        carDao.update(car);
        System.out.println(car.getName()+" updated.");

    }

    @Override
    public List<Car> getAll() {
        System.out.println("All cars listed.");
        return carDao.findAll();
    }

    @Override
    public Car get(Long id) {
        System.out.println("Get car by id:"+id);
        return carDao.findById(id);
    }
}
