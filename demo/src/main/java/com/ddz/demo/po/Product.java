package com.ddz.demo.po;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Product {
    @NotNull(message = "产品编号不能为空！")
    private Integer productId;

    @Length(min = 2,max = 10,message = "产品名称必须大于2个字符且小于10个字符！！！")
    private String productName;

    @NotEmpty(message = "产品类型不能为空")
    private String productType;

    @Min(value = 0 ,message = "价格不能低于0元！")
    private Integer price;

    @NotEmpty(message = "产品类型不能为空！")
    private Integer stock;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
