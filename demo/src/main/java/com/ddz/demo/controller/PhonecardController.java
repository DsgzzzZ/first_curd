package com.ddz.demo.controller;

import com.ddz.demo.po.Phonecard;
import com.ddz.demo.po.Record;
import com.ddz.demo.service.PhonecardService;
import com.ddz.demo.service.RecordService;
import com.ddz.demo.utils.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Date;

@Controller
@RequestMapping("/phone")
public class PhonecardController {

    @Autowired
    PhonecardService phonecardService;

    @Autowired
    RecordService recordService;

    @RequestMapping("/ReceiveFlow")
    @ResponseBody
    public Param ReceiveFlow(@RequestBody Integer number) throws Exception{
        Integer status=null;
        String msg=null;
        Phonecard phonecard=phonecardService.getPhonebyNumber(number);
        Record record=recordService.getRecordByNumber(number);
//        System.out.println(phonecard==null);

        if(phonecard==null){
            status=1001;
            msg="领取失败!此号码不存在...";
        }else if(phonecard.getReceiveQualifications()==0){
            status=1002;
            msg="领取失败!此号码无领取资格...";
        }else if(record != null && record.getActivityType()== 1 ){
            status=1003;
            msg="领取失败!此号码已经领取过了...";
        }else if(record == null || record.getActivityType() !=1 ){
            status=200;
            msg="领取成功!";
//            设置record的参数，并更新到表中
            Record record1 = new Record();
            record1.setRecordNumber(number);
            record1.setActivityType(1);
            Date date = new Date();
            Timestamp tt=new Timestamp(date.getTime());
            record1.setrecordTime(tt);
            recordService.addRecord(record1);
//            设置phonecard的流量参数，并更新到表中
            phonecard.setSurplusFlow(phonecard.getSurplusFlow()+20);
            phonecardService.updatePhonecard(phonecard);
        }

        return new Param(status,msg,phonecard);
    }
}
