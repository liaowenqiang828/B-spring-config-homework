package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LevelController.class)
@TestPropertySource(locations = "classpath:test.properties")
@AutoConfigureMockMvc
public class LevelControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void should_return_basic_when_level_number_less_than_one() throws Exception {
        mockMvc.perform(get("/level"))
                .andExpect(jsonPath("$", is("basic")));

    }
}
