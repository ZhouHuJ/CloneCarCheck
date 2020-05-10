package com.grapro.mapper;

import com.grapro.pojo.CarRegister;

public interface CarRegisterMapper {
    CarRegister selectByCarNumber(String carnumber);

    void addCarRegister(CarRegister carRegister);
}
