package com.grapro.controller.carcheck;

import com.grapro.service.carcheck.CarCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carcheck/")
public class CarCheckController {

    @Autowired
    CarCheckService carCheckService;

    @RequestMapping("dataConversion.do")
    public void dataConversion(int index){
        carCheckService.dataConversion(index);
    }
}
