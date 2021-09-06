package com.ArthurNeyman.testTaskForAlfaBank.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class controllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void currencyCorrectAnswerTest() throws Exception {

        mockMvc.perform(get("/currency/USD"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.IMAGE_GIF_VALUE));

        mockMvc.perform(get("/currency/eur"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.IMAGE_GIF_VALUE));

        mockMvc.perform(get("/currency/eeee"))
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType(MediaType.IMAGE_GIF_VALUE))
                .andExpect(content().bytes(new byte[]{}));

        mockMvc.perform(get("/currency/"))
                .andExpect(status().is4xxClientError());
    }


}
