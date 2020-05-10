package com.grapro.mapper;

import com.grapro.pojo.CarDistinguish;

public interface CarDistinguishMapper {
    int addCarDistinguish(CarDistinguish carDistinguish);

    CarDistinguish selectById(int id);

    void delectById(int id);
}
