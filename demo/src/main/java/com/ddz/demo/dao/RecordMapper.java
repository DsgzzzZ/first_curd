package com.ddz.demo.dao;

import com.ddz.demo.po.Record;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordMapper {
    int addRecord(Record record);

    Record getRecordByNumber(Integer number);
}
