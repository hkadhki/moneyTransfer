package com.example.kp_transfer;

import com.example.kp_transfer.model.Amount;
import com.example.kp_transfer.model.Currency;
import com.example.kp_transfer.model.SchemaResponse;
import com.example.kp_transfer.model.Transfer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.convert.converter.GenericConverter;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {
    @Autowired
    TestRestTemplate restTemplate;
    private static final GenericContainer<?> myApp = new GenericContainer<>("myapp:latest").withExposedPorts(5500);

    @BeforeAll
    public static void setUp(){
        myApp.start();
    }
    @AfterAll
    public static void setDown(){
        myApp.stop();
    }


    @Test
    void appDoTransferTest(){
        Transfer transfer = new Transfer(
                "0000000000000000",
                "12/24",
                "123",
                "0000000000000001",
                new Amount(100000, Currency.RUB)
        );
        SchemaResponse response = restTemplate.postForObject("http://localhost:" + myApp.getMappedPort(5500) + "/transfer",transfer, SchemaResponse.class);
        Assertions.assertEquals(response.getOperationId(), 1 + "");
    }
}
