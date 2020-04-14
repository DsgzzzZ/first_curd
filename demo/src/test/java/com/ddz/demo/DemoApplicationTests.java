package com.ddz.demo;

import com.ddz.demo.controller.ProductController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
class DemoApplicationTests {

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception{
        mockMvc= MockMvcBuilders.standaloneSetup(new ProductController()).build();
    }

    @Test
    void contextLoads() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/demo/Products/test1?a=1&b=2")
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }

}
