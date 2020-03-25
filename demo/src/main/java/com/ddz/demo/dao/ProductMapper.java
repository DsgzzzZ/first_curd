package com.ddz.demo.dao;

import com.ddz.demo.po.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//声明是一个Mapper,与springboot中的@MapperScan二选一写上即可
//@Mapper
@Repository
public interface ProductMapper {
     List<Product> getProductList(Product product);

     int addProduct(Product product);

     int delProduct(Integer i);

     int updateProduct(Product product);
}
