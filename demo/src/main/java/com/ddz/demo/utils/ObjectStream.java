package com.ddz.demo.utils;

import com.ddz.demo.po.Bean;

import java.io.*;
import java.util.Date;

public class ObjectStream {
//    该方法可以把对象进行序列化存入文件,或者从文件中读取对象并反序列化成对象
    public void objecttoSerializable(Bean bean)throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("E:\\TestFile\\objectFile.txt"));
        objectOutputStream.writeObject("Hello World!");
        objectOutputStream.writeObject(new Date());
        objectOutputStream.writeObject(bean);
        objectOutputStream.close();
    }

//    该方法可以把文件中的对象流反序列化为对象并返回
    public Bean serializableToObject()throws Exception{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E:\\TestFile\\objectFile.txt"));
        String str=(String)objectInputStream.readObject();
        Date date =(Date)objectInputStream.readObject();
        Bean bean=(Bean)objectInputStream.readObject();
        return bean;
    }
}
