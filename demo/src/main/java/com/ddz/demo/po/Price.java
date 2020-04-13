package com.ddz.demo.po;

import java.sql.Date;

public class Price {
    private Integer priceId;
    private Integer userId;
    private Date priceTime;
    private String award;

    public Price() {
    }

    public Price(Integer priceId, Integer userId, Date priceTime, String award) {
        this.priceId = priceId;
        this.userId = userId;
        this.priceTime = priceTime;
        this.award = award;
    }

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getpriceTime() {
        return priceTime;
    }

    public void setpriceTime(Date priceTime) {
        this.priceTime = priceTime;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    @Override
    public String toString() {
        return "Price{" +
                "priceId=" + priceId +
                ", userId=" + userId +
                ", priceTime=" + priceTime +
                ", award='" + award + '\'' +
                '}';
    }
}
