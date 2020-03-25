package com.ddz.demo.controller;

import com.ddz.demo.dao.ProductMapper;
import com.ddz.demo.po.Product;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//证明是controller层并且返回json
@RestController
@RequestMapping("/Products")
public class ProductController {
    //依赖注入
    @Autowired
    ProductMapper productMapper;

    @RequestMapping("/hello")
    @ResponseBody
    public void hello(){
        System.out.println("Hello World!");
    }

    @RequestMapping(value = "/getProducts")
    @ResponseBody
    public PageInfo<Product> getProducts(@Valid @RequestBody Product product){
        System.out.println("getProducts方法!");
        PageHelper.startPage(1,2);
        List<Product> list=productMapper.getProductList(product);
        PageInfo<Product> pageInfo=new PageInfo<Product>(list);
        return pageInfo;
    }

    @RequestMapping(value = "/addProduct")
    @ResponseBody
    public String addProducts(@Valid @RequestBody Product product){
        System.out.println("addProducts方法!");
        int i = productMapper.addProduct(product);
        if(i != 1){
            return "添加失败!";
        }
        else return "添加成功!";
    }

    @RequestMapping(value = "/updateProduct")
    @ResponseBody
    public String updateProduct(@RequestBody Product product){
        int i = productMapper.updateProduct(product);
        if(i != 1){
            return "修改失败!";
        }else{
            return "修改成功!";
        }
    }

    @RequestMapping(value = "/delProduct")
    @ResponseBody
    public String delProduct(@RequestBody Integer i){
        System.out.println("delProduct方法!");
        int t = productMapper.delProduct(i);
        if(t != 1){
            return "删除失败!";
        }else{
            return "删除成功!";
        }
    }
}
