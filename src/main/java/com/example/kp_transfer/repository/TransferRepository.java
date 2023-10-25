package com.example.kp_transfer.repository;

import com.example.kp_transfer.model.SchemaConfirm;
import com.example.kp_transfer.model.SchemaResponse;
import com.example.kp_transfer.model.Transfer;
import com.example.kp_transfer.service.TransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TransferRepository {
    private Map<Integer, Transfer> transfers = new HashMap<>();
    private AtomicInteger id = new AtomicInteger(0);
    private static final Logger logger = LoggerFactory.getLogger(TransferService.class);

    public SchemaResponse getTransfer(Transfer transfer){
        id.getAndIncrement();
        transfers.put(id.intValue(), transfer);
        logger.info("new transfer id:" + id);
        return new SchemaResponse(id.toString());
    }

    public SchemaResponse confirmOperation(SchemaConfirm schemaConfirm){
        Integer confirmId = Integer.parseInt(schemaConfirm.getOperationId());
        transfers.get(confirmId).setDone(true);
        logger.info("transfer id:" + schemaConfirm.getOperationId() + " - confirm");
        return new SchemaResponse(schemaConfirm.getOperationId());
    }

}
