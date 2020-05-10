package com.grapro.mapper;

import com.grapro.pojo.CloneCar;

import java.util.List;

public interface CloneCarMapper {
    CloneCar selectById(int id);

    void addCloneCar(CloneCar cloneCar);

    List<CloneCar> selectByclonecarstatus(int clonecarstatus);

    void updateClonecar(CloneCar cloneCar);
}
