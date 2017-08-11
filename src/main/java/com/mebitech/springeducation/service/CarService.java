package com.mebitech.springeducation.service;

import com.mebitech.springeducation.domain.Car;

import java.util.List;

public interface CarService {
    public void create(Car car);
    public void  remove(Long id);
    public void edit(Long id,Car car);
    public List<Car> getAll();
    public Car get(Long id);
}
