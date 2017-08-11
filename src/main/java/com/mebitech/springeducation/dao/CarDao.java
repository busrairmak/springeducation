package com.mebitech.springeducation.dao;

import com.mebitech.springeducation.domain.Car;

import java.util.List;

/**
 * Created by alicankustemur on 11/08/2017.
 */
public interface CarDao {

    public void save(Car car);
    public void delete(Long id);
    public void update(Car car);
    public Car findById(Long id);
    public List<Car> findAll();

}
