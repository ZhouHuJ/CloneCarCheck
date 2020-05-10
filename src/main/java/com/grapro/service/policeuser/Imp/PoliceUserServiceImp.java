package com.grapro.service.policeuser.Imp;

import com.grapro.mapper.CarRegisterMapper;
import com.grapro.mapper.CloneCarMapper;
import com.grapro.mapper.PoliceUserMapper;
import com.grapro.pojo.CarRegister;
import com.grapro.pojo.CloneCar;
import com.grapro.pojo.PoliceUser;
import com.grapro.service.policeuser.PoliceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliceUserServiceImp implements PoliceUserService {
    @Autowired
    PoliceUserMapper policeUserMapper;
    @Autowired
    CarRegisterMapper carRegisterMapper;
    @Autowired
    CloneCarMapper cloneCarMapper;

    @Override
    public PoliceUser selectBypolicename(String policename) {
        return policeUserMapper.selectBypolicename(policename);
    }

    @Override
    public void addCarRegister(CarRegister carRegister) {
        carRegisterMapper.addCarRegister(carRegister);
    }

    public List<CloneCar> selectByclonecarstatus(int clonecarstatus){
        return  cloneCarMapper.selectByclonecarstatus(clonecarstatus);
    }

    public void updateClonecar(CloneCar cloneCar){
        cloneCarMapper.updateClonecar(cloneCar);
    }
}
