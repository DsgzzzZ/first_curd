package com.ddz.demo.po;

import java.sql.Timestamp;

public class Record {
    private Integer recordId;
    private Integer recordNumber;
    private Integer activityType;
    private Timestamp recordTime;

    public Record() {
    }

    public Record(Integer recordId, Integer recordNumber, Integer activityType, Timestamp recordTime) {
        this.recordId = recordId;
        this.recordNumber = recordNumber;
        this.activityType = activityType;
        this.recordTime = recordTime;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(Integer recordNumber) {
        this.recordNumber = recordNumber;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Timestamp getRecordTime() {
        return recordTime;
    }

    public void setrecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }

    @Override
    public String toString() {
        return "record{" +
                "recordId=" + recordId +
                ", recordNumber=" + recordNumber +
                ", activityType=" + activityType +
                ", recordTime=" + recordTime +
                '}';
    }
}
