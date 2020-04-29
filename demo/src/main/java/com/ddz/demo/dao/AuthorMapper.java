package com.ddz.demo.dao;

import com.ddz.demo.po.Author;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AuthorMapper {
    Author getAuthor(Integer id);
}
