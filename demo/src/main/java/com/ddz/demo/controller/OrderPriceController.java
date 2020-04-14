package com.ddz.demo.controller;

import com.ddz.demo.po.Order;
import com.ddz.demo.po.Price;
import com.ddz.demo.po.User;
import com.ddz.demo.service.Impl.OrderServiceImpl;
import com.ddz.demo.service.Impl.PriceServiceImpl;
import com.ddz.demo.service.Impl.UserServiceImpl;
import com.ddz.demo.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Api(value = "预约产品",description = "预约产品API",position = 1, protocols = "http")
@Controller
public class OrderPriceController {
    @Autowired
    OrderServiceImpl orderService;
    @Autowired
    PriceServiceImpl priceService;
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/toOrder")
    public String toOrder(){
        return "index";
    }

    @RequestMapping(value = "/orderprice",method= RequestMethod.POST)
    public String orderprice(@ModelAttribute(value = "user") User user, Model model) throws Exception{
        String path=null;
        Integer userId=null;
        Order order=null;
        User user1=userService.getUserByNumber(user.getPhoneNumber());

        if(user1 == null){
            User user2=new User();
            user2.setUsername("dx");
            user2.setPhoneNumber(user.getPhoneNumber());
            user2.setBlacklist(0);
            userService.addUser(user2);
            model.addAttribute("msg","预约成功！");

            userId=userService.getUserIdByNumber(user.getPhoneNumber());

            Order order1=new Order();
            order1.setUserId(userId);
            java.util.Date date = new java.util.Date();
            Timestamp tt=new Timestamp(date.getTime());
            order1.setOrderTime(tt);
            order1.setIsPrice(0);
            orderService.addOrder(order1);

            path="index";
        }


        if(user1 != null){
            userId=userService.getUserIdByNumber(user.getPhoneNumber());
            order=orderService.getOrder(userId);

            if(user1.getBlacklist()== 1 ){
                model.addAttribute("msg","此用户为黑名单!");
                path="index";
            }else if(order.getIsPrice() == 1 && order != null){
                path="redirect:/toPrice?userId="+userId;
            }else if(order.getIsPrice() == 0 && order != null){
                model.addAttribute("msg","你已经预约过了，请勿重复预约！");
                path="index";
            }
        }

        return path;

//        if(user1 == null){
//            model.addAttribute("msg","此用户不存在!");
//            path="index";
//        }else if(user1.getBlacklist() == 1){
//            model.addAttribute("msg","此用户为黑名单!");
//            path="index";
//        }else if(order == null){
//            Order order1=new Order();
//            order1.setUserId(userId);
//            java.util.Date date = new java.util.Date();
//            Timestamp tt=new Timestamp(date.getTime());
//            order1.setOrderTime(tt);
//            order1.setIsPrice(0);
//            orderService.addOrder(order1);
//            model.addAttribute("msg","预约成功！");
//            path="index";
//        }else if(order.getIsPrice() == 1 && order != null){
//            path="redirect:/toPrice?userId="+userId;
//        }else if(order.getIsPrice() == 0 && order != null){
//            model.addAttribute("msg","你已经预约过了，请勿重复预约！");
//            path="index";
//        }
//
//        return path;
    }

    @RequestMapping("/toPrice")
    public String toPrice(Model model, HttpServletRequest request) throws Exception{
//        User user=(User) model.getAttribute("user1");
//        Integer userId=(Integer)model.getAttribute("userId");
//        System.out.println(user.toString());
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        List<Price> prices=priceService.getPriceByUserId(userId);
        model.addAttribute("prices",prices);
        return "price";
    }

    @RequestMapping("/prices")
    public String prices(Model model){
        List<Price> prices=priceService.getAllPrice();
        model.addAttribute("prices",prices);
        return "price";
    }

//    @RequestMapping("/pricetest")
//    @ResponseBody
//    public String pricetest(){
//        int size;
//        int random;
//        Order order;
//        List<Integer> userIdList = orderService.getAllUserIdIfNoPrice();
//        for(int i=0;i<3;i++){
//            size=userIdList.size();
//            random = (int)(Math.random()*size);
//            order=orderService.getOrder(userIdList.get(random));
//            if(order.getIsPrice() == 0 ){
//                Price price=new Price();
//                price.setUserId(userIdList.get(random));
//                Date date=new Date(new java.util.Date().getTime());
//                price.setpriceTime(date);
//                price.setAward("小公仔");
//                priceService.addPrice(price);
//                order.setIsPrice(1);
//                orderService.updateOrder(order);
//            }
//        }
//        return "调用成功！";
//    }
}
