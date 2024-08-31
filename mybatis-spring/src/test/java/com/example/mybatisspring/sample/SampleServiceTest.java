package com.example.mybatisspring.sample;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
@Slf4j
class SampleServiceTest {

    @Autowired
    private SampleService sampleService;

    @Test
    public void testService1() {
        log.info("sampleServiceTest");
        Assertions.assertNotNull(sampleService);
    }
}