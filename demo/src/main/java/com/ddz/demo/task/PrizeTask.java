package com.ddz.demo.task;

import com.ddz.demo.po.Order;
import com.ddz.demo.po.Price;
import com.ddz.demo.service.OrderService;
import com.ddz.demo.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Random;


/*
* 这是一个定时任务，每天10点会自动进行中奖名单的公布，即把数据插入到Price表中
* */
@Component
public class PrizeTask {

    @Autowired
    OrderService orderService;
    @Autowired
    PriceService priceService;


    @Scheduled(cron = "0 0/1 18 * * ?")
    public void PrizeAnnounce(){
        int size;
        int random;
        Order order;
        List<Integer> userIdList = orderService.getAllUserIdIfNoPrice();
        if(userIdList.size()>0){
            for(int i=0;i<2;){
                size=userIdList.size();
                random = new Random().nextInt(size);
                order=orderService.getOrder(userIdList.get(random));
                if(order.getIsPrice() == 0 ){
                    Price price=new Price();
                    price.setUserId(userIdList.get(random));
                    Date date=new Date(new java.util.Date().getTime());
                    price.setpriceTime(date);
                    price.setAward("小公仔");
                    priceService.addPrice(price);
                    order.setIsPrice(1);
                    orderService.updateOrder(order);
                    userIdList.remove(random);
                    i++;
                }
            }
        }

    }
}
