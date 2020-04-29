package com.ddz.demo.dao;

import com.ddz.demo.po.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BlogMapper {
    Blog getBlog(Integer id);
}
