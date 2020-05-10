package com.grapro.controller.policeuser;

import com.grapro.pojo.CarRegister;
import com.grapro.pojo.CloneCar;
import com.grapro.pojo.PoliceUser;
import com.grapro.service.policeuser.PoliceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/policeuser/")
public class PoliceUserController {
    @Autowired
    PoliceUserService policeUserService;

    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public String login(HttpServletRequest request, PoliceUser policeUser){
        String policename = policeUser.getPolicename();
        String policepassword = policeUser.getPolicepassword();
        System.out.println(policename);
        System.out.println(policepassword);
        PoliceUser policeUserResult = policeUserService.selectBypolicename(policename);
        HttpSession session = request.getSession();
        if (policeUserResult == null){
            session.setAttribute("errorinfo", "用户不存在");
            return "redirect:http://localhost:8080";
        }else if(!policeUserResult.getPolicepassword().equals(policepassword)){
            session.setAttribute("errorinfo", "密码错误");
            return "redirect:http://localhost:8080";
        }else{
            session.setAttribute("policeuser", policeUserResult);
            session.removeAttribute("errorinfo");
            return  "homepage";
        }
    }

    @RequestMapping("selectByclonecarstatus.do")
    public String selectByclonecarstatus(HttpServletRequest request){
        List<CloneCar> list = policeUserService.selectByclonecarstatus(1);
        request.setAttribute("clonecarlist",list);
        return "clonecarlist";
    }

    @RequestMapping("toCarRegister.do")
    public String toCarRegister(){
        return "carregister";
    }

    @RequestMapping(value = "carRegister.do",method = RequestMethod.POST)
    public String carRegister(CarRegister carRegister){
        policeUserService.addCarRegister(carRegister);
        return "homepage";
    }

    @RequestMapping("updateClonecar.do")
    public String updateClonecar(CloneCar cloneCar){
        policeUserService.updateClonecar(cloneCar);
        return  "redirect:/policeuser/selectByclonecarstatus.do";
    }
}
