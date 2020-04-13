package com.ddz.demo.service;

import com.ddz.demo.dao.RecordMapper;
import com.ddz.demo.po.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {
    @Autowired
    RecordMapper recordMapper;

    public int addRecord(Record record){
        return this.recordMapper.addRecord(record);
    }

    public Record getRecordByNumber(Integer number){
        return this.recordMapper.getRecordByNumber(number);
    }
}
