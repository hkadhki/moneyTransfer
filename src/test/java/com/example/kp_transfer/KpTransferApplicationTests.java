package com.example.kp_transfer;

import com.example.kp_transfer.model.*;
import com.example.kp_transfer.repository.TransferRepository;
import com.example.kp_transfer.service.TransferService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KpTransferApplicationTests {

    static TransferService transferService;
    static TransferRepository transferRepository;
    @BeforeAll
    static void init(){
        transferRepository = new TransferRepository();
        transferService = new TransferService(transferRepository);
    }

    @Test
    void confirmServiceTest() throws InterruptedException {
        Transfer transfer = new Transfer(
                "0000000000000000",
                "12/24",
                "123",
                "0000000000000001",
                new Amount(100000, Currency.RUB)
        );
        transferService.getTransfer(transfer);
        SchemaConfirm schemaConfirm = new SchemaConfirm("1", "0000");
        SchemaResponse id = transferService.confirmOperation(schemaConfirm);
        Assertions.assertEquals(id.getOperationId(), "1");
    }

    @Test
    void serviceGetTransferTest(){
        Transfer transfer = new Transfer(
                "0000000000000000",
                "12/24",
                "123",
                "0000000000000001",
                new Amount(100000, Currency.RUB)
        );
        SchemaResponse id = transferService.getTransfer(transfer);
        Assertions.assertEquals(id.getOperationId(), "2");
    }


}
