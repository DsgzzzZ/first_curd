package com.ddz.demo.controller;

import com.alibaba.fastjson.JSON;
import com.ddz.demo.dao.AuthorMapper;
import com.ddz.demo.dao.BlogMapper;
import com.ddz.demo.po.Author;
import com.ddz.demo.po.Blog;
import com.ddz.demo.utils.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthorController {
    @Autowired
    AuthorMapper authorMapper;

    @Autowired
    BlogMapper blogMapper;

    @RequestMapping("/getAuthor")
    @ResponseBody
    public String getAuthor(@RequestBody Integer id){
        Author author = authorMapper.getAuthor(id);
        return JSON.toJSONString(new Param(200,"调用成功！",author));
    }

    @RequestMapping("/getBlog")
    @ResponseBody
    public String getBlog(@RequestBody Integer id){
        Blog blog = blogMapper.getBlog(id);
        return JSON.toJSONString(new Param(200,"调用成功！",blog));
    }
}
