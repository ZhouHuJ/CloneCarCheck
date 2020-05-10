package com.grapro.service.carcheck.Imp;

import com.grapro.api.BaidudanaocarcheckSample;
import com.grapro.api.BaidudanaochenumberSample;
import com.grapro.api.PicIo;
import com.grapro.mapper.CarDistinguishMapper;
import com.grapro.pojo.CarDistinguish;
import com.grapro.service.carcheck.CarCheckService;
import com.grapro.service.clonecardetermine.CloneCarDetermineService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;

@Service
public class CarCheckServiceImp implements CarCheckService {
    @Autowired
    BaidudanaochenumberSample baidudanaochenumberSample;
    @Autowired
    BaidudanaocarcheckSample baidudanaocarcheckSample;
    @Autowired
    CarDistinguishMapper carDistinguishMapper;
    @Autowired
    CloneCarDetermineService cloneCarDetermineService;

    @Override
    public void dataConversion(int index) {
        // 百度大脑车牌识别接口
        HashMap<String, String> option1 = new HashMap();
        option1.put("multi_detect", "true");

        String image = "D:\\ideaproject\\cloneCarCheck\\src\\main\\webapp\\videocaptureimg\\" + index + ".png";
        JSONObject resAipOcr = baidudanaochenumberSample.getClient().plateLicense(image, option1);
        System.out.println(resAipOcr.toString(2));

        // 百度大脑车辆识别接口
        HashMap<String, String> option2 = new HashMap();
        option2.put("top_num", "3");

        JSONObject resAipImageClassify = baidudanaocarcheckSample.getClient().carDetect(image,option2);
        System.out.println(resAipImageClassify.toString(2));

        //将识别的车辆信息添加到车辆识别表
        CarDistinguish carDistinguish = new CarDistinguish();
        if(resAipOcr.getInt("error_code") == 0 ){
            carDistinguish.setCarnumber(resAipOcr.getJSONArray("words_result").getJSONObject(0).getString("number"));
            carDistinguish.setLicenseplatecolor(resAipOcr.getJSONArray("words_result").getJSONObject(0).getString("color"));
            carDistinguish.setCarcolor(resAipImageClassify.getString("color_result"));
            carDistinguish.setCarbrand(resAipImageClassify.getJSONArray("result").getJSONObject(0).getString("name"));
            int cardistinguishid = carDistinguishMapper.addCarDistinguish(carDistinguish);
            try {
                cloneCarDetermineService.cloneCarCheck(cardistinguishid,PicIo.copyFile(image,"D:\\ideaproject\\cloneCarCheck\\src\\main\\webapp\\carimg\\cardistinguish"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            File file = new File(image);
            file.delete();
        }
    }
}
