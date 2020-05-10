package com.grapro.service.policeuser;

import com.grapro.pojo.CarRegister;
import com.grapro.pojo.CloneCar;
import com.grapro.pojo.PoliceUser;

import java.util.List;

public interface PoliceUserService {
    PoliceUser selectBypolicename(String policename);

    void addCarRegister(CarRegister carRegister);

    List<CloneCar> selectByclonecarstatus(int clonecarstatus);

    void updateClonecar(CloneCar cloneCar);
}
