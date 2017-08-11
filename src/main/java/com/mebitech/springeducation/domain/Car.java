package com.mebitech.springeducation.domain;

import com.mebitech.springeducation.ColorEnum;

import javax.persistence.*;

/**
 * Created by alicankustemur on 11/08/2017.
 */



@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private Integer model;

    @Enumerated(EnumType.STRING)
    @Column
    private ColorEnum color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }
}
