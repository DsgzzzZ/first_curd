package com.ddz.demo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ddz.demo.po.Bean;
import com.ddz.demo.po.Bean2;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/*
*  此类用来测试json对象和自定义对象之间的转换
* */
public class ObjectAndJson {

    /*字符串转换成json*/

    public void StringToJson(){
//       简单Bean转化为Json
        Bean bean1 = new Bean("aa1","bb1");
        String beanJson = JSON.toJSONString(bean1);
        System.out.println("Bean对象转化为Json对象的结果:"+ beanJson);

//        简单Bean的list转化为Json
        Bean bean2 = new Bean("aa2","bb2");
        Bean bean3 = new Bean("aa3","bb3");
        Bean[] beanList = {bean2,bean3};
        String beanJsonList = JSON.toJSONString(beanList);
        System.out.println("Bean数组转化为Json的结果:"+beanJsonList);

//        复杂Bean转化为Json
        Bean2 bean21 = new Bean2("a1","b1",bean1,beanList);
        String bean2Json = JSON.toJSONString(bean21);
        System.out.println("复杂Bean对象转化为Json的结果:"+bean2Json);
    }

    /*
      *Json转化为字符串
      *  */
    public void jsontoString(){
//        json转化为简单bean
        String jsonbean = new String("{'a':'aa1','b':'bb1'}");
        Bean bean1 = JSONObject.parseObject(jsonbean,Bean.class);
        System.out.println("json转化为简单bean"+bean1);
//        json转化为复杂bean
        String jsonbeans = new String("{'a':'a1','b':'b1','bean':{'a':'aa1','b':'bb1'},'beans':[{'a':'aaa1','b':'bbb1'},{'a':'aaa2','b':'bbb2'}]}");
        Bean2 bean2 = JSONObject.parseObject(jsonbeans,Bean2.class);
        System.out.println("json转化为复杂bean"+bean2);
    }

    /*
    * 得到request请求里的body参数的类型并转化为json数据
    * */
    public void getRequestQueryParams(HttpServletRequest request) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream(),"UTF-8"));
        StringBuilder stringBuilder = new StringBuilder();
        String str;
        while((str=bufferedReader.readLine())!=null){
            stringBuilder.append(str);
        }
        JSONObject jsonObject = JSONObject.parseObject(stringBuilder.toString());
        System.out.println("从request请求里得到的json数据为:"+jsonObject);
        Bean bean = JSONObject.parseObject(jsonObject.toJSONString(),Bean.class);
        System.out.println("再将其转化为Bean对象后的数据为:"+bean.toString());
    }

    /*
    * 得到request请求里的头部参数;
    * */
    public void getRequestHeaderParams(HttpServletRequest request){
        String str1 = request.getHeader("token");
        System.out.println("获取指定的头信息:"+str1);

        Map map = new HashMap();
        Enumeration headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headName = (String) headerNames.nextElement();
            String headValue = request.getHeader(headName);
            map.put(headName,headValue);
        }

        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(map));
        System.out.println("获得所有的头信息:"+jsonObject.toString());

    }

}
