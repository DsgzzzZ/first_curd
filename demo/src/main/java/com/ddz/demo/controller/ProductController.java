package com.ddz.demo.controller;

import com.ddz.demo.Exception.IllegalNameException;
import com.ddz.demo.dao.ProductMapper;
import com.ddz.demo.po.Bean;
import com.ddz.demo.po.Bean2;
import com.ddz.demo.po.Product;
import com.ddz.demo.utils.ObjectAndJson;
import com.ddz.demo.utils.ObjectStream;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.javafx.collections.MappingChange;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

//证明是controller层并且返回体不会在解析成页面路径
@Controller
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
    public String addProduct(@RequestBody Product product){
//        String s=request.getParameter("productId");
//        System.out.println(s);
//        System.out.println("addProducts方法!");
//        return "";
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
    public String delProduct( @RequestBody Integer i){
        System.out.println("delProduct方法!");
        int t = productMapper.delProduct(i);
        if(t != 1){
            return "删除失败!";
        }else{
            return "删除成功!";
        }
    }

    /*将此改变提交到github上*/

    @RequestMapping("/test1")
    @ResponseBody
    public String test1(String a,String b){
        return a+b;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public String test2(Product product){
        return product.toString();
    }

    @RequestMapping("/test3")
    @ResponseBody
    public String test3(HttpServletRequest request){
        String s1=request.getParameter("a");
        String s2=request.getParameter("b");
        return "调用成功!";
    }

    @RequestMapping("/test4")
    @ResponseBody
    public String test4(@RequestBody String[] a){

        return a[0]+a[1]+a[2];
    }

    @RequestMapping("bodytest1")
    @ResponseBody
    public String bodytest1(@RequestBody String array,String array2){
        return array+array2;
    }

    @RequestMapping("bodytest2")
    @ResponseBody
    public String bodytest2(Bean2 bean2){
        return bean2.toString();
    }

    @RequestMapping("paramtest1")
    @ResponseBody
    public String paramtest1(@RequestParam(value = "array[]") String[] array){
        return array[0]+array[1]+array[2];

    }

    @RequestMapping("filetest1")
    @ResponseBody
    public String filetest1(MultipartFile file){
        return file.getOriginalFilename();
    }

    @RequestMapping("requesttest1")
    @ResponseBody
    public String requesttest1(HttpServletRequest request){
        String s=request.getParameter("a");
        return s;
    }

    @GetMapping("gettest1")
    @ResponseBody
    public String gettest1(Bean bean){
        return bean.toString();
    }

    @GetMapping("/gettest2/{str1}/{str2}")
    @ResponseBody
    public String gettest2(@PathVariable("str1") String st1,@PathVariable("str2") String st2){
        return st1+st2;
    }

    @RequestMapping("/listtest1")
    @ResponseBody
    public String listtest1(Bean[] bean){
        return bean[0].toString();
    }

    @RequestMapping("/listtest2")
    @ResponseBody
    public String listtest2(@RequestBody List<Bean> list){
        return list.toString();
    }

    @RequestMapping("/maptest1")
    @ResponseBody
    public String maptest1(Map<String,String> map){
        return  map.get("a");
    }

    @RequestMapping("/arraytest1")
    @ResponseBody
    public String arraytest1(@RequestParam(value = "id")Integer[] id,@RequestParam(value = "name")String[] name,@RequestParam(value = "gender")String[] gender){
        for(int i=0;i<3;i++){
            System.out.println("id["+i+"]: "+id[i]);
            System.out.println("name["+i+"]: "+name[i]);
            System.out.println("gender["+i+"]: "+gender[i]);
        }
        return "调用成功!";
    }


    //下面这个是为了测试事务的,通过是否回滚来判断事务是否有效,postman返回结果可以看到输出提示.
    @RequestMapping("/transactionalTest1")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class,timeout = 30,propagation = Propagation.REQUIRED)
    public String transactionalTest1(@RequestBody Product product){
        productMapper.addProduct(product);
        if (product.getProductName().equals("鼠标")){
              throw  new IllegalNameException("非法字符,添加失败.将进行回滚!!!");
        }
        return product.toString();
    }

    @RequestMapping("/transactionalTest2")
    @ResponseBody
    @Transactional(noRollbackFor = Exception.class,timeout = 30,propagation = Propagation.REQUIRED)
    public String transactionalTest2(@RequestBody Product product){
        productMapper.addProduct(product);
        if(product.getProductName().equals("鼠标")){
            throw new IllegalNameException("合法字符,添加成功,不进行回滚!!!");
        }
        return product.toString();
    }

    //测试fastJson的使用
    @RequestMapping("/fastjson1")
    @ResponseBody
    public String fastjson1(){
        ObjectAndJson oaj = new ObjectAndJson();
        oaj.StringToJson();
        return "测试成功!";
    }

    @RequestMapping("/fastjson2")
    @ResponseBody
    public String fastjson2(){
        ObjectAndJson oaj1 = new ObjectAndJson();
        oaj1.jsontoString();
        return "测试成功!";
    }

    //测试从request请求里得到的json数据
    @RequestMapping("/fastjson3")
    @ResponseBody
    public String fastjson3(HttpServletRequest request)throws IOException {
        new ObjectAndJson().getRequestQueryParams(request);
        return "测试成功!";
    }

    //测试从request请求里获得头部信息
    @RequestMapping("/fastjson4")
    @ResponseBody
    public String fastjson4(HttpServletRequest request){
        new ObjectAndJson().getRequestHeaderParams(request);
        return "测试成功!";
    }

    //测试对象的序列化
    @RequestMapping("/SerializableTest1")
    @ResponseBody
    public String SerializableTest1(@RequestBody Bean bean)throws Exception{
        new ObjectStream().objecttoSerializable(bean);
        return "序列化成功!";
    }

    //测试将对象反序列化
    @RequestMapping("/SerializableTest2")
    @ResponseBody
    public String SerializableTest2() throws Exception{
        Bean bean=new ObjectStream().serializableToObject();
        return bean.toString();
    }

}
