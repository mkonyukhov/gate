package com.mkonyukhov.gate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnStatusIsNotFound() throws Exception {
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders
                        .put("/test/" + "not UUID")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content("{\"name\":\"name\", \"sum\":\"1\", \"multiplier\":\"2\"}");

        mockMvc.perform(builder)
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
