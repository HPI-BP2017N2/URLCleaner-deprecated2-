package de.hpi.urlcleaner.api;

import de.hpi.urlcleaner.services.UrlCleanerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest

public class UrlCleanerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UrlCleanerService urlCleanerService;

    @Before
    public void setup() {
        given(urlCleanerService.cleanUrl(anyString(), anyLong())).willReturn("{\"oracleShopId\" : 123}");
    }


    @Test
    public void cleanURLExpectedOk() throws Exception {

        mockMvc.perform(get("/cleanURL").param("url", "http:111").param("shopID", "123"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"oracleShopId\" : 123}"));

    }

    @Test
    public void cleanURLParamMissing() throws Exception {

        mockMvc.perform(get("/cleanURL").param("url", "http:111")).andExpect(status().isBadRequest());

    }


}