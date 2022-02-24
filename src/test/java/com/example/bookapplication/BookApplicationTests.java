package com.example.bookapplication;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class BookApplicationTests {

    @Value("${test.property.name}")
    private String testName;

    @Autowired
    private DataSource source;

    @Test
    void valueExists() {
        assertThat(testName).isEqualTo("book");
        log.info(testName);
    }

    @Test
    void applicationCanConnectToDatabaseTest() {
        assertThat(source);
        Connection connection;
        try {
            connection = source.getConnection();
            assertThat(connection).isNotNull();
            log.info("Connection --> {}", connection.getSchema());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
