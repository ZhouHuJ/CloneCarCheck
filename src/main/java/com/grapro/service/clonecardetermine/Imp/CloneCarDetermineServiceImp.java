package com.grapro.service.clonecardetermine.Imp;

import com.grapro.api.PicIo;
import com.grapro.mapper.CarDistinguishMapper;
import com.grapro.mapper.CarRegisterMapper;
import com.grapro.mapper.CloneCarMapper;
import com.grapro.pojo.CarDistinguish;
import com.grapro.pojo.CarRegister;
import com.grapro.pojo.CloneCar;
import com.grapro.service.clonecardetermine.CloneCarDetermineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CloneCarDetermineServiceImp implements CloneCarDetermineService {
    @Autowired
    CarDistinguishMapper carDistinguishMapper;
    @Autowired
    CarRegisterMapper carRegisterMapper;
    @Autowired
    CloneCarMapper cloneCarMapper;

    @Override
    public void cloneCarCheck(int cardistinguishid,String picturelocaladdress) {
        CarDistinguish carDistinguish = carDistinguishMapper.selectById(cardistinguishid);
        CarRegister carRegister = carRegisterMapper.selectByCarNumber(carDistinguish.getCarnumber());
        CloneCar cloneCar =new CloneCar();
        cloneCar.setCardistinguishid(cardistinguishid);
        if(carRegister == null){
            System.out.println("是套牌车");
            try {
                cloneCar.setPicturelocaladdress(PicIo.copyFile(picturelocaladdress,"D:\\ideaproject\\cloneCarCheck\\src\\main\\webapp\\carimg\\clonecar"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            cloneCar.setClonecarstatus(2);
            cloneCarMapper.addCloneCar(cloneCar);
        }else if(!carDistinguish.getLicenseplatecolor().equalsIgnoreCase(carRegister.getLicenseplatecolor()) || !carDistinguish.getCarcolor().equalsIgnoreCase(carRegister.getCarcolor())  || !carDistinguish.getCarbrand().equalsIgnoreCase(carRegister.getCarbrand())){
            System.out.println("可能是套牌车");
            try {
                cloneCar.setPicturelocaladdress(PicIo.copyFile(picturelocaladdress,"D:\\ideaproject\\cloneCarCheck\\src\\main\\webapp\\carimg\\clonecar"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            cloneCar.setClonecarstatus(1);
            cloneCarMapper.addCloneCar(cloneCar);
        }else {
            System.out.println("不是套牌车");
            carDistinguishMapper.delectById(cardistinguishid);
        }
    }

}
