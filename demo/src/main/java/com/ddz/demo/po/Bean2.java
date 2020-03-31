package com.ddz.demo.po;

import java.util.Arrays;
import java.util.List;

public class Bean2 {
    private String a;
    private String b;
    private Bean bean;
    private Bean[] beans;

    public Bean2(){}

    public Bean2(String a, String b, Bean bean, Bean[] beans) {
        this.a = a;
        this.b = b;
        this.bean = bean;
        this.beans = beans;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public Bean getBean() {
        return bean;
    }

    public void setBean(Bean bean) {
        this.bean = bean;
    }

    public Bean[] getBeans() {
        return beans;
    }

    public void setBeans(Bean[] beans) {
        this.beans = beans;
    }

    @Override
    public String toString() {
        return "Bean2{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", bean=" + bean +
                ", beans=" + Arrays.toString(beans) +
                '}';
    }
}
