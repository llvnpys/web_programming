package com.example.springjpa;

import lombok.Cleanup;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
@Slf4j
class SpringJpaApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testConnection() throws Exception{

        @Cleanup
        Connection connection = dataSource.getConnection();

        log.info(connection.toString());

        Assertions.assertNotNull(connection);

    }



    @Test
    void contextLoads() {
    }

}
